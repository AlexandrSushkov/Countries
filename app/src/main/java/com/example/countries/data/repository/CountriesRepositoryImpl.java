package com.example.countries.data.repository;

import com.example.countries.data.model.Country;
import com.example.countries.data.remote.Api;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class CountriesRepositoryImpl implements CountriesRepository {

    private final Api api;

    @Inject public CountriesRepositoryImpl(Api api){
        this.api = api;
    }

    @Override
    public Single<List<Country>> getAllCountries() {
        return api.getAllCountries();
    }

    @Override
    public Single<List<Country>> getCountriesByCode(List<String> countriesCodes) {
        return api.getCountriesByCodes(transformToStringQuery(countriesCodes));
    }

    private String transformToStringQuery(@NotNull List<String> countriesCodes){
        String result = "";
        for (int i = 0; i < countriesCodes.size(); i++) {
            if (i == countriesCodes.size() -1){
                result = result.concat(countriesCodes.get(i));
            }else {
                result = result.concat(countriesCodes.get(i).concat(";"));
            }
        }
        return result;
    }
}
