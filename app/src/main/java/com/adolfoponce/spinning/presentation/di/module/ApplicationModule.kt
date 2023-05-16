package com.adolfoponce.spinning.presentation.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val context: Context) {
    @Singleton
    @Provides
    fun ProvideYapeContext(): Context {
        return context
    }
}