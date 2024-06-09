package model

import com.fasterxml.jackson.annotation.JsonProperty

class ConsultarValorComTodosParametrosModel {
    @JsonProperty("Valor")
    var valor = ""

    @JsonProperty("Marca")
    var marca = ""

    @JsonProperty("Modelo")
    var modelo = ""

    @JsonProperty("AnoModelo")
    var anoModelo = ""

    @JsonProperty("Combustivel")
    var combustivel = ""

    @JsonProperty("CodigoFipe")
    var codigoFipe = ""

    @JsonProperty("MesReferencia")
    var mesReferencia = ""

    @JsonProperty("Autenticacao")
    var autenticacao = ""

    @JsonProperty("TipoVeiculo")
    var tipoVeiculo = ""

    @JsonProperty("SiglaCombustivel")
    var siglaCombustivel = ""

    @JsonProperty("DataConsulta")
    var dataConsulta = ""
    override fun toString(): String {
        return "Valor -> $valor\n" +
                "Marca -> $marca\n" +
                "Modelo -> $modelo\n" +
                "Ano Modelo -> $anoModelo\n" +
                "Combustível -> $combustivel\n" +
                "Codigo Fipe -> $codigoFipe\n" +
                "Mes Refêrencia -> $mesReferencia\n" +
                "Autenticação -> $autenticacao\n" +
                "Tipo Veiculo -> $tipoVeiculo\n" +
                "Sigla Combustível -> $siglaCombustivel\n" +
                "Data Consulta -> $dataConsulta"
    }
}