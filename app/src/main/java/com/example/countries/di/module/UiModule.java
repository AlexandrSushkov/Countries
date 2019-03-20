package com.example.countries.di.module;

import com.example.countries.di.annotation.PerActivity;
import com.example.countries.di.annotation.PerFragment;
import com.example.countries.presentation.base.ViewModelFactory;
import com.example.countries.presentation.countries.CountriesModule;
import com.example.countries.presentation.countries.CountriesFragment;
import com.example.countries.presentation.countrydetails.CountryDetailsFragment;
import com.example.countries.presentation.countrydetails.CountryDetailsModule;
import com.example.countries.presentation.home.HomeActivity;
import com.example.countries.presentation.home.HomeModule;

import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class UiModule {

    @Binds
    abstract ViewModelProvider.Factory provideViewModelFactory(ViewModelFactory factory);

    @PerActivity
    @ContributesAndroidInjector(modules = HomeModule.class)
    abstract HomeActivity contributeHomeActivity();

    @PerFragment
    @ContributesAndroidInjector(modules = CountriesModule.class)
    abstract CountriesFragment contributeCountriesFragment();

    @PerFragment
    @ContributesAndroidInjector(modules = CountryDetailsModule.class)
    abstract CountryDetailsFragment contributeCountryDetailsFragment();
}
