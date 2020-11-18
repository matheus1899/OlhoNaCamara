package com.tenorinho.olhonacamara.models

class Vereador(chave: Int?, nome: String?) {
    var Chave:Int? = chave
    var Nome:String? = nome
    var Cargos:Array<Cargo>? = null
    var Mandatos:Array<Mandato>? = null
    var Filiacoes:Array<Filiacao>? = null
}