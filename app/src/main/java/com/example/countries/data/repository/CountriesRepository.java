package com.example.countries.data.repository;

import com.example.countries.data.model.Country;

import java.util.List;

import io.reactivex.Single;

public interface CountriesRepository {
    Single<List<Country>> getAllCountries();
    Single<List<Country>> getCountriesByCode(List<String> countriesCodes);
}
