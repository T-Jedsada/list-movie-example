package com.tweentyscoops.listmovieexample.main;

import android.support.annotation.NonNull;

import com.tweentyscoops.listmovieexample.BuildConfig;
import com.tweentyscoops.listmovieexample.model.MovieDao;
import com.tweentyscoops.listmovieexample.repository.MovieApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class MainController {

    private MainView view;

    MainController(MainView view) {
        this.view = view;
    }

    void requestListMovie() {
        // TODO #6 : request APIs list movie
    }

    // FIXME : is bad code
    private MovieApi getMovieApi() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://workshopup.herokuapp.com/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(MovieApi.class);
    }
}
