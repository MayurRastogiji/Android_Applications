package com.example.bussafe;

public class StudentModel {
    int image;
    String name;
    String number;
    String course;
    int totalShift;
    int presentShift, present;

    public StudentModel(int image, String name, String number, String course, int totalShift, int presentShift, int present){
        this.image = image;
        this.name = name;
        this.number = number;
        this.course = course;
        this.totalShift = totalShift;
        this.presentShift = presentShift;
        this.present = present;
    }
    public StudentModel(String name, String number, String course, int totalShift, int presentShift, int present){
        this.image = R.drawable.baseline_account_circle_24;
        this.name = name;
        this.number = number;
        this.course = course;
        this.totalShift = totalShift;
        this.presentShift = presentShift;
        this.present = present;
    }
}
