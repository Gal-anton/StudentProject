package edu.galichin.studentorder.validator;

import edu.galichin.studentorder.domain.Child;
import edu.galichin.studentorder.domain.StudentOrder;
import edu.galichin.studentorder.domain.register.AnswerCityRegister;
import edu.galichin.studentorder.domain.register.CityRegisterCheckerResponse;
import edu.galichin.studentorder.exception.CityRegisterException;

import java.util.List;

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

            List<Child> children = studentOrder.getChildren();
            for (Child child : children) {
                CityRegisterCheckerResponse cAns = personChecker.checkPerson(child);
            }
            } catch (CityRegisterException ex) {
            ex.printStackTrace(System.out);
        }


        return new AnswerCityRegister();
    }
}
