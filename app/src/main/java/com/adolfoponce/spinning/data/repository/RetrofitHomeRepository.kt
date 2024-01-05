package com.adolfoponce.spinning.data.repository

import android.util.Log
import com.adolfoponce.spinning.data.network.model.response.CategoriesResponse
import com.adolfoponce.spinning.data.network.model.response.RecipesResponse
import com.adolfoponce.spinning.data.network.services.ServiceApi
import com.adolfoponce.spinning.domain.model.SearchStudiosResponse
import com.adolfoponce.spinning.domain.model.StudioModel
import com.adolfoponce.spinning.domain.repository.HomeRepository
import com.adolfoponce.spinning.utils.Resource
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
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

    override  fun searchStudios(): Flow<Resource<ArrayList<StudioModel>>> = callbackFlow {
        // 2.- We create a reference to our data inside Firestore
        val eventDocument =  FirebaseFirestore
            .getInstance()
            .collection("matriz")
            .document("socios")
            .collection("estudios")
            .get()
        eventDocument
            .addOnSuccessListener { result ->
                var studios :ArrayList<StudioModel> = arrayListOf()
                for (document in result) {
                    studios.add(document.toObject(StudioModel::class.java))
                    Log.d("DATA_INF_DOC", "${document.id} => ${document.data}")
                }
                trySend(Resource.success(studios)).isSuccess
            }
            .addOnFailureListener { exception ->
            }
        awaitClose {  }
    }

}
