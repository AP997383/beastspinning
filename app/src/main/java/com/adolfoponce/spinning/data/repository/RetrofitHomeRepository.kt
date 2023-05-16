package com.adolfoponce.spinning.data.repository

import com.adolfoponce.spinning.data.network.model.response.CategoriesResponse
import com.adolfoponce.spinning.data.network.model.response.RecipesResponse
import com.adolfoponce.spinning.data.network.services.ServiceApi
import com.adolfoponce.spinning.domain.repository.HomeRepository
import com.adolfoponce.spinning.utils.Resource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitHomeRepository@Inject
constructor(
    private val api: ServiceApi
): HomeRepository{


    override fun getCategories(): Flow<Resource<CategoriesResponse>> = flow {
        try {
            emit(Resource.success(api.getCategories()))
        } catch (e: Exception) {
            emit(Resource.error("Check Network Connection!"+e.message,null))
        }
    }

    override fun getRecipes(): Flow<Resource<RecipesResponse>> = flow {
        try {
            emit(Resource.success(api.getRecipes()))
        } catch (e: Exception) {
            emit(Resource.error("Check Network Connection!",null))
        }
    }

}
