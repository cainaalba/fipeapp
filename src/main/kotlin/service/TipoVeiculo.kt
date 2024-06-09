package service

import java.util.Scanner

class TipoVeiculo {
    fun tipoVeiculo(mesReferenciaEntrada: Int) {
        val scanner = Scanner(System.`in`)

        println("\nDigite o tipo do veículo que deseja buscar:")
        println(
            " 1 -> Carros\n" +
                    " 2 -> Motos\n" +
                    " 3 -> Caminhões"
        )

        val tipoVeiculoEntrada = scanner.nextInt()

        if (tipoVeiculoEntrada != 1 &&
            tipoVeiculoEntrada != 2 &&
            tipoVeiculoEntrada != 3
        ) {
            println("\nTipo de veículo inválido!")
            tipoVeiculo(mesReferenciaEntrada)
        }

        val consultarMarcas = ConsultarMarcas()
        consultarMarcas.buscar(mesReferenciaEntrada, tipoVeiculoEntrada)
        scanner.close()
    }
}