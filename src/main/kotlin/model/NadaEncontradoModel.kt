package model

class NadaEncontradoModel {
    var codigo = ""
    val erro = ""

    override fun toString(): String {
        return "Código: $codigo\n" +
                "Erro: $erro\n"
    }
}
