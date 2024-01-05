package com.adolfoponce.spinning.domain.model

import com.google.gson.annotations.SerializedName

data class StudioModel(
    @SerializedName("nombre_estudio")
    val nombre_estudio:String="",
    val logo_studio:String="",
    val address:String="",
    var days_works:ArrayList<String>
){
    constructor():this("","","", arrayListOf())
}
