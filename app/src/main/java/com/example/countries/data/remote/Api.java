package com.example.countries.data.remote;

import com.example.countries.data.model.Country;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("all")
    Single<List<Country>> getAllCountries();

    @GET("alpha")
    Single<List<Country>> getCountriesByCodes(@Query("codes") String countriesCodes);

}
