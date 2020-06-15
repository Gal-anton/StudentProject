package edu.galichin.studentorder.validator;

import edu.galichin.studentorder.domain.CityRegisterCheckerResponse;
import edu.galichin.studentorder.domain.Person;

public class FakeCityRegisterChecker implements CityRegisterChecker {

    public CityRegisterCheckerResponse checkPerson(Person person) {
        return null;
    }
}
