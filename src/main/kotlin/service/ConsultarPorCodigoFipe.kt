package service

class ConsultarPorCodigoFipe {
    fun consultar(codigoTabelaReferencia: Int, codigoTipoVeiculo: Int) {
        val consultarPorCodigoFipe = ConsultarValorComTodosParametros()
        consultarPorCodigoFipe.consultarPorCodigoFipe(
            codigoTabelaReferencia,
            codigoTipoVeiculo,
            "",
            ""
        )
    }
}