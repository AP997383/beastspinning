package com.adolfoponce.spinning.domain.model

import com.google.gson.annotations.SerializedName

data class CategoriesModel (
    @SerializedName("name")
    val name:String,
    @SerializedName("url")
    val url:String
)