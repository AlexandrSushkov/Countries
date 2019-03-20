package com.example.countries.presentation.countrydetails;

import com.example.countries.data.model.Country;
import com.example.countries.di.annotation.PerFragment;
import com.example.countries.di.annotation.ViewModelKey;
import com.example.countries.utils.Constants;

import javax.inject.Named;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module(includes = CountryDetailsModule.CountryDetailsAbstractModule.class)
public abstract class CountryDetailsModule {

    @Provides
    @PerFragment
    @Named(Constants.COUNTRY_KEY)
    public static Country provideCountry(CountryDetailsFragment countryDetailsFragment) {
        return countryDetailsFragment.getArguments().getParcelable(Constants.COUNTRY_KEY);
    }

    @Module
    public interface CountryDetailsAbstractModule {
        @Binds
        @IntoMap
        @ViewModelKey(CountryDetailsViewModel.class)
        @PerFragment
        ViewModel bindsViewModel(CountryDetailsViewModel viewModel);
    }
}
