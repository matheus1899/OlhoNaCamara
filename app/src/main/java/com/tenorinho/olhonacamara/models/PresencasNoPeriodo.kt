package com.tenorinho.olhonacamara.models

import com.google.gson.annotations.SerializedName

data class PresencasNoPeriodo(
    @SerializedName("Periodo")
    var Periodo:String,
    @SerializedName("TotalSessoesExtraordinarias")
    var TotalSessoesExtraordinarias:Int,
    @SerializedName("TotalSessoesOrdinarias")
    var TotalSessoesOrdinarias:Int,
    @SerializedName("Presencas")
    var Presencas:Array<VereadorPresencaNoPeriodo>
)
data class VereadorPresencaNoPeriodo(
    var IDParlamentar:Int,
    var Nome:String,
    var Partido:String,
    var Presencas:Array<VereadorPresencaNoDia>
)
data class VereadorPresencaNoDia(
    var Dia:Any, //dateTime
    var Presenca:String
)