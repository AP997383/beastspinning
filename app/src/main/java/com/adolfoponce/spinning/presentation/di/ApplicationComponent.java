package com.adolfoponce.spinning.presentation.di;

import com.adolfoponce.spinning.data.di.DataSourceModule;
import com.adolfoponce.spinning.data.di.NetworkModule;
import com.adolfoponce.spinning.domain.repository.HomeRepository;
import com.adolfoponce.spinning.presentation.di.module.ApplicationModule;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, DataSourceModule.class, NetworkModule.class})
public interface ApplicationComponent {
    HomeRepository homeRepository();
}