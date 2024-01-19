package com.student.manage;
public class Student {
    private int studentID;
    private String studentName;
    private String studentCity;

    public Student(int studentID, String studentName, String studentCity) {
        super();
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentCity = studentCity;
    } 
    public Student() {
        super();
    }
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
    public int getStudentID() {
        return studentID;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentCity(String studentCity) {
        this.studentCity = studentCity;
    } 
    public String getStudentCity() {
        return studentCity;
    }
}
