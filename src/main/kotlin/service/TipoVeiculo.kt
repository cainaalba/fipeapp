package service

import java.util.Scanner

class TipoVeiculo {
    fun tipoVeiculo(codigoTabelaReferencia: Int) {
        val scanner = Scanner(System.`in`)
        when (val codigoTipoVeiculo = informarTipoVeiculo()) {
            1, 2, 3 -> {
                println("\nDeseja buscar por código FIPE? (S/N)")
                val pergunta = scanner.nextLine()

                if (pergunta.equals("s", true)) {
                    val consultarPorCodigoFipe = ConsultarPorCodigoFipe()
                    consultarPorCodigoFipe.consultar(
                        codigoTabelaReferencia,
                        codigoTipoVeiculo
                    )
                } else {
                    val consultarMarcas = ConsultarMarcas()
                    consultarMarcas.consultar(
                        codigoTabelaReferencia,
                        codigoTipoVeiculo
                    )
                }
            }

            else -> {
                println("\nTipo de veículo inválido!")
                tipoVeiculo(codigoTabelaReferencia)
            }
        }
        scanner.close()
    }

    private fun informarTipoVeiculo(): Int {
        val scanner = Scanner(System.`in`)

        println("\nDigite o tipo do veículo que deseja buscar:")
        println(
            " 1 -> Carros e Utilitários\n" +
                    " 2 -> Motos\n" +
                    " 3 -> Caminhões e Micro-Ônibus"
        )
        val codigoTipoVeiculo = scanner.nextLine()
        return codigoTipoVeiculo.toInt()
    }
}