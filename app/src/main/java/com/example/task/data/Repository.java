package com.example.task.data;

import com.example.task.data.model.Student;
import com.example.task.data.remote.model.ImageResponse;
import com.example.task.listeners.DatabaseUpdateListener;

import java.util.ArrayList;

/*
This interface contains methods to interact with the inner layer
 */
public interface Repository {

    boolean isValid(String searchText);

    void getImageDetails(String searchText, Callback<ImageResponse> responseCallback);

    void addStudentData(Student student, DatabaseUpdateListener databaseUpdateListener);

    void updateStudentData(Student student);

    void deleteStudentData(Student student);

    Student getStudentData(int rollNo);

    ArrayList<Student> getAllStudents();

}
