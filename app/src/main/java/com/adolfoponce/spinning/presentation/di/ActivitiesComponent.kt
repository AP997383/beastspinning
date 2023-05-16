package com.adolfoponce.spinning.presentation.di

import com.adolfoponce.spinning.presentation.di.scope.FragmentScope
import com.adolfoponce.spinning.presentation.ui.MainActivity
import dagger.Component



@FragmentScope
@Component(dependencies = [ApplicationComponent::class])
interface ActivitiesComponent {
    fun inject(target: MainActivity)
}