package edu.galichin.studentorder.validator;

import edu.galichin.studentorder.domain.Child;
import edu.galichin.studentorder.domain.Person;
import edu.galichin.studentorder.domain.StudentOrder;
import edu.galichin.studentorder.domain.register.AnswerCityRegister;
import edu.galichin.studentorder.domain.register.AnswerCityRegisterItem;
import edu.galichin.studentorder.domain.register.CityRegisterResponse;
import edu.galichin.studentorder.exception.CityRegisterException;
import edu.galichin.studentorder.exception.TransportException;
import edu.galichin.studentorder.validator.register.CityRegisterChecker;
import edu.galichin.studentorder.validator.register.FakeCityRegisterChecker;

public class CityRegisterValidator {

    public static final String IN_CODE = "NO_GRN";
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

        AnswerCityRegisterItem.CityStatus status;
        AnswerCityRegisterItem.CityError error = null;

        try {
            CityRegisterResponse tmp = personChecker.checkPerson(person);
            status = tmp.isExisting() ?
                    AnswerCityRegisterItem.CityStatus.YES :
                    AnswerCityRegisterItem.CityStatus.NO;

        } catch (CityRegisterException ex) {
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(ex.getCode(), ex.getMessage());
        } catch (TransportException e) {
            e.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(IN_CODE, e.getMessage());
        }

        AnswerCityRegisterItem and = new AnswerCityRegisterItem(status, person, error);

        return and;
    }
}
