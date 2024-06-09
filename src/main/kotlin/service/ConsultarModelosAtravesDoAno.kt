package service

import interfaces.MontarJsonInterface
import interfaces.RequestInterface
import com.fasterxml.jackson.databind.ObjectMapper
import interfaces.ProcessaErroInterface
import model.ConsultarModelosModel
import java.util.Scanner

class ConsultarModelosAtravesDoAno : RequestInterface, MontarJsonInterface, ProcessaErroInterface {
    fun buscar(json: Map<String, Any>, codigoMarca: Int, anoModelo: Int) {
        val scanner = Scanner(System.`in`)

        val updaterJson = json.toMutableMap()
        updaterJson["anoModelo"] = anoModelo
        updaterJson["codigoMarca"] = codigoMarca
        val jsonString = montaJson(updaterJson)

        val endPoint = "http://veiculos.fipe.org.br/api/veiculos/ConsultarModelosAtravesDoAno"
        val responseBody = request(jsonString, endPoint)
        val resultado = runCatching {
            val modelos: Array<ConsultarModelosModel> = ObjectMapper().readValue(responseBody, Array<ConsultarModelosModel>::class.java)
            for (modelo in modelos) {
                println(modelo.toString())
            }

            println("\nDigite o código do modelo:")
            val codigoModelo = scanner.nextInt()
            val consultarAnoModelo = ConsultarAnoModelo()
            consultarAnoModelo.consultar(updaterJson, codigoModelo)
        }
        resultado.onFailure {
            processar(responseBody)
        }

        scanner.close()
    }
}