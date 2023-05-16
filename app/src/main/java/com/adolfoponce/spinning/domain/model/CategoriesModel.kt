package com.adolfoponce.spinning.domain.model

import com.google.gson.annotations.SerializedName

data class CategoriesModel (
    @SerializedName("nameCategories")
    val nameCategories:String,
    @SerializedName("imageCategorie")
    val imageCategorie:String,
    @SerializedName("numRecipes")
    val numRecipes:Int
)