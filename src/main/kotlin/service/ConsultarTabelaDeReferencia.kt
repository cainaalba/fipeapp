package service

import interfaces.RequestInterface
import com.fasterxml.jackson.databind.ObjectMapper
import interfaces.ProcessaErroInterface
import model.*
import okhttp3.*
import okhttp3.internal.EMPTY_REQUEST
import java.util.*

class ConsultarTabelaDeReferencia : RequestInterface, ProcessaErroInterface {
    fun consultar() {
        val scanner = Scanner(System.`in`)

        val endPoint = "http://veiculos.fipe.org.br/api/veiculos/ConsultarTabelaDeReferencia"
        val requestBody: RequestBody = EMPTY_REQUEST
        val responseBody = request(requestBody.toString(), endPoint)

        val resultado = runCatching {
            val mesReferencia: Array<ConsultarTabelaDeReferenciaModel> =
                ObjectMapper().readValue(responseBody, Array<ConsultarTabelaDeReferenciaModel>::class.java)
            for (mes in mesReferencia.indices.reversed()) {
                println(mesReferencia[mes].toString())
            }

            println("\nDigite o código do mês de referência para buscar:")
            val codigoTabelaReferencia = scanner.nextLine().toInt()

            val tipoVeiculo = TipoVeiculo()
            tipoVeiculo.tipoVeiculo(codigoTabelaReferencia)
        }

        resultado.onFailure {
            processar(responseBody)
        }

        scanner.close()
    }
}