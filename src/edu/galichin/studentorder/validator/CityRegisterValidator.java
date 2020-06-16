package edu.galichin.studentorder.validator;

import edu.galichin.studentorder.domain.AnswerCityRegister;
import edu.galichin.studentorder.domain.CityRegisterCheckerResponse;
import edu.galichin.studentorder.domain.StudentOrder;
import edu.galichin.studentorder.exception.CityRegisterException;

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
        try {
            CityRegisterCheckerResponse hAns = personChecker.checkPerson(studentOrder.getHusband());
            CityRegisterCheckerResponse wAns = personChecker.checkPerson(studentOrder.getWife());
            CityRegisterCheckerResponse cAns = personChecker.checkPerson(studentOrder.getChild());
        } catch (CityRegisterException ex) {
            ex.printStackTrace();
        }

        return new AnswerCityRegister();
    }
}
