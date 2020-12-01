package com.tenorinho.olhonacamara.models

import com.google.gson.annotations.SerializedName

data class Pauta(
    @SerializedName("chave")
    var Chave:String,
    @SerializedName("sessao")
    var Sessao:String,
    @SerializedName("data")
    var Data:Any?, //dateTime
    @SerializedName("oradores")
    var Oradores:String,
    @SerializedName("status")
    var Status:String,
    @SerializedName("projetos")
    var Projetos:Array<Projeto>
)