package com.tenorinho.olhonacamara.models

import com.google.gson.annotations.SerializedName

data class Promovente(
    @SerializedName("chave")
    var Chave:Int,
    @SerializedName("nome")
    var Nome:String,
    @SerializedName("sigla")
    var Sigla:String?,
    @SerializedName("tipo")
    var Tipo:Tipo
)
data class Tipo(
    @SerializedName("chave")
    var Chave: Int,
    @SerializedName("sigla")
    var Sigla: String?,
    @SerializedName("nome")
    var Nome: String
)