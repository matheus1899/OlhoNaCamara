package com.tenorinho.olhonacamara.models

import com.google.gson.annotations.SerializedName

data class Comissao(
    @SerializedName("chave")
    var Chave:Int,
    @SerializedName("ordem")
    var Ordem:Int,
    @SerializedName("nome")
    var Nome:String,
    @SerializedName("sigla")
    var Sigla:String,
    @SerializedName("relator")
    var Relator:String,
    @SerializedName("nomepolitico")
    var NomePolitico:String,
    @SerializedName("nomecompleto")
    var NomeCompleto:String,
    @SerializedName("relatorio")
    var Relatorio:Relatorio,
    @SerializedName("inicio")
    var Inicio:Any?,  //dateTime
    @SerializedName("fim")
    var Fim:Any?, //dateTime
    @SerializedName("dataparecer")
    var DataParecer:Any?, //dataTime
    @SerializedName("conclusao")
    var Conclusao:String?
)
data class Relatorio(
    var Numero:Int,
    var Ano:Int
)