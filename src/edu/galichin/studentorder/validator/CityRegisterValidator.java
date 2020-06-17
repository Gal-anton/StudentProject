package edu.galichin.studentorder.validator;

import edu.galichin.studentorder.domain.Child;
import edu.galichin.studentorder.domain.Person;
import edu.galichin.studentorder.domain.StudentOrder;
import edu.galichin.studentorder.domain.register.AnswerCityRegister;
import edu.galichin.studentorder.domain.register.AnswerCityRegisterItem;
import edu.galichin.studentorder.domain.register.CityRegisterResponse;
import edu.galichin.studentorder.exception.CityRegisterException;
import edu.galichin.studentorder.validator.register.CityRegisterChecker;
import edu.galichin.studentorder.validator.register.FakeCityRegisterChecker;

public class CityRegisterValidator {

    private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        AnswerCityRegister answer = new AnswerCityRegister();

        answer.addItem(checkPerson(studentOrder.getHusband()));
        answer.addItem(checkPerson(studentOrder.getWife()));

        for (Child child : studentOrder.getChildren()) {
            answer.addItem(checkPerson(child));
        }

        return answer;
    }

    private AnswerCityRegisterItem checkPerson(Person person) {
        try {
                CityRegisterResponse cAns = personChecker.checkPerson(person);
        } catch (CityRegisterException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
}
