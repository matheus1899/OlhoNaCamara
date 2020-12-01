package com.tenorinho.olhonacamara.models

import com.google.gson.annotations.SerializedName

data class VerificaMateria(
    @SerializedName("chave")
    var Chave:Int,
    @SerializedName("existe")
    var Existe:Boolean
)