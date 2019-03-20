package com.example.countries.domain;

import com.example.countries.data.model.Country;
import com.example.countries.data.repository.CountriesRepository;
import com.example.countries.data.repository.CountriesRepositoryImpl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class CountriesUseCase {

    private CountriesRepository countriesRepository;

    @Inject
    CountriesUseCase(CountriesRepositoryImpl countriesRepositoryImpl) {
        countriesRepository = countriesRepositoryImpl;
    }

    public Single<List<Country>> getAllCountries() {
        return countriesRepository.getAllCountries()
                .subscribeOn(Schedulers.io());
    }

    public Single<List<Country>> getCountriesByCode(List<String> countriesCodes) {
        return countriesRepository.getCountriesByCode(countriesCodes)
                .subscribeOn(Schedulers.io());
    }
}
