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
        return view
    }
}