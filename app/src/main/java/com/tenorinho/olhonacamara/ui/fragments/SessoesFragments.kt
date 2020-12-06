package com.tenorinho.olhonacamara.ui.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.tenorinho.olhonacamara.R
import com.tenorinho.olhonacamara.models.VotPeriodoAux
import com.tenorinho.olhonacamara.ui.adapters.SessoesAdapter
import com.tenorinho.olhonacamara.net.CMSPServico2
import com.tenorinho.olhonacamara.net.RetrofitConfig
import okhttp3.MediaType
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.*

class SessoesFragments : Fragment(){
    private var refreshLayout:SwipeRefreshLayout? = null
    private var lista:RecyclerView? = null
    private var adapter:SessoesAdapter? = null

    companion object{
        fun create():SessoesFragments{
            return SessoesFragments()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_sessoes, container, false)
        refreshLayout = view.findViewById(R.id.swipeContainer)
        refreshLayout?.setOnRefreshListener { refreshList() }
        refreshLayout?.setColorSchemeResources(R.color.colorAccent, android.R.color.black)
        lista = view.findViewById(R.id.fragment_sessoes_lista)
        adapter = SessoesAdapter(null, activity!!)
        lista?.adapter = adapter
        return view
    }
    fun refreshList(){
        val servico: CMSPServico2 = RetrofitConfig.getRetrofitInstanceService2().create(CMSPServico2::class.java)
        val json = JSONObject().put("ano","2020").put("mes","10")
        val jsonObjString:String = json.toString()
        val requestBody:RequestBody = RequestBody.create(MediaType.parse("application/json"), jsonObjString)
        val callback: Call<VotPeriodoAux> = servico.getVotacaoAnoMes(requestBody)
        callback.enqueue(object : Callback<VotPeriodoAux> {
            override fun onFailure(call: Call<VotPeriodoAux>, t: Throwable) {
                Toast.makeText(activity!!,"ERRO: $t",Toast.LENGTH_LONG).show()
                activity!!.runOnUiThread {refreshLayout?.isRefreshing = false}
            }
            override fun onResponse(call: Call<VotPeriodoAux>, response: Response<VotPeriodoAux>){
                if(response.isSuccessful){
                    activity!!.runOnUiThread {
                        adapter?.updateLista(response.body()!!.D)
                        refreshLayout?.isRefreshing = false
                    }
                }
                else{
                    activity!!.runOnUiThread {
                        Toast.makeText(activity!!,"responseCode: ${response.code()} \nmessage: ${response.message()}",Toast.LENGTH_LONG).show()
                        refreshLayout?.isRefreshing = false
                    }
                }
            }
        })
        /*val client = OkHttpClient()
        val date = Date()
        var request = Request.Builder()
            .url("https://app-sipws-prd.azurewebsites.net/Servico/ConsultaSIP.asmx/JsonVotacaoAnoMes?ano=2020&mes=10")
            .build()
        try {
            Thread{
                var response = client.newCall(request).execute()
                var teste = getStringFromStream(response.body()?.byteStream())
                val gson = Gson()
                val votacoesNoPeriodo = gson.fromJson(getJsonFromXml(teste), VotacoesNoPeriodo::class.java)
                if(votacoesNoPeriodo!=null){
                    activity!!.runOnUiThread{
                        adapter?.updateLista(votacoesNoPeriodo)
                        refreshLayout?.isRefreshing=false
                    }
                }
            }.start()
        }
        catch (e:Exception){
            Toast.makeText(activity!!, "ERRO: $e", Toast.LENGTH_LONG).show()
            refreshLayout?.isRefreshing=false
        }*/
    }
    /*fun getStringFromStream(inputStream: InputStream?):String{
        if(inputStream==null){
            return ""
        }
        val bis = BufferedInputStream(inputStream);
        val buf = ByteArrayOutputStream();
        var result:Int = bis.read();
        while(result != -1) {
            buf.write(result);
            result = bis.read();
        }
        return buf.toString("UTF-8");
    }
    fun getJsonFromXml(xml:String):String{
        var first =0
        var last = 0
        var vezes = 0
        try{
            for(s in 0..xml.length-1){
                if(xml[s] == '>'){
                    if(vezes==0){
                        vezes = 1
                    }else{
                        first = s+1
                        break
                    }
                }
            }
            var l = xml.length-1
            for(s in l downTo 0){
                if(xml[s] == '<'){
                    last = s
                    break
                }
            }
        }
        catch(e:Exception){
            return ""
        }
        var string = xml.subSequence(first, last).toString()
        return string
    }*/
}