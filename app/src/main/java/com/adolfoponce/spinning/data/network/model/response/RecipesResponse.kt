package com.adolfoponce.spinning.data.network.model.response

import com.adolfoponce.spinning.domain.model.CategoriesModel
import com.adolfoponce.spinning.domain.model.RecipesModel
import com.google.gson.annotations.SerializedName

data class RecipesResponse (
    @SerializedName("receips")
    val recipes:ArrayList<RecipesModel>
)