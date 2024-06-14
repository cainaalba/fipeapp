# Aplicação desenvolvida utilizando Kotlin para consulta do preço médio dos veículos (FIPE)

Rode o arquivo _Main.kt_ e siga os passos da execução.

**Tipos dos veículos:**
1. Carros e utilitários 
2. Motos
3. Caminhões e micro-ônibus

Todas as requisições têm o método: **POST**

## **Consultar tabela referência**
Endpoint: http://veiculos.fipe.org.br/api/veiculos/ConsultarTabelaDeReferencia

Body: Vazio

## **Consultar marcas**
Endpoint: http://veiculos.fipe.org.br/api/veiculos/ConsultarMarcas

Body: 
```
{
   "codigoTabelaReferencia":"mesReferenciaEntrada",
   "codigoTipoVeiculo":"tipoVeiculoEntrada"
}
```

## **Consultar modelos**
Endpoint: http://veiculos.fipe.org.br/api/veiculos/ConsultarModelos

Body:
```
{
   "codigoTabelaReferencia":"mesReferenciaEntrada",
   "codigoTipoVeiculo":"tipoVeiculoEntrada",
   "codigoMarca":"codigoMarca"
}
```

## **Consultar modelos através do ano**
Endpoint: http://veiculos.fipe.org.br/api/veiculos/ConsultarModelosAtravesDoAno

Body:
```
{
   "codigoTabelaReferencia":"mesReferenciaEntrada",
   "codigoTipoVeiculo":"tipoVeiculoEntrada",
   "codigoMarca":"codigoMarca",
   "anoModelo":"anoModelo"
}
```

## **Consultar ano modelo**
Endpoint: http://veiculos.fipe.org.br/api/veiculos/ConsultarAnoModelo

Body:
```
{
   "codigoTabelaReferencia":"mesReferenciaEntrada",
   "codigoTipoVeiculo":"tipoVeiculoEntrada",
   "codigoMarca":"codigoMarca"
}
```

## **Consultar com todos os parâmetros**
Endpoint: http://veiculos.fipe.org.br/api/veiculos/ConsultarValorComTodosParametros

### **Consultar por marca, ano, modelo**
> Deve-se dar um parse no AnoModelo, pois vem no formato ANO-CODIGO_COMBUSTIVEL. Ex.: 2011-1. Separar o ano 2011 do código do combustível 1 (gasolina).
```
{
   "codigoTabelaReferencia":"mesReferenciaEntrada",
   "codigoTipoVeiculo":"tipoVeiculoEntrada",
   "codigoMarca":"codigoMarca",
   "anoModelo":"ano",
   "ano":"codigoAnoCombustivel",
   "codigoTipoCombustivel":"codigoCombustivel",
   "tipoConsulta":"tradicional"
}
```

### **Consultar por ano e código fipe**:
```
{
   "codigoTabelaReferencia":"codigoTabelaReferencia",
   "codigoTipoVeiculo":"codigoTipoVeiculo",
   "anoModelo":"anoModelo.toInt()",
   "modeloCodigoExterno":"codigoFipe.toString()",
   "tipoConsulta":"codigo"
}
```
