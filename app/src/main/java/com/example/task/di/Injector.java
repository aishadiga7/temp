package com.example.task.di;

import android.content.Context;

import com.example.task.common.ApiConstants;
import com.example.task.common.AppViewModelFacotry;
import com.example.task.data.MainRepositoryImpl;
import com.example.task.data.Repository;
import com.example.task.data.database.DatabaseManager;
import com.example.task.data.remote.ApiService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Injector {
    public static Repository repository;
    public static ApiService apiService;
    public static AppViewModelFacotry appViewModelFacotry;
    public static DatabaseManager databaseManager;



    public static void init(Context context) {

        initRetrofit();
        initViewModelFactory();
        initRepository();
        initDatabaseManager(context);
    }

    private static void initDatabaseManager(Context context) {
        if (databaseManager == null)
            databaseManager = new DatabaseManager(context);
    }

    private static void initRepository() {
        if(repository == null)
            repository = new MainRepositoryImpl(apiService);
    }


    private static void initViewModelFactory() {
        appViewModelFacotry = new AppViewModelFacotry();
    }

    public static AppViewModelFacotry getAppViewModelFacotry() {
        return appViewModelFacotry;
    }

    private static void initRetrofit() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.level(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public static Repository getRepository() {
        return repository;
    }

    public static DatabaseManager getDatabaseManager() {
      return databaseManager;
    }

    public static ApiService getApiService() {
        return apiService;
    }
}
