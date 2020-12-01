package com.tenorinho.olhonacamara.ui.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tenorinho.olhonacamara.Navegacao
import com.tenorinho.olhonacamara.R
import com.tenorinho.olhonacamara.models.Sessao
import com.tenorinho.olhonacamara.models.Votacao

class VotosAdapter : RecyclerView.Adapter<VotosAdapter.VotoHolder> {
    var votacao: Votacao?
    var activity: Activity?
    var b = true
    constructor(activity:Activity, votacao: Votacao?):super(){
        this.votacao = votacao
        this.activity = activity
    }
    class VotoHolder:RecyclerView.ViewHolder{
        val txtPartido:TextView
        val txtNomeVereador:TextView
        val viewVoto:View
        val root:View
        val separadorVertical:View
        constructor(view: View):super(view){
            root = view
            viewVoto = view.findViewById(R.id.item_lista_voto_voto)
            separadorVertical = view.findViewById(R.id.item_lista_voto_separador_vertical)
            txtNomeVereador = view.findViewById(R.id.item_lista_voto_nome)
            txtPartido = view.findViewById(R.id.item_lista_voto_partido)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VotoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista_voto,parent, false)
        return VotoHolder(view)
    }
    override fun getItemCount(): Int {
        return votacao?.Votos?.size ?: 0
    }
    /*private fun onClick(position:Int){
        if(activity!! is Navegacao)
    }*/
    override fun onBindViewHolder(holder: VotoHolder, position: Int) {
        //holder.root.setOnClickListener { onClick(position) }
        if(votacao != null){
            val voto = votacao!!.Votos.get(position)
            if(votacao!!.TipoVotacao.startsWith("s")){
                holder.txtPartido.visibility = View.GONE
                holder.txtNomeVereador.text = voto.VotoContrario
                holder.viewVoto.setBackgroundResource(R.drawable.shape_voto_nao_24dp)
            }
            else{
                holder.txtNomeVereador.text = voto.Nome
                holder.txtPartido.text = voto.Partido
                var c = voto.Voto!!.trimStart().get(0)
                when(c){
                    'N'-> holder.viewVoto.setBackgroundResource(R.drawable.shape_voto_nao_24dp)
                    'A'-> holder.viewVoto.setBackgroundResource(R.drawable.shape_voto_abstencao_24dp)
                    'S'-> holder.viewVoto.setBackgroundResource(R.drawable.shape_voto_sim_24dp)
                }
            }
        }
    }
    fun clear(){
        votacao = null
        notifyDataSetChanged()
    }
    fun updateLista(votacao: Votacao?){
        this.votacao = votacao
        notifyDataSetChanged()
    }
}