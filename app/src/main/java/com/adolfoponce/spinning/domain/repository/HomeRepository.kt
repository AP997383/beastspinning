package com.adolfoponce.spinning.domain.repository
import com.adolfoponce.spinning.data.network.model.response.CategoriesResponse
import com.adolfoponce.spinning.data.network.model.response.RecipesResponse
import com.adolfoponce.spinning.utils.Resource
import io.reactivex.Observable
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getCategories(): Flow<Resource<CategoriesResponse>>
    fun getRecipes(): Flow<Resource<RecipesResponse>>

}