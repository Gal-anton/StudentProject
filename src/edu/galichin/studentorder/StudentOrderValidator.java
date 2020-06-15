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

    public void checkAll(StudentOrder studentOrder) {
        boolean stopLoop = false;
        while (!stopLoop) {
            if (studentOrder == null) {
                break;
            }
            AnswerCityRegister cityAnswer = checkCityRegister(studentOrder);
            if (cityAnswer.success) {
                AnswerWedding wedAnswer = checkWedding(studentOrder);
                AnswerChildren childAnswer = checkChildren(studentOrder);
                AnswerStudent studentAnswer = checkStudent(studentOrder);
                sendMail(studentOrder);
            }

            studentOrder = readStudentOrder();
            if (studentOrder == null) {
                stopLoop = true;
            }
        }
    }

    static StudentOrder readStudentOrder() {
        StudentOrder studentOrder = new StudentOrder();
        return null;
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
