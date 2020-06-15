package edu.galichin.studentorder;

import edu.galichin.studentorder.domain.StudentOrder;

public class SaveStudentOrder {
    public static void main(String[] args) {
        StudentOrder so = new StudentOrder();
        so.sethFirstName("Aleksey");
        so.sethLastName("Petrov");
        so.setwFirstName("Daria");
        so.setwLastName("Petrova");

        StudentOrder so1 = new StudentOrder();
        so1.sethFirstName("Aleksey");
        so1.sethLastName("Ivanov");
        so1.setwFirstName("Daria");
        so1.setwLastName("Petrova");

        saveStudentOrder(so);
        saveStudentOrder(so1);
    }

    static void saveStudentOrder(StudentOrder studentOrder) {
        StudentOrderValidator studentOrderValidator = new StudentOrderValidator();
        studentOrderValidator.checkAll(studentOrder);
        System.out.println("SaveStudentOrder: " + studentOrder.gethLastName());
        return;
    }
}
