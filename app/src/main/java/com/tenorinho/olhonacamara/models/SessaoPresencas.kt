package com.tenorinho.olhonacamara.models

data class SessaoPresencas(
    var Nome:String,
    var Tipo:String,
    var Numero:Int,
    var Data:Any, //dateTime
    var Presencas:Array<VereadorPresencaSessao>
)