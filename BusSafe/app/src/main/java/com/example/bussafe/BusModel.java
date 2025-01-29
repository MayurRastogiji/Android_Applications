package com.example.bussafe;

public class BusModel {
    String busId, facultyName, facultyNumber;
    int totalStudent, presentStudent, absentStudent;

    public BusModel(String busId, String facultyName, String facultyNumber, int totalStudent, int presentStudent, int absentStudent) {
        this.busId = busId;
        this.facultyName = facultyName;
        this.facultyNumber = facultyNumber;
        this.totalStudent = totalStudent;
        this.presentStudent = presentStudent;
        this.absentStudent = absentStudent;
    }
    public BusModel(String busId, String facultyName, String facultyNumber, int totalStudent, int presentStudent) {
        this.busId = busId;
        this.facultyName = facultyName;
        this.facultyNumber = facultyNumber;
        this.totalStudent = totalStudent;
        this.presentStudent = presentStudent;
        this.absentStudent = totalStudent - presentStudent;
    }



}
