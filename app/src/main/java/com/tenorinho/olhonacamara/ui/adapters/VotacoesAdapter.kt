package com.tenorinho.olhonacamara.ui.adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.tenorinho.olhonacamara.Navegacao
import com.tenorinho.olhonacamara.R
import com.tenorinho.olhonacamara.models.Sessao
import com.tenorinho.olhonacamara.models.Votacao
import com.tenorinho.olhonacamara.models.VotacoesNoPeriodo

class VotacoesAdapter : RecyclerView.Adapter<VotacoesAdapter.VotacaoHolder> {
    var sessao:Sessao?
    var activity: Activity?
    constructor(activity:Activity, sessao: Sessao?):super(){
        this.sessao = sessao
        this.activity = activity
    }
    class VotacaoHolder:RecyclerView.ViewHolder{
        val txtInfo:TextView
        val txtTipo:TextView
        val txtResultado:TextView
        val txtMateria:TextView
        val txtEmenta:TextView
        val root:View
        constructor(view: View):super(view){
            root = view
            txtInfo = view.findViewById(R.id.item_lista_votacao_info)
            txtTipo = view.findViewById(R.id.item_lista_votacao_tipo)
            txtResultado = view.findViewById(R.id.item_lista_votacao_resultado)
            txtMateria = view.findViewById(R.id.item_lista_votacao_materia)
            txtEmenta = view.findViewById(R.id.item_lista_votacao_ementa)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VotacaoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista_votacao,parent, false)
        return VotacaoHolder(view)
    }
    override fun getItemCount(): Int {
        return sessao?.Votacoes?.size ?: 0
    }
    private fun onClick(position:Int){
        if(sessao?.Votacoes?.size ==0){
            return
        }
        val votacao:Votacao? = sessao?.Votacoes?.get(position)
        if(activity is Navegacao){
            val act = activity as Navegacao
            act.navigateToFragmentVotacaoDetail(votacao)
        }
    }
    override fun onBindViewHolder(holder: VotacaoHolder, position: Int) {
        holder.root.setOnClickListener { onClick(position) }
        val votacao = sessao?.Votacoes?.get(position)
        if(votacao?.Tipo.isNullOrEmpty() || votacao?.Numero == null || votacao?.Ano == null){
            holder.txtInfo.text = ""
        }
        else{
            holder.txtInfo.text = "${votacao?.Tipo} ${votacao?.Numero}/${votacao?.Ano}"
        }
        holder.txtTipo.text = votacao?.TipoVotacao
        holder.txtResultado.text = votacao?.Resultado
        holder.txtMateria.text = votacao?.Materia
        holder.txtEmenta.text = votacao?.Ementa
    }
    fun clear(){
        sessao = null
        notifyDataSetChanged()
    }
    fun updateLista(sessao: Sessao?){
        this.sessao = sessao
        notifyDataSetChanged()
    }
}