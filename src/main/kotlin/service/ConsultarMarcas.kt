package service

import interfaces.MontarJsonInterface
import interfaces.ProcessaErroInterface
import interfaces.RequestInterface
import com.fasterxml.jackson.databind.ObjectMapper
import model.ConsultarMarcasModel
import java.util.Scanner

class ConsultarMarcas : RequestInterface, MontarJsonInterface, ProcessaErroInterface {
    fun buscar(mesReferenciaEntrada: Int, tipoVeiculoEntrada: Int) {
        val scanner = Scanner(System.`in`)

        val endPoint = "http://veiculos.fipe.org.br/api/veiculos/ConsultarMarcas"

        val json = mapOf(
            "codigoTabelaReferencia" to mesReferenciaEntrada,
            "codigoTipoVeiculo" to tipoVeiculoEntrada
        )
        val jsonString = montaJson(json)
        val responseBody = request(jsonString, endPoint)

        val resultado = runCatching {
            val marcas: Array<ConsultarMarcasModel> = ObjectMapper().readValue(responseBody, Array<ConsultarMarcasModel>::class.java)
            for (marca in marcas) {
                println(marca.toString())
            }

            println("\nDigite o código da marca:")
            val codigoMarca = scanner.nextInt()

            println("\nPara continuar, selecione uma das opções abaixo:")
            println(
                "1 -> Buscar todos os modelos da marca Marca\n" +
                        "2 -> Buscar os modelos por Ano/Modelo"
            )
            val opcao = scanner.nextInt()

            when (opcao) {
                1 -> {
                    val consultarModelos = ConsultarModelos()
                    consultarModelos.buscar(json, codigoMarca)
                }

                2 -> {
                    println("\nDigite o ano:")
                    val ano = scanner.nextInt()
                    val consultarModelosAtravesDoAno = ConsultarModelosAtravesDoAno()
                    consultarModelosAtravesDoAno.buscar(json, codigoMarca, ano)
                }

                else -> {
                    println("\nOpção inválida. Tente novamente")
                    buscar(mesReferenciaEntrada, tipoVeiculoEntrada)
                }
            }
        }

        resultado.onFailure {
            processar(responseBody)
        }

        scanner.close()
    }
}