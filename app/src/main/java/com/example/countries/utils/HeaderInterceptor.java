package com.example.countries.utils;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Singleton
public class HeaderInterceptor implements Interceptor {

    @Inject
    HeaderInterceptor() {
        // no-op
    }

    @Override public Response intercept(Chain chain) throws IOException {
        final Request request = chain.request();
        final Headers headers = request.headers()
                .newBuilder()
                .add(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON)
                .build();
        return chain.proceed(request.newBuilder().headers(headers).build());
    }
}
