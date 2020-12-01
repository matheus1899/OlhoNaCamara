package com.tenorinho.olhonacamara.models

import com.google.gson.annotations.SerializedName

data class PresencasNoDia(
    @SerializedName("Dia")
    var Dia:Any, //dateTime
    @SerializedName("TotalSessoesExtraordinarias")
    var TotalSessoesExtraordinarias:Int,
    @SerializedName("TotalSessoesOrdinarias")
    var TotalSessoesOrdinarias:Int,
    @SerializedName("Presencas")
    var Presencas:Array<VereadorPresenca>
)
data class VereadorPresenca(
    @SerializedName("PresenteExtra")
    var PresenteExtra:Int,
    @SerializedName("PresenteOrd")
    var PresenteOrd:Int,
    @SerializedName("IDParlamentar")
    var IDParlamentar:Int,
    @SerializedName("Nome")
    var Nome:String,
    @SerializedName("Partido")
    var Partido:String,
    @SerializedName("Presencas")
    var Presencas: Array<VereadorPresencaSessao>
)
data class VereadorPresencaSessao(
    @SerializedName("Nome")
    var Nome: String,
    @SerializedName("Numero")
    var Numero:Int,
    @SerializedName("Tipo")
    var Tipo:String,
    @SerializedName("Presenca")
    var Presenca:String
)