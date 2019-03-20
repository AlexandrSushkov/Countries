package com.example.countries.di;

import com.example.countries.CountriesApp;
import com.example.countries.di.module.AppModule;
import com.example.countries.di.module.NetworkModule;
import com.example.countries.di.module.UiModule;


import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
        modules = {
                AppModule.class,
                UiModule.class,
                NetworkModule.class,
                AndroidSupportInjectionModule.class,
                AndroidInjectionModule.class}
)
public interface AppComponent extends AndroidInjector<CountriesApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(CountriesApp application);

        AppComponent build();
    }

    void injectApp(CountriesApp application);

}
