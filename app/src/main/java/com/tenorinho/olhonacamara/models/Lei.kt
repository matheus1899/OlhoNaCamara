package com.tenorinho.olhonacamara.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class Lei(
    @SerializedName("projeto")
    var Projeto:Projeto,
    @SerializedName("numero")
    var Numero:Int,
    @SerializedName("publicacao")
    var Publicacao:Any?//dateTime
)
data class Projeto(
    @SerializedName("chave")
    var Chave:String,
    @SerializedName("tipo")
    var Tipo:String,
    @SerializedName("_tipo")
    var _Tipo:Int,
    @SerializedName("numero")
    var Numero:Int,
    @SerializedName("ano")
    var Ano:Int,
    @SerializedName("promovente")
    var Promovente:Promovente?,
    @SerializedName("data")
    var Data: Any?,
    @SerializedName("ementa")
    var Ementa:String?,
    @SerializedName("tiponorma")
    var TipoNorma:String?,
    @SerializedName("numeronorma")
    var NumeroNorma:String?,
    @SerializedName("anonorma")
    var AnoNorma:String?,
    @SerializedName("datanorma")
    var DataNorma:String?,
    @SerializedName("assuntos")
    var Assuntos:Array<Assunto>?,
    @SerializedName("leitura")
    var Leitura:Any?,//datatime
    @SerializedName("autores")
    var Autores:Array<Autor>?,
    @SerializedName("subscritores")
    var Subscritores:Array<Autor>?,
    @SerializedName("encaminhamentos")
    var Encaminhamentos:Array<Encaminhamento>?,//
    @SerializedName("encerramento")
    var Encerramento:Any?,//dateTime
    @SerializedName("motivo")
    var Motivo:String?,
    @SerializedName("tramitacoes")
    var Tramitacoes:Array<Tramitacao>?,
    @SerializedName("deliberacoes")
    var Deliberacoes:Array<Deliberacao>?,
    @SerializedName("fase")
    var Fase:String?,
    @SerializedName("quorum")
    var Quorum:String?,
    @SerializedName("substitutivos")
    var Substitutivos:String?
)
data class Assunto(
    @SerializedName("chave")
    var Chave: String?,
    @SerializedName("texto")
    var Texto:String?,
    @SerializedName("nota")
    var Nota:String?,
    @SerializedName("autorizado")
    var Autorizado:String?,
    @SerializedName("chaveuse")
    var ChaveUse:String?,
    @SerializedName("use")
    var Use:String?,
    @SerializedName("listausadopara")
    var ListaUsadoPara:Array<UsadoPara>?,
    @SerializedName("listatermorelacionado")
    var ListaTermoRelacionado:Array<TermoRelacionado>?
)
data class Autor(
    @SerializedName("chave")
    var Chave:Int,
    @SerializedName("nome")
    var Nome:String
)
data class Encaminhamento(
    @SerializedName("sequencia")
    var Sequencia:Int,
    @SerializedName("data")
    var Data:Any?,//dateTime
    @SerializedName("comissoes")
    var Comissoes:Array<Comissao>?
)
data class Tramitacao(
    @SerializedName("chave")
    var Chave:Int,
    @SerializedName("area")
    var Area:Area?,
    @SerializedName("entrada")
    var Entrada:String?,
    @SerializedName("saida")
    var Saida:String?
)
data class Deliberacao(
    @SerializedName("resultado")
    var Resultado:String
)

data class UsadoPara(
    @SerializedName("chave")
    var Chave:String,
    @SerializedName("texto")
    var Texto: String
)
data class TermoRelacionado(
    @SerializedName("chave")
    var Chave:String,
    @SerializedName("texto")
    var Texto: String
)
data class Area(
    @SerializedName("chave")
    var Chave:Int,
    @SerializedName("sigla")
    var Sigla:String,
    @SerializedName("nome")
    var Nome:String
)