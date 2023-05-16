package com.adolfoponce.spinning.data.di

import com.adolfoponce.spinning.data.repository.RetrofitHomeRepository
import com.adolfoponce.spinning.domain.repository.HomeRepository
import dagger.Module
import dagger.Provides

import javax.inject.Singleton

@Module
class DataSourceModule {

    @Singleton
    @Provides
    fun provideHomeRepository(repository: RetrofitHomeRepository): HomeRepository {
        return repository
    }

}