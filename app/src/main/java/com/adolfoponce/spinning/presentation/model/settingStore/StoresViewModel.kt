package com.adolfoponce.spinning.presentation.model.settingStore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.adolfoponce.spinning.data.network.model.response.CategoriesResponse
import com.adolfoponce.spinning.data.network.model.response.RecipesResponse
import com.adolfoponce.spinning.domain.repository.HomeRepository
import com.adolfoponce.spinning.presentation.base.BaseViewModel
import com.adolfoponce.spinning.utils.Resource
import com.adolfoponce.spinning.utils.Status
import kotlinx.coroutines.launch
import javax.inject.Inject

class StoresViewModel
@Inject constructor(
    private val homeRepository: HomeRepository
) :BaseViewModel(){

    private val _listCategories = MutableLiveData<Resource<CategoriesResponse>>()
    val listCategories: LiveData<Resource<CategoriesResponse>> get() = _listCategories

    private val _listRecipes = MutableLiveData<Resource<RecipesResponse>>()
    val listRecipes: LiveData<Resource<RecipesResponse>> get() = _listRecipes

    //Metodo para obtener las categorias del mock web https://demo0212462.mockable.io/categories
    internal fun getCategories() {
        showLoading()
        viewModelScope.launch {
            homeRepository.getCategories()
                .collect{
                    if(it!=null)
                       _listCategories.value = Resource(Status.SUCCESS, it.data,null)
                    else
                        _listCategories.value = Resource(Status.ERROR, CategoriesResponse(arrayListOf()),null)
                    hideLoading()
                }
        }
    }

    //Metodo para obtener las recetas del mock web https://demo0212462.mockable.io/listRecipes
    internal fun getRecipes() {
        showLoading()
        viewModelScope.launch {
            homeRepository.getRecipes()
                .collect{
                    if(it!=null)
                        _listRecipes.value = Resource(Status.SUCCESS, it.data,null)
                    else
                        _listRecipes.value = Resource(Status.ERROR, RecipesResponse(arrayListOf()),null)
                    hideLoading()
                }
        }
    }
}