package com.hod.fahim.student_sqli.model;

import java.io.Serializable;

public class Student implements Serializable {

    int StudentId;
    String StudentName,StudentAddress,StudentEmail,StudentPhone;



    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getStudentAddress() {
        return StudentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        StudentAddress = studentAddress;
    }

    public String getStudentEmail() {
        return StudentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        StudentEmail = studentEmail;
    }

    public String getStudentPhone() {
        return StudentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        StudentPhone = studentPhone;
    }

//    public Student() {
//        StudentId = studentId;
//        StudentName = studentName;
//        StudentAddress = studentAddress;
//        StudentEmail = studentEmail;
//        StudentPhone = studentPhone;
//    }
}
