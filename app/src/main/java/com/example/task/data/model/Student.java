package com.example.task.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {
    @ColumnInfo(name = "name")
    private String name;

    @PrimaryKey
    private int rollNo;

    @ColumnInfo(name = "grade")
    private String grade;

    @ColumnInfo(name = "from")
    private String from;

    public Student(String name, int rollNo, String grade, String from) {
        this.name = name;
        this.rollNo = rollNo;
        this.grade = grade;
        this.from = from;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
