package com.tenorinho.olhonacamara.models

import com.google.gson.annotations.SerializedName

data class Materia(
    @SerializedName("tipo")
    var Tipo:Int,
    @SerializedName("sigla")
    var Sigla:String,
    @SerializedName("numero")
    var Numero:Int,
    @SerializedName("ano")
    var Ano:Int,
    @SerializedName("ementa")
    var Ementa:String,
    @SerializedName("eventos")
    var Eventos:Array<Evento>,
    @SerializedName("autores")
    var Autores:Array<Autor>
)
data class Evento(
    @SerializedName("data")
    var Data:Any?, //dateTime
    @SerializedName("descricao")
    var Descricao:String
)