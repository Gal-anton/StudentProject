package edu.galichin.studentorder;

import edu.galichin.studentorder.domain.Adult;
import edu.galichin.studentorder.domain.StudentOrder;

public class SaveStudentOrder {
    public static void main(String[] args) {
        StudentOrder so = buildStudentOrder();

        saveStudentOrder();
    }

    static void saveStudentOrder() {
        StudentOrderValidator studentOrderValidator = new StudentOrderValidator();
        studentOrderValidator.checkAll();
    }

    static StudentOrder buildStudentOrder() {
        StudentOrder so = new StudentOrder();
        Adult husband = new Adult("Galichin","Anton", "Nicolaevich", null);
        husband.setPassportSeria("123456");

        so.setHusband(husband);

        System.out.println(husband.getPersonString());

        return so;
    }
}
