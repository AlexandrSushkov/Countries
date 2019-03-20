package com.example.countries.di.module;

import android.content.Context;

import com.example.countries.CountriesApp;
import com.example.countries.utils.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    Context provideContext(CountriesApp application) {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder()
                .setDateFormat(Constants.DATE_FORMAT)
                .create();
    }
}
