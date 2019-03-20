package com.example.countries.di.module;


import android.content.Context;
import android.util.Log;

import com.example.countries.BuildConfig;
import com.example.countries.data.remote.Api;
import com.example.countries.utils.Constants;
import com.example.countries.utils.HeaderInterceptor;
import com.google.gson.Gson;
import com.ihsanbal.logging.Level;
import com.ihsanbal.logging.LoggingInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import androidx.annotation.Nullable;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

//set up retrofit and provides api
@Module
public class NetworkModule {

    @Provides
    @Singleton
    @Named("logging")
    Interceptor provideLoggingInterceptor() {
        return new LoggingInterceptor.Builder()
                .loggable(BuildConfig.DEBUG)
                .setLevel(Level.BASIC)
                .log(Log.VERBOSE)
                .request("Request")
                .response("Response")
                .addHeader("version", BuildConfig.VERSION_NAME)
                .build();
    }

    @Provides
    @Singleton
    @Nullable
    Cache provideCache(Context context) {
        if (BuildConfig.DEBUG) return null;
        final File baseDir = context.getCacheDir();
        if (baseDir != null) {
            final File cacheDir = new File(baseDir, "HttpResponseCache");
            return new Cache(cacheDir, 1024 * 1024 * 50);
        } else {
            return null;
        }
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(@Named("logging") Interceptor loggingInterceptor,
                                     HeaderInterceptor headerInterceptor,
                                     @Nullable Cache cache) {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(headerInterceptor)
                .cache(cache)
                .connectTimeout(Constants.TIMEOUT_DURATION_SEC, TimeUnit.SECONDS)
                .readTimeout(Constants.TIMEOUT_DURATION_SEC, TimeUnit.SECONDS)
                .writeTimeout(Constants.TIMEOUT_DURATION_SEC, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(Constants.API_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    Api provideApi(Retrofit retrofit) {
        return retrofit.create(Api.class);
    }

}
