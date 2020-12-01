package com.tenorinho.olhonacamara.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig{
    companion object{
        fun getRetrofitInstanceService1():Retrofit{
            return Retrofit.Builder()
                .baseUrl("http://splegisws.camara.sp.gov.br/ws/ws2.asmx/")
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
        fun getRetrofitInstanceService2():Retrofit{
            return Retrofit.Builder()
                .baseUrl("https://app-sipws-prd.azurewebsites.net/Servico/ConsultaSIP.asmx/")
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}