package edu.galichin.studentorder.validator;

import edu.galichin.studentorder.domain.AnswerCityRegister;
import edu.galichin.studentorder.domain.StudentOrder;

public class CityRegisterValidator {

    public String hostName = "default";
    protected int port = 0;
    private String password = "default";
    public String login = "default";
    private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        personChecker.checkPerson(studentOrder.getHusband());
        personChecker.checkPerson(studentOrder.getWife());
        personChecker.checkPerson(studentOrder.getChild());

        return new AnswerCityRegister();
    }
}
