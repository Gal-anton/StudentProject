package edu.galichin.studentorder;

import edu.galichin.studentorder.StudentOrderValidator;
import edu.galichin.studentorder.domain.StudentOrder;

public class SaveStudentOrder {
    public static void main(String[] args) {
        StudentOrder so = new StudentOrder();
        so.hFirstName = "Aleksey";
        so.hLastName = "Petrov";
        so.wFirstName = "Daria";
        so.wLastName = "Petrova";

        StudentOrder so1 = new StudentOrder();
        so1.hFirstName = "Aleksey";
        so1.hLastName = "Ivanov";
        so1.wFirstName = "Daria";
        so1.wLastName = "Petrova";

        saveStudentOrder(so);
        saveStudentOrder(so1);
    }

    static void saveStudentOrder(StudentOrder studentOrder) {
        StudentOrderValidator studentOrderValidator = new StudentOrderValidator();
        studentOrderValidator.checkAll(studentOrder);
        System.out.println("SaveStudentOrder: " + studentOrder.hLastName);
        return;
    }
}
