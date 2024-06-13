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
        updaterJson["anoModelo"] = ano
        updaterJson["ano"] = codigoAnoCombustivel
        updaterJson["codigoTipoCombustivel"] = codigoCombustivel
        updaterJson["tipoConsulta"] = "tradicional"
        val jsonString = montaJson(updaterJson)
        processarRequisicao(jsonString)
        scanner.close()
    }

    fun consultarPorCodigoFipe(codigoTabelaReferencia: Int, codigoTipoVeiculo: Int) {
        val scanner = Scanner(System.`in`)

        println("Informe o código FIPE: ")
        val codigoFipe = scanner.nextLine()

        println("Digite o ano do veículo:")
        val anoModelo = scanner.nextLine()

        val json = mapOf(
            "codigoTabelaReferencia" to codigoTabelaReferencia,
            "codigoTipoVeiculo" to codigoTipoVeiculo,
            "anoModelo" to anoModelo.toInt(),
            "modeloCodigoExterno" to codigoFipe.toString(),
            "tipoConsulta" to "codigo"
        )
        val jsonString = montaJson(json)
        processarRequisicao(jsonString)
    }

    private fun processarRequisicao(jsonString: String) {
        val endPoint =
            "http://veiculos.fipe.org.br/api/veiculos/ConsultarValorComTodosParametros"
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
    }


}