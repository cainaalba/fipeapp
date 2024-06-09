package service

import java.util.Scanner
import kotlin.system.exitProcess

class ContinuarConsulta {
    fun continuar() {
        val scanner = Scanner(System.`in`)

        println("\nConsultar outro veículo? (S/N)")
        val entrada = scanner.next()
        if (entrada.equals("S", true)) {
            val consultarTabelaDeReferencia = ConsultarTabelaDeReferencia()
            consultarTabelaDeReferencia.consultar()
        } else {
            exitProcess(0)
        }
        scanner.close()
    }
}