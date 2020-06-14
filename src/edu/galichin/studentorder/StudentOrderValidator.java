package edu.galichin.studentorder;

import edu.galichin.studentorder.domain.*;
import edu.galichin.studentorder.mail.MailSender;
import edu.galichin.studentorder.validator.ChildrenValidator;
import edu.galichin.studentorder.validator.CityRegisterValidator;
import edu.galichin.studentorder.validator.StudentValidator;
import edu.galichin.studentorder.validator.WeddingValidator;

public class StudentOrderValidator {
    public static void main(String[] args) {
    }

    static void checkAll(StudentOrder studentOrder) {

        while (true) {
            if (studentOrder == null) {
                break;
            }
            AnswerCityRegister cityAnswer = checkCityRegister(studentOrder);
            if (cityAnswer.success == true) {
                AnswerWedding wedAnswer = checkWedding(studentOrder);
                AnswerChildren childAnswer = checkChildren(studentOrder);
                AnswerStudent studentAnswer = checkStudent(studentOrder);

                sendMail(studentOrder);
            }

            studentOrder = readStudentOrder();
        }
    }

    static StudentOrder readStudentOrder() {
        StudentOrder studentOrder = new StudentOrder();
        return null;
    }

    static AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        CityRegisterValidator crv1 = new CityRegisterValidator();
        crv1.hostName = "hostName1";
        crv1.login = "login1";
        AnswerCityRegister ans1 = crv1.checkCityRegister(studentOrder);
        return ans1;
    }

    static AnswerWedding checkWedding(StudentOrder studentOrder) {
        WeddingValidator wd = new WeddingValidator();
        return wd.checkWedding(studentOrder);
    }

    static AnswerChildren checkChildren(StudentOrder studentOrder) {
        ChildrenValidator childrenValidator = new ChildrenValidator();
        return childrenValidator.checkChildren(studentOrder);
    }

    static AnswerStudent checkStudent(StudentOrder studentOrder) {
        StudentValidator studentValidator = new StudentValidator();
        return studentValidator.checkStudent(studentOrder);
    }

    static void sendMail(StudentOrder studentOrder) {
        new MailSender().sendMail(studentOrder);
    }
}
