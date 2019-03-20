package com.example.countries.presentation.countries;

import com.example.countries.di.annotation.PerFragment;
import com.example.countries.di.annotation.ViewModelKey;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class CountriesModule {

    @Binds
    @IntoMap
    @ViewModelKey(CountriesViewModel.class)
    @PerFragment
    abstract ViewModel bindsViewModel(CountriesViewModel viewModel);
}
