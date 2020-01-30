package com.example.task.data;

import android.text.TextUtils;

import com.example.task.common.ApiConstants;
import com.example.task.data.model.Student;
import com.example.task.data.remote.ApiService;
import com.example.task.data.remote.model.ImageResponse;
import com.example.task.listeners.DatabaseUpdateListener;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;

/*
This class will iomplement the repository interface and doers the actual logic of it
 */
public class MainRepositoryImpl implements Repository {


    private ApiService apiService;


    public MainRepositoryImpl(ApiService apiService) {
        this.apiService = apiService;
    }


    @Override
    public void getImageDetails(String searchText, Callback<ImageResponse> responseCallback) {
        apiService.getSearchImages(searchText, ApiConstants.CX, ApiConstants.API_KEY).enqueue(new retrofit2.Callback<ImageResponse>() {
            @Override
            public void onResponse(Call<ImageResponse> call, Response<ImageResponse> response) {
                if (responseCallback != null) {
                    responseCallback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<ImageResponse> call, Throwable error) {
                    if (responseCallback != null) {
                        responseCallback.onError(error);
                    }
            }
        });
    }

    @Override
    public void addStudentData(Student student, DatabaseUpdateListener databaseUpdateListener) {

    }

    @Override
    public void updateStudentData(Student student) {

    }

    @Override
    public void deleteStudentData(Student student) {

    }

    @Override
    public Student getStudentData(int rollNo) {
        return null;
    }

    @Override
    public ArrayList<Student> getAllStudents() {
        return null;
    }

    @Override
    public boolean isValid(String searchText) {
        return !TextUtils.isEmpty(searchText);
    }




}
