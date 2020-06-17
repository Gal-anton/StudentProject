package edu.galichin.studentorder;

import edu.galichin.studentorder.domain.StudentOrder;
import edu.galichin.studentorder.domain.children.AnswerChildren;
import edu.galichin.studentorder.domain.register.AnswerCityRegister;
import edu.galichin.studentorder.domain.student.AnswerStudent;
import edu.galichin.studentorder.domain.wedding.AnswerWedding;
import edu.galichin.studentorder.mail.MailSender;
import edu.galichin.studentorder.validator.ChildrenValidator;
import edu.galichin.studentorder.validator.CityRegisterValidator;
import edu.galichin.studentorder.validator.StudentValidator;
import edu.galichin.studentorder.validator.WeddingValidator;

import java.util.LinkedList;
import java.util.List;

public class StudentOrderValidator {

    public static final int ITEM_NO = 3;

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
            List<StudentOrder> studentOrdersList = readStudentOrders();

            for(StudentOrder so : studentOrdersList) {
                checkOneOrder(so);
            }
    }

    public List<StudentOrder> readStudentOrders() {
        List<StudentOrder> soList = new LinkedList<>();

        for (int i = 0; i < ITEM_NO; i++) {
            soList.add(SaveStudentOrder.buildStudentOrder(i));
        }
        return soList;
    }

    public void checkOneOrder(StudentOrder so) {
        AnswerCityRegister cityAnswer = checkCityRegister(so);
//        AnswerWedding wedAnswer = checkWedding(so);
//        AnswerChildren childAnswer = checkChildren(so);
//        AnswerStudent studentAnswer = checkStudent(so);
//        sendMail(so);
    }

    private AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
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
