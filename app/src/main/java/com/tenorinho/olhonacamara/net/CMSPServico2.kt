package com.tenorinho.olhonacamara.net

import com.tenorinho.olhonacamara.models.*
import okhttp3.RequestBody
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Body
import retrofit2.Call

interface CMSPServico2{
    @Headers("Content-type: application/json")
    @POST("XmlPresencaAnoMes")
    fun getPresencaAnoMes(@Body requestBody: RequestBody):Call<PresencasNoPeriodo>
    @Headers("Content-type: application/json")
    @POST("XmlPresencaAnoMesDia")
    fun getPresencaAnoMesDia(@Body requestBody: RequestBody):Call<PresencasNoDia>
    @Headers("Content-type: application/json")
    @POST("XmlPresencaSessao")
    fun getPresencaSessao(@Body requestBody: RequestBody):Call<SessaoPresencas>
    @Headers("Content-type: application/json")
    @POST("XmlVotacaoAnoMes")
    fun getVotacaoAnoMes(@Body requestBody: RequestBody):Call<VotPeriodoAux>
    @Headers("Content-type: application/json")
    @POST("XmlVotacaoAnoMesDia")
    fun getVotacaoAnoMesDia(@Body requestBody: RequestBody):Call<VotacoesNoPeriodo>
    @Headers("Content-type: application/json")
    @POST("XmlVotacaoSessao")
    fun getVotacaoSessao(@Body requestBody: RequestBody):Call<Sessao>
}