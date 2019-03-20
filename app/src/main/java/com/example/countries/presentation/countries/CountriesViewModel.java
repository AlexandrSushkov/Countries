package com.example.countries.presentation.countries;

import com.example.countries.data.model.Country;
import com.example.countries.domain.CountriesUseCase;
import com.example.countries.presentation.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class CountriesViewModel extends BaseViewModel {

    public ObservableBoolean progressBarVisibility = new ObservableBoolean(true);
    MutableLiveData<List<Country>> countriesLiveData = new MutableLiveData<>();

    private CountriesUseCase countriesUseCase;

    @Inject
    CountriesViewModel(CountriesUseCase countriesUseCase) {
        this.countriesUseCase = countriesUseCase;
        init();
    }

    private void init() {
        addDisposable(countriesUseCase.getAllCountries()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(countries -> {
                    progressBarVisibility.set(false);
                    countriesLiveData.setValue(countries);
                }, this::handleError));

    }
}
