package com.example.task.viewmodel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.task.data.Repository;
import com.example.task.data.database.DatabaseManager;
import com.example.task.data.model.Student;

public class DatabaseViewModel extends ViewModel {
    private Repository repository;
    private DatabaseManager databaseManager;

    public DatabaseViewModel(Repository repository, DatabaseManager databaseManager) {
        this.repository = repository;
        this.databaseManager = databaseManager;
    }

    public LiveData<Boolean> addStudentData(Student student) {
       return databaseManager.addStudent(student);
    }

}
