package edu.galichin.studentorder;

import edu.galichin.studentorder.domain.Adult;
import edu.galichin.studentorder.domain.StudentOrder;

public class SaveStudentOrder {
    public static void main(String[] args) {
        StudentOrder so = buildStudentOrder();

        saveStudentOrder(so);
    }

    static void saveStudentOrder(StudentOrder studentOrder) {
        StudentOrderValidator studentOrderValidator = new StudentOrderValidator();
        studentOrderValidator.checkAll(studentOrder);
    }

    static StudentOrder buildStudentOrder() {
        StudentOrder so = new StudentOrder();
        Adult husband = new Adult();
        husband.setGivenName("Anton");
        husband.setSurName("Galichin");
        husband.setPassportSeria("123456");

        so.setHusband(husband);

        System.out.println(husband.getPersonString());

        return so;
    }
}
