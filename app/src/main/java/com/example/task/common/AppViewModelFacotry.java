package com.example.task.common;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Database;

import com.example.task.di.Injector;
import com.example.task.viewmodel.DatabaseViewModel;
import com.example.task.viewmodel.SearchViewModel;

public class AppViewModelFacotry implements ViewModelProvider.Factory {


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
       if (modelClass == SearchViewModel.class) {
           return (T) new SearchViewModel(Injector.getRepository());
       } else if (modelClass == DatabaseViewModel.class) {
           return (T) new DatabaseViewModel(Injector.getRepository(), Injector.getDatabaseManager());
       }
       return null;
    }
}
