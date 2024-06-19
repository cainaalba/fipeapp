package interfaces

import com.fasterxml.jackson.databind.ObjectMapper
import continuarConsulta
import model.NadaEncontradoModel

interface ProcessaErroInterface {
    fun processar(responseBody: String?) {
        val resultado = runCatching {
            val erro: NadaEncontradoModel = ObjectMapper().readValue(responseBody, NadaEncontradoModel::class.java)
            println(erro.toString())
        }

        resultado.onFailure {
            println("Retorno: $responseBody\nErro: ${it.message}")
            return
        }

        resultado.onSuccess {
            continuarConsulta()
        }
    }
}