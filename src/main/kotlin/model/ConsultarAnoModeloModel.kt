package model

import com.fasterxml.jackson.annotation.JsonProperty

class ConsultarAnoModeloModel {
    @JsonProperty("Label")
    var ano = ""

    @JsonProperty("Value")
    var anoCombustivel = ""
    override fun toString(): String {
        return "Ano: $ano -> Ano-Combustível: $anoCombustivel"
    }
}