package com.tenorinho.olhonacamara.net

import com.tenorinho.olhonacamara.models.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CMSPServico1 {
    @GET("VereadoresCMSPJSON?")
    fun getVereadores():Call<ArrayList<Vereador>>

    @GET("LeisAprovadasPorPromoventeJSON?")
    fun getLeisAprovadasPorPromovente(@Query("Codigo")Codigo:Int):Call<Array<Lei>>

    @GET("ProjetosPorAnoJSON?")
    fun getProjetosPorAno(@Query("Ano")Ano:String):Call<Array<Projeto>>

    @GET("FasesDeDeliberacaoJSON?")
    fun getFasesDeliberacaoPorAno(@Query("ano")ano:String):Call<Array<Projeto>>

    @GET("AreasDeTramitacaoJSON?")
    fun getAreasDeTramitacao():Call<Array<Area>>

    @GET("CatalogoDeAssuntosJSON?")
    fun getCatalogoDeAssuntos():Call<Array<Assunto>>

    @GET("ComissoesCMSPJSON?")
    fun getComissoesCMSP():Call<Array<Comissao>>

    @GET("MateriaExisteJSON?")
    fun materiaExiste(@Query("ano") ano:String,
                      @Query("tipo") tipo:String,
                      @Query("numero")numero:String):Call<VerificaMateria>

    @GET("MateriasEventosJSON?")
    fun getMateriasEventosPelaData(@Query("dataPesquisa") dataPesquisa:String):Call<Array<Materia>>

    //@GET("PautaEstendidaSessaoPlenariaJSON?")
    //fun getPautaEstendidaSessaoPlenariaPelaChave(@Query("Chave") chave:String):Call<Pauta>

    //@GET("PautasSessoesPlenariasJSON?")
    //fun getPautasSessoesPlenariasPeloAno(@Query("Ano") ano:String):Call<Array<Pauta>>

    @GET("ProjetoResumoJSON?")
    fun getResumoProjeto(@Query("ano")ano:String,
                         @Query("tipo")tipo:String,
                         @Query("numero")numero: String):Call<Projeto>
    @GET("ProjetosAssuntosJSON?")
    fun getProjetosPorAssunto(@Query("ano") ano:String,
                             @Query("tipo") tipo: String):Call<Array<Projeto>>

    @GET("ProjetosComissoesDesignadasJSON?")
    fun getProjetosComComissoesDesignadas(@Query("ano")ano:String,
                                          @Query("tipo")tipo:String,
                                          @Query("numero")numero:String):Call<Array<Projeto>>
    @GET("ProjetosEmTramitacaoPorPromoventeJSON?")
    fun getProjetosEmTramitacaoPorPromovente(
        @Query("Codigo")Codigo:String):Call<Array<Projeto>>

    @GET("ProjetosEncerradosJSON?")
    fun getProjetosEncerradosPeloAno(@Query("Ano") ano:String):Call<Array<Projeto>>

    @GET("ProjetosReunioesDeComissaoJSON?")
    fun getProjetosReunioesDeComissao(@Query("ano") ano:String,
                                      @Query("tipo") tipo: String):Call<Array<Projeto>>

    @GET("ProjetosVetadosPorPromovente??")
    fun getProjetosVetadosPorPromovente(
        @Query("Codigo")Codigo:String):Call<Array<Projeto>>

    @GET("PromoventesCMSPJSON?")
    fun getPromoventes():Call<Array<Promovente>>

    @GET("TiposDeMateriaJSON?")
    fun getTiposDeMateria():Call<Array<Tipo>>
}