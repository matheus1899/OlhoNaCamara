package com.tenorinho.olhonacamara.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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
                view.findViewById<TextView>(R.id.fragment_votacao_detail_presentes_conteudo).visibility = View.GONE
                view.findViewById<TextView>(R.id.fragment_votacao_detail_abstencoes_conteudo).visibility = View.GONE
                view.findViewById<TextView>(R.id.fragment_votacao_detail_brancos_conteudo).visibility = View.GONE
                view.findViewById<TextView>(R.id.fragment_votacao_detail_voto_nao_conteudo).visibility = View.GONE
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
            view.findViewById<TextView>(R.id.fragment_votacao_detail_materia_conteudo).text = votacao?.Materia?.trimStart()?.replace("\t","\n") ?: "\n"
            view.findViewById<TextView>(R.id.fragment_votacao_detail_nota_rodape_conteudo).text = votacao?.NotasRodape?.trimStart()?.replace("\t","\n") ?: "\n\n"
            if(votacao?.Resultado != null && votacao?.Resultado is String){
                val res = votacao?.Resultado as String
                when(res.get(0)){
                    'R', 'r' -> { view.findViewById<ImageView>(R.id.fragment_votacao_detail_img_aprovacao).setImageResource(R.drawable.ic_reprovado_24) }
                    'A', 'a' -> { view.findViewById<ImageView>(R.id.fragment_votacao_detail_img_aprovacao).setImageResource(R.drawable.ic_aprovado_24) }
                }
            }
            when(votacao?.TipoVotacao?.get(0)){
                'N', 'n' -> { view.findViewById<ImageView>(R.id.fragment_votacao_detail_img_tipo).setImageResource(R.drawable.ic_votacao_nominal) }
                'S', 's' -> { view.findViewById<ImageView>(R.id.fragment_votacao_detail_img_tipo).setImageResource(R.drawable.ic_votacao_simbolica) }
            }
        }
        return view
    }
}