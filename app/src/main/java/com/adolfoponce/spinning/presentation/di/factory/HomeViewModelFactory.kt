package com.adolfoponce.spinning.presentation.di.factory

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.adolfoponce.spinning.domain.repository.HomeRepository
import com.adolfoponce.spinning.presentation.model.HomeViewModel

@Suppress("UNCHECKED_CAST")
class HomeViewModelFactory(
    private val homeRepository: HomeRepository,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle?,
) :
    AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    override fun <T : ViewModel?> create(key: String, clazz: Class<T>, state: SavedStateHandle): T & Any {
        val viewModel: ViewModel = if (clazz == HomeViewModel::class.java) {
            HomeViewModel(
                homeRepository
            )
        } else {
            throw RuntimeException("Unsupported view model class: $clazz")
        }
        return (viewModel as T)!!
    }
}