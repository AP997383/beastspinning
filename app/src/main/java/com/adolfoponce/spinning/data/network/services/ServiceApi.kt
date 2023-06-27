package com.adolfoponce.spinning.data.network.services

import com.adolfoponce.spinning.data.network.model.response.CategoriesResponse
import com.adolfoponce.spinning.data.network.model.response.RecipesResponse
import retrofit2.http.*

interface ServiceApi {

    @GET(EndPoint.CATEGORIES)
    suspend fun getCategories(): CategoriesResponse

    @GET(EndPoint.RECIPES)
    suspend fun getRecipes(): RecipesResponse

    @GET(EndPoint.FEED)
    suspend fun getFeed(): RecipesResponse

}
