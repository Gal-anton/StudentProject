package edu.galichin.studentorder.domain;

import java.time.LocalDate;

public class Adult extends Person {
    private String passportSeria;
    private String passportNumber;
    private LocalDate passportIssueDate;
    private String passportDepartment;
    private String university;
    private String studentId;

    public Adult(String surName,
                 String givenName,
                 String patronymic,
                 LocalDate dateOfBirth) {
        super(surName, givenName, patronymic, dateOfBirth);
    }


    @Override
    public String getPersonString() {
        return super.getPersonString() + " " + passportSeria;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentID) {
        this.studentId = studentID;
    }

    public String getPassportSeria() {
        return passportSeria;
    }

    public void setPassportSeria(String passportSeria) {
        this.passportSeria = passportSeria;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public LocalDate getPassportIssueDate() {
        return passportIssueDate;
    }

    public void setPassportIssueDate(LocalDate passportIssueDate) {
        this.passportIssueDate = passportIssueDate;
    }

    public String getPassportDepartment() {
        return passportDepartment;
    }

    public void setPassportDepartment(String passportDepartment) {
        this.passportDepartment = passportDepartment;
    }
}
