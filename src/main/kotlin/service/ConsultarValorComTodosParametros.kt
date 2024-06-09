package service

import com.fasterxml.jackson.databind.ObjectMapper
import interfaces.MontarJsonInterface
import interfaces.ProcessaErroInterface
import interfaces.RequestInterface
import model.ConsultarValorComTodosParametrosModel
import java.util.*

class ConsultarValorComTodosParametros : RequestInterface, MontarJsonInterface, ProcessaErroInterface {
    fun consultar(json: Map<String, Any>, codigoAnoCombustivel: String) {
        val scanner = Scanner(System.`in`)

        val anoCombustivelParse = codigoAnoCombustivel.split("-")
        val ano = anoCombustivelParse[0]
        val codigoCombustivel = anoCombustivelParse[1]

        val updaterJson = json.toMutableMap()
        updaterJson["ano"] = codigoAnoCombustivel
        updaterJson["codigoTipoCombustivel"] = codigoCombustivel
        updaterJson["anoModelo"] = ano
        updaterJson["tipoConsulta"] = "tradicional"

        val endPoint =
            "http://veiculos.fipe.org.br/api/veiculos/ConsultarValorComTodosParametros"
        val jsonString = montaJson(updaterJson)
        val responseBody = request(jsonString, endPoint)

        val resultado = runCatching {
            val consultarValorComTodosParametrosModel =
                ObjectMapper().readValue(responseBody, ConsultarValorComTodosParametrosModel::class.java)

            println(consultarValorComTodosParametrosModel.toString())

            val continuarConsulta = ContinuarConsulta()
            continuarConsulta.continuar()
        }

        resultado.onFailure {
            processar(responseBody)
        }

        scanner.close()
    }
}