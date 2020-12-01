package com.tenorinho.olhonacamara.models

import com.google.gson.annotations.SerializedName

data class Vereador (
    @SerializedName("chave")
    var Chave:Int,
    @SerializedName("nome")
    var Nome:String,
    @SerializedName("cargos")
    var Cargos:Array<Cargo>?,
    @SerializedName("mandatos")
    var Mandatos:Array<Mandato>?,
    @SerializedName("filiacoes")
    var Filiacoes:Array<Filiacao>?,
    @SerializedName("sigla")
    var Sigla:String?
)
data class Cargo(
    @SerializedName("chave")
    var Chave:String,
    @SerializedName("nome")
    var Nome:String,
    @SerializedName("inicio")
    var Inicio: Any?,
    @SerializedName("fim")
    var Fim:Any?,
    @SerializedName("ente")
    var Ente:Ente?
)
data class Ente(
    @SerializedName("chave")
    var Chave:Int,
    @SerializedName("nome")
    var Nome:String
)
data class Coligacao(
    @SerializedName("chave")
    var Chave:Float,
    @SerializedName("nome")
    var Nome:String,
    @SerializedName("sigla")
    var Sigla:String,
    @SerializedName("inicio")
    var Inicio:Any?,
    @SerializedName("fim")
    var Fim:Any?
)
data class Filiacao(
    @SerializedName("inicio")
    var Inicio: Any?,
    @SerializedName("fim")
    var Fim :Any?,
    @SerializedName("partido")
    var Partido:Partido?
)
data class Mandato(
    @SerializedName("inicio")
    var Inicio:Any?,
    @SerializedName("fim")
    var Fim :Any?,
    @SerializedName("coligacao")
    var Coligacao:Coligacao?,
    @SerializedName("partido")
    var Partido:Partido?
)
data class Partido(
    @SerializedName("chave")
    var Chave:Float,
    @SerializedName("nome")
    var Nome:String,
    @SerializedName("sigla")
    var Sigla:String
)