package edu.galichin.studentorder;

import edu.galichin.studentorder.domain.*;
import edu.galichin.studentorder.mail.MailSender;
import edu.galichin.studentorder.validator.ChildrenValidator;
import edu.galichin.studentorder.validator.CityRegisterValidator;
import edu.galichin.studentorder.validator.StudentValidator;
import edu.galichin.studentorder.validator.WeddingValidator;

public class StudentOrderValidator {

    private CityRegisterValidator cityRegisterValidator;
    private WeddingValidator weddingValidator;
    private ChildrenValidator childrenValidator;
    private StudentValidator studentValidator;
    private MailSender mailSender;

    public StudentOrderValidator() {
        cityRegisterValidator = new CityRegisterValidator();
        weddingValidator = new WeddingValidator();
        childrenValidator = new ChildrenValidator();
        studentValidator = new StudentValidator();
        mailSender = new MailSender();
    }

    public void checkAll() {
            StudentOrder[] studentOrdersArray = readStudentOrders();

            for(StudentOrder so : studentOrdersArray) {
                checkOneOrder(so);
            }
    }

    public StudentOrder[] readStudentOrders() {
        StudentOrder[] soArray = new StudentOrder[3];

        for (int i = 0; i < soArray.length; i++) {
            soArray[i] = SaveStudentOrder.buildStudentOrder();
        }

        return soArray;
    }

    public void checkOneOrder(StudentOrder so) {
        AnswerCityRegister cityAnswer = checkCityRegister(so);
        AnswerWedding wedAnswer = checkWedding(so);
        AnswerChildren childAnswer = checkChildren(so);
        AnswerStudent studentAnswer = checkStudent(so);
        sendMail(so);
    }

    private AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        cityRegisterValidator.hostName = "hostName1";
        cityRegisterValidator.login = "login1";
        return cityRegisterValidator.checkCityRegister(studentOrder);
    }

    private AnswerWedding checkWedding(StudentOrder studentOrder) {
        return weddingValidator.checkWedding(studentOrder);
    }

    private AnswerChildren checkChildren(StudentOrder studentOrder) {
        return childrenValidator.checkChildren(studentOrder);
    }

    private AnswerStudent checkStudent(StudentOrder studentOrder) {
        return studentValidator.checkStudent(studentOrder);
    }

    private void sendMail(StudentOrder studentOrder) {
        mailSender.sendMail(studentOrder);
    }
}
