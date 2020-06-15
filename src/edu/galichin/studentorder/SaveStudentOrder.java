package edu.galichin.studentorder;

import edu.galichin.studentorder.domain.Adult;
import edu.galichin.studentorder.domain.StudentOrder;

public class SaveStudentOrder {
    public static void main(String[] args) {
        StudentOrder so = new StudentOrder();

        saveStudentOrder(so);
    }

    static void saveStudentOrder(StudentOrder studentOrder) {
        new StudentOrderValidator().checkAll(studentOrder);
    }

    static StudentOrder buildStudentOrder() {
        StudentOrder so = new StudentOrder();
        Adult husband = new Adult();
        husband.setGivenName("Anton");

        so.setHusband(husband);

        return so;
    }
}
