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

class SessaoDetailFragment : Fragment(){
    companion object{
        fun create():SessaoDetailFragment{
            return SessaoDetailFragment()
        }
    }
    private var sessao:Sessao? = null
    private var lista:RecyclerView? = null
    private var adapter:VotacoesAdapter?=null

    fun setSessao(sessao:Sessao?){
        this.sessao = sessao
        adapter?.updateLista(sessao)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_sessao_detail, container, false)
        lista = view.findViewById<RecyclerView>(R.id.fragment_sessao_detail_lista)
        if(sessao != null){
            view.findViewById<TextView>(R.id.fragment_sessao_detail_nome).setText(sessao!!.Nome)
        }
        adapter = VotacoesAdapter(activity!!, sessao)
        lista?.adapter = adapter
        return view
    }
}