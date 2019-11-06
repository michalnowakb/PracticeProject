package com.sparta.mjn.model;

import java.time.LocalDate;

public class Student {
    private final String studentID;
    private String firstName;
    private String midInitial;
    private String lastName;
    private String gender;
    private String eMail;
    private final LocalDate dateOfBirth;
    private int schoolYeah;
    private Subjects mainSubject;

    public Student(String studentID, String firstName, String midInitial, String lastName, String gender, String eMail, LocalDate dateOfBirth, int schoolYeah, Subjects mainSubject) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.midInitial = midInitial;
        this.lastName = lastName;
        this.gender = gender;
        this.eMail = eMail;
        this.dateOfBirth = dateOfBirth;
        this.schoolYeah = schoolYeah;
        this.mainSubject = mainSubject;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidInitial() {
        return midInitial;
    }

    public void setMidInitial(String midInitial) {
        this.midInitial = midInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getSchoolYeah() {
        return schoolYeah;
    }

    public void setSchoolYeah(int schoolYeah) {
        this.schoolYeah = schoolYeah;
    }

    public Subjects getMainSubject() {
        return mainSubject;
    }

    public void setMainSubject(Subjects mainSubject) {
        this.mainSubject = mainSubject;
    }
}
