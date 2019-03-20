package com.example.countries.presentation.countrydetails;

import com.example.countries.data.model.Country;
import com.example.countries.domain.CountriesUseCase;
import com.example.countries.presentation.base.BaseViewModel;
import com.example.countries.utils.Constants;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class CountryDetailsViewModel extends BaseViewModel {

    public ObservableBoolean progressBarVisibility = new ObservableBoolean(true);
    public ObservableBoolean hasBorders = new ObservableBoolean(true);

    MutableLiveData<List<Country>> borders = new MutableLiveData<>();

    private CountriesUseCase countriesUseCase;
    private Country country;

    @Inject
    CountryDetailsViewModel(CountriesUseCase countriesUseCase,
                            @Named(Constants.COUNTRY_KEY) Country country
    ) {
        this.countriesUseCase = countriesUseCase;
        this.country = country;
        init();
    }

    private void init() {
        if (country.borders.size() == 0) {
            progressBarVisibility.set(false);
            hasBorders.set(false);
        } else {
            addDisposable(countriesUseCase.getCountriesByCode(country.getBorders())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(countries -> {
                        progressBarVisibility.set(false);
                        borders.setValue(countries);
                    }, this::handleError));
        }
    }

}
