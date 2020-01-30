package com.example.task.data.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import com.example.task.data.model.Student;

public class DatabaseManager {
    private String DATABASE_NAME = "Student";
    private StudentDatabase studentDatabase;

    public DatabaseManager(Context context) {
        studentDatabase = Room.databaseBuilder(context, StudentDatabase.class, DATABASE_NAME).build();
    }

    public LiveData<Boolean> addStudent(Student student) {
        MutableLiveData<Boolean> result = new MutableLiveData<>();
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    studentDatabase.getDaoAccess().insert(student);
                    result.postValue(true);
                }catch (Exception e){
                    result.postValue(false);
                }


                return null;
            }
        }.execute();
        return result;
    }

}
