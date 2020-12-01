package com.tenorinho.olhonacamara.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.tenorinho.olhonacamara.R
import com.tenorinho.olhonacamara.models.*
import com.tenorinho.olhonacamara.ui.adapters.VotacoesAdapter
import com.tenorinho.olhonacamara.ui.adapters.VotosAdapter

class VotacaoDetailFragment : Fragment(){
    companion object{
        fun create():VotacaoDetailFragment{
            return VotacaoDetailFragment()
        }
    }
    private var votacao:Votacao? = null
    private var lista:RecyclerView? = null
    private var adapter:VotosAdapter? = null

    fun setVotacao(votacao:Votacao?){
        this.votacao = votacao
        adapter?.notifyDataSetChanged()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View = inflater.inflate(R.layout.fragment_votacao_detail, container, false)
        lista = view.findViewById<RecyclerView>(R.id.fragment_votacao_detail_lista)
        adapter = VotosAdapter(activity!!, votacao)
        lista?.adapter = adapter
        if(votacao != null){
            if(votacao!!.TipoVotacao[0] == 'S'){
                view.findViewById<TextView>(R.id.fragment_votacao_detail_presentes).visibility = View.GONE
                view.findViewById<TextView>(R.id.fragment_votacao_detail_presentes_conteudo).visibility = View.GONE
                view.findViewById<TextView>(R.id.fragment_votacao_detail_abstencoes).visibility = View.GONE
                view.findViewById<TextView>(R.id.fragment_votacao_detail_abstencoes_conteudo).visibility = View.GONE
                view.findViewById<TextView>(R.id.fragment_votacao_detail_brancos).visibility = View.GONE
                view.findViewById<TextView>(R.id.fragment_votacao_detail_brancos_conteudo).visibility = View.GONE
                view.findViewById<TextView>(R.id.fragment_votacao_detail_voto_nao).visibility = View.GONE
                view.findViewById<TextView>(R.id.fragment_votacao_detail_voto_nao_conteudo).visibility = View.GONE
                view.findViewById<TextView>(R.id.fragment_votacao_detail_voto_sim).visibility = View.GONE
                view.findViewById<TextView>(R.id.fragment_votacao_detail_voto_sim_conteudo).visibility = View.GONE
            }
            else{
                view.findViewById<TextView>(R.id.fragment_votacao_detail_presentes_conteudo).text = votacao?.Presentes.toString()
                view.findViewById<TextView>(R.id.fragment_votacao_detail_abstencoes_conteudo).text = votacao?.Abstencao.toString()
                view.findViewById<TextView>(R.id.fragment_votacao_detail_brancos_conteudo).text = votacao?.Branco.toString()
                view.findViewById<TextView>(R.id.fragment_votacao_detail_voto_nao_conteudo).text = votacao?.Nao.toString()
                view.findViewById<TextView>(R.id.fragment_votacao_detail_voto_sim_conteudo).text = votacao?.Sim.toString()
            }
            view.findViewById<TextView>(R.id.fragment_votacao_detail_ementa_conteudo).text = votacao?.Ementa?.trimStart() ?: "\n"
            view.findViewById<TextView>(R.id.fragment_votacao_detail_materia_conteudo).text = votacao?.Materia?.trimStart()?.replace("\t","\n") ?: ""
            view.findViewById<TextView>(R.id.fragment_votacao_detail_nota_rodape_conteudo).text = votacao?.NotasRodape?.trimStart()?.replace("\t","\n") ?: "\n\n"
            view.findViewById<TextView>(R.id.fragment_votacao_detail_resultado).text = votacao?.Resultado
            view.findViewById<TextView>(R.id.fragment_votacao_detail_tipo).text = votacao?.TipoVotacao
        }
        return view
    }
}