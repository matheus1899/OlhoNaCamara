package com.tenorinho.olhonacamara.ui.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tenorinho.olhonacamara.Navegacao
import com.tenorinho.olhonacamara.R
import com.tenorinho.olhonacamara.models.Sessao
import com.tenorinho.olhonacamara.models.Votacao
import com.tenorinho.olhonacamara.models.Voto
import org.w3c.dom.Text

class VotosAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private val HEADER = 0
    private val ITEM = 1
    var votacao: Votacao?
    var activity: Activity?

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
    class VotoHeaderHolder:RecyclerView.ViewHolder{
        val txtMateriaConteudo:TextView
        val txtEmentaConteudo:TextView
        val txtNotaRodapeConteudo:TextView
        val txtPresentesConteudo:TextView
        val txtAbstencoesConteudo:TextView
        val txtSimConteudo:TextView
        val txtNaoConteudo:TextView
        val txtBrancosConteudo:TextView
        val imgAprovacao:ImageView
        val imgTipoVotacao:ImageView
        constructor(view:View):super(view){
            txtMateriaConteudo = view.findViewById(R.id.item_lista_voto_header_materia_conteudo)
            txtEmentaConteudo = view.findViewById(R.id.item_lista_voto_header_ementa_conteudo)
            txtNotaRodapeConteudo = view.findViewById(R.id.item_lista_voto_header_nota_rodape_conteudo)
            txtPresentesConteudo = view.findViewById(R.id.item_lista_voto_header_presentes_conteudo)
            txtAbstencoesConteudo = view.findViewById(R.id.item_lista_voto_header_abstencoes_conteudo)
            txtSimConteudo = view.findViewById(R.id.item_lista_voto_header_voto_sim_conteudo)
            txtNaoConteudo = view.findViewById(R.id.item_lista_voto_header_voto_nao_conteudo)
            txtBrancosConteudo = view.findViewById(R.id.item_lista_voto_header_brancos_conteudo)
            imgAprovacao = view.findViewById(R.id.item_lista_voto_header_img_aprovacao)
            imgTipoVotacao = view.findViewById(R.id.item_lista_voto_header_img_tipo)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == ITEM){
            val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_lista_voto,parent, false)
            return VotoHolder(view)
        }
        else{
            val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_lista_voto_header,parent, false)
            return VotoHeaderHolder(view)
        }
    }
    override fun getItemViewType(position: Int): Int {
        if(position == 0){
            return HEADER
        }
        else{
            return ITEM
        }
    }
    override fun getItemCount(): Int {
        return votacao?.Votos?.size?.plus(1) ?: 0
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //holder.root.setOnClickListener { onClick(position) }
        if(holder is VotoHolder){
            val h:VotoHolder = holder as VotoHolder
            if(votacao != null){
                val voto: Voto = votacao!!.Votos.get(position-1)
                if(votacao!!.TipoVotacao.startsWith("s")){
                    h.txtPartido.visibility = View.GONE
                    h.txtNomeVereador.text = voto.VotoContrario
                    h.viewVoto.setBackgroundResource(R.drawable.shape_voto_nao_24dp)
                }
                else{
                    h.txtNomeVereador.text = voto.Nome
                    h.txtPartido.text = voto.Partido
                    var c:Char = voto.Voto!!.trimStart().get(0)
                    when(c){
                        'N'-> h.viewVoto.setBackgroundResource(R.drawable.shape_voto_nao_24dp)
                        'A'-> h.viewVoto.setBackgroundResource(R.drawable.shape_voto_abstencao_24dp)
                        'S'-> h.viewVoto.setBackgroundResource(R.drawable.shape_voto_sim_24dp)
                        'B'-> h.viewVoto.setBackgroundResource(R.drawable.shape_voto_branco_24dp)
                    }
                }
            }
        }
        if(holder is VotoHeaderHolder){
            val h:VotoHeaderHolder = holder as VotoHeaderHolder
            if(votacao!!.TipoVotacao[0] == 'S'){
                h.txtPresentesConteudo.visibility = View.GONE
                h.txtAbstencoesConteudo.visibility = View.GONE
                h.txtBrancosConteudo.visibility = View.GONE
                h.txtNaoConteudo.visibility = View.GONE
                holder.txtSimConteudo.visibility = View.GONE
            }
            else{
                h.txtPresentesConteudo.text = votacao?.Presentes.toString()
                h.txtAbstencoesConteudo.text = votacao?.Abstencao.toString()
                h.txtBrancosConteudo.text = votacao?.Branco.toString()
                h.txtNaoConteudo.text = votacao?.Nao.toString()
                h.txtSimConteudo.text = votacao?.Sim.toString()
            }
            h.txtEmentaConteudo.text = votacao?.Ementa?.trimStart() ?: "\n"
            h.txtMateriaConteudo.text = votacao?.Materia?.trimStart()?.replace("\t","\n") ?: "\n"
            h.txtNotaRodapeConteudo.text = votacao?.NotasRodape?.trimStart()?.replace("\t","\n") ?: "\n\n"
            if(votacao?.Resultado != null && votacao?.Resultado is String){
                val res:String = votacao?.Resultado as String
                when(res.get(0)){
                    'R', 'r' -> { h.imgAprovacao.setImageResource(R.drawable.ic_reprovado_24) }
                    'A', 'a' -> { h.imgAprovacao.setImageResource(R.drawable.ic_aprovado_24) }
                }
            }
            when(votacao?.TipoVotacao?.get(0)){
                'N', 'n' -> { h.imgTipoVotacao.setImageResource(R.drawable.ic_votacao_nominal) }
                'S', 's' -> { h.imgTipoVotacao.setImageResource(R.drawable.ic_votacao_simbolica) }
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