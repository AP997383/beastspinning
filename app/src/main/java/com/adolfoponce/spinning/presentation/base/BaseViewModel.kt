package com.adolfoponce.spinning.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import com.adolfoponce.spinning.Event

open class BaseViewModel : ViewModel() {

    protected val baseDisposable = CompositeDisposable()

    private val _showLoading = MutableLiveData<Event<Unit>>()
    val showLoading get() = _showLoading

    private val _hideLoading = MutableLiveData<Event<Unit>>()
    val hideLoading get() = _hideLoading

    private val _serviceError = MutableLiveData<Event<String?>>()
    val serviceError get() = _serviceError

    private val _isOnBackPressed = MutableLiveData<Event<Boolean?>>()
    val isOnBackPressed get() = _isOnBackPressed


    protected fun showLoading() {
        _showLoading.postValue(Event(Unit))
    }

    protected fun hideLoading() {
        _hideLoading.postValue(Event(Unit))
    }

    override fun onCleared() {
        baseDisposable.dispose()
        super.onCleared()
    }
}