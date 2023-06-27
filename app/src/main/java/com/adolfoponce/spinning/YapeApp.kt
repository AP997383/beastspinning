package com.adolfoponce.spinning

import android.app.Application
import com.adolfoponce.spinning.data.di.DataSourceModule
import com.adolfoponce.spinning.data.di.NetworkModule
import com.adolfoponce.spinning.presentation.di.ApplicationComponent
import com.adolfoponce.spinning.presentation.di.DaggerApplicationComponent
import com.adolfoponce.spinning.presentation.di.module.ApplicationModule


class YapeApp: Application() {

    companion object {
        var applicationComponent: ApplicationComponent? = null
        private lateinit var instance: YapeApp
        val managerInstance: YapeApp
            get() {
                if (instance == null) {
                    instance = YapeApp()
                }
                return instance
            }
    }


    override fun onCreate() {
        super.onCreate()
        configureDagger()
    }


    private fun configureDagger() {
        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(applicationContext))
            .dataSourceModule(DataSourceModule())
            .networkModule(
                NetworkModule(
                    "http://demo1252777.mockable.io/"
                )
            )
            .build()
    }

}