package com.example.countries.presentation.home;

import com.example.countries.di.annotation.PerActivity;
import com.example.countries.di.annotation.ViewModelKey;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
abstract public class HomeModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel.class)
    @PerActivity
    abstract ViewModel bindsViewModel(HomeViewModel viewModel);
}
