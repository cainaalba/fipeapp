package service

import java.util.Scanner

class TipoVeiculo {
    fun tipoVeiculo(codigoTabelaReferencia: Int) {
        val scanner = Scanner(System.`in`)

        println("\nDigite o tipo do veículo que deseja buscar:")
        println(
            " 1 -> Carros e Utilitários\n" +
                    " 2 -> Motos\n" +
                    " 3 -> Caminhões e Micro-Ônibus"
        )
        when (val codigoTipoVeiculo = scanner.nextLine().toInt()) {
            1, 2, 3 -> {
                println("\nDeseja buscar por código FIPE? (S/N)")
                val pergunta = scanner.nextLine()

                if (pergunta.equals("S", true)) {
                    val consultarPorCodigoFipe = ConsultarValorComTodosParametros()
                    consultarPorCodigoFipe.consultarPorCodigoFipe(codigoTabelaReferencia, codigoTipoVeiculo)
                } else {
                    val consultarMarcas = ConsultarMarcas()
                    consultarMarcas.consultar(codigoTabelaReferencia, codigoTipoVeiculo)
                }
            }

            else -> {
                println("\nTipo de veículo inválido!")
                tipoVeiculo(codigoTabelaReferencia)
            }
        }
        scanner.close()
    }
}