package com.tenorinho.olhonacamara.models

import com.google.gson.annotations.SerializedName

data class VotPeriodoAux(
    @SerializedName("d")
    var D:VotacoesNoPeriodo
)
data class VotacoesNoPeriodo(
    @SerializedName("Periodo")
    var Periodo:String,
    @SerializedName("Sessoes")
    var Sessoes:List<Sessao>
)
data class Sessao(
    @SerializedName("Nome")
    var Nome:String,
    @SerializedName("Tipo")
    var Tipo:String,
    @SerializedName("Numero")
    var Numero:Int,
    @SerializedName("Data")
    var Data:Any? = null,
    @SerializedName("Votacoes")
    var Votacoes:List<Votacao>?
)
data class Votacao(
    @SerializedName("Votos")
    var Votos:List<Voto>,
    @SerializedName("TipoVotacao")
    var TipoVotacao:String,
    @SerializedName("NotasRodape")
    var NotasRodape:String,
    @SerializedName("Resutado")
    var Resultado:String,
    @SerializedName("Materia")
    var Materia:String,
    @SerializedName("VotacaoID")
    var VotacaoID:Int,
    @SerializedName("Tipo")
    var Tipo: String?,
    @SerializedName("Numero")
    var Numero:Int?,
    @SerializedName("Ano")
    var Ano:Int?,
    @SerializedName("Ementa")
    var Ementa:String?,
    @SerializedName("Presentes")
    var Presentes:Int?,
    @SerializedName("Branco")
    var Branco:Int?,
    @SerializedName("Abstencao")
    var Abstencao:Int?,
    @SerializedName("Nao")
    var Nao:Int?,
    @SerializedName("Sim")
    var Sim:Int?
)
data class Voto(
    @SerializedName("Nome")
    var Nome:String?,
    @SerializedName("Partido")
    var Partido:String?,
    @SerializedName("IDParlamentar")
    var IDParlamentar:Int?,
    @SerializedName("Voto")
    var Voto:String?,
    //-----------------------------
    @SerializedName("VotoContrario")
    var VotoContrario:String?
)

