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
import com.tenorinho.olhonacamara.models.VotacoesNoPeriodo
import com.tenorinho.olhonacamara.ui.activities.MainActivity
import java.util.*

class SessoesAdapter : RecyclerView.Adapter<SessoesAdapter.SessaoHolder> {
    var periodo:VotacoesNoPeriodo?
    var activity:Activity
    constructor(votacoesNoPeriodo: VotacoesNoPeriodo?, activity: Activity):super(){
        periodo = votacoesNoPeriodo
        this.activity = activity
    }
    class SessaoHolder:RecyclerView.ViewHolder{
        val txtNumero:TextView
        val txtTipoSessao:TextView
        val txtNumeroVotacoes:TextView
        val txtData:TextView
        val root:View
        constructor(view: View):super(view){
            root = view
            txtNumero = view.findViewById(R.id.item_lista_sessao_numero)
            txtTipoSessao = view.findViewById(R.id.item_lista_sessao_tipo)
            txtNumeroVotacoes = view.findViewById(R.id.item_lista_sessao_n_votacoes)
            txtData = view.findViewById(R.id.item_lista_sessao_data)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessaoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista_sessao,parent, false)
        return SessaoHolder(view)
    }
    private fun onClick(context: Context, position:Int){
        if(periodo?.Sessoes?.get(position)?.Votacoes?.size == 0){
            return
        }
        if(activity is Navegacao){
            val act = activity as Navegacao
            act.navigateToFragmentSessaoDetail(periodo?.Sessoes?.get(position))
        }
    }
    override fun getItemCount(): Int {
        return periodo?.Sessoes?.size ?: 0
    }
    override fun onBindViewHolder(holder: SessaoHolder, position: Int) {
        holder.root.setOnClickListener { onClick(holder.root.context,position) }
        val sessao = periodo?.Sessoes?.get(position)
        holder.txtNumeroVotacoes.text = "Votações: ${sessao?.Votacoes?.size}"
        holder.txtNumero.text = sessao?.Numero.toString()
        holder.txtTipoSessao.text = sessao?.Tipo
        val data: Date? = sessao?.getDataFormatada()
        if(data != null){
            holder.txtData.text = getDataString(data)
        }
        else{
            holder.txtData.visibility = View.GONE
        }
    }
    private fun getDataString(data:Date?):String{
        if(data == null){
            return ""
        }
        else{
            var s: String
            if(data.day in 1..9){
                s = "0${data.day}/"
            }
            else{
                s = data.day.toString()
            }

            if(data.month in 1..9){
                s+= "0${data.month}"
            }
            else{
                s+= data.month.toString()
            }
            return s
        }
    }
    fun clear(){
        periodo = null
        notifyDataSetChanged()
    }
    fun updateLista(votacoes:VotacoesNoPeriodo){
        periodo = votacoes
        notifyDataSetChanged()
    }
}