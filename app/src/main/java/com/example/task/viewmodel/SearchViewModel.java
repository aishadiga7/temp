package com.example.task.viewmodel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.task.data.Callback;
import com.example.task.data.Repository;
import com.example.task.data.remote.model.ImageResponse;
import com.example.task.data.remote.model.ImageResponseItems;
import com.example.task.views.uimodel.ImageUIModel;

import java.util.ArrayList;

public class SearchViewModel extends ViewModel {

    private Repository repository;
    private MutableLiveData<Boolean> validationLiveData = new MutableLiveData<>();
    private MutableLiveData<ArrayList<ImageUIModel>> imageLiveData = new MutableLiveData<>();



    public SearchViewModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<Boolean> getValidationLiveData() {
        return validationLiveData;
    }

    public LiveData<ArrayList<ImageUIModel>> getImageLiveData() {
        return imageLiveData;
    }


    public void validate(String searchText) {
        validationLiveData.setValue(repository.isValid(searchText));
    }

    public void getImageDetails(String searchText) {
        repository.getImageDetails(searchText, new Callback<ImageResponse>() {
            @Override
            public void onSuccess(ImageResponse response) {
                if (response != null) {
                    imageLiveData.setValue(extractIMageData(response));
                }
            }

            @Override
            public void onError(Throwable error) {
                imageLiveData.setValue(null);
                // TODO: 25/1/20 handle this
            }
        });
    }

    private ArrayList<ImageUIModel> extractIMageData(ImageResponse response) {
        ArrayList<ImageUIModel> imageLists = new ArrayList<>();
        ImageUIModel imageUIModel;
        if (response.getItems() != null && !response.getItems().isEmpty() &&response.getItems().get(0) != null && response.getItems().get(0).getImagePageMap() != null) {
            for (ImageResponseItems item: response.getItems()) {
                imageUIModel = new ImageUIModel();
                imageUIModel.setImageUrl(item.getImagePageMap().getThumbNails().get(0).getUrl());
                imageUIModel.setImageDesc(item.getImagePageMap().getMetatags().get(0).getTitle());
                imageLists.add(imageUIModel);
            }
        }
        return imageLists;
    }

}
