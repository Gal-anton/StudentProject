package edu.galichin.studentorder.domain;

import java.time.LocalDate;

public class Child extends Person {
    private String certificateNumber;
    private LocalDate certificateIssueDate;
    private String certificateDepartment;

    public Child(String surName,
                 String givenName,
                 String patronymic,
                 LocalDate dateOfBirth) {
        super(surName, givenName, patronymic, dateOfBirth);
    }


    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public LocalDate getCertificateIssueDate() {
        return certificateIssueDate;
    }

    public void setCertificateIssueDate(LocalDate certificateIssueDate) {
        this.certificateIssueDate = certificateIssueDate;
    }

    public String getCertificateDepartment() {
        return certificateDepartment;
    }

    public void setCertificateDepartment(String certificateDepartment) {
        this.certificateDepartment = certificateDepartment;
    }
}
