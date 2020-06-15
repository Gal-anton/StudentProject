package edu.galichin.studentorder.validator;

import edu.galichin.studentorder.domain.CityRegisterCheckerResponse;
import edu.galichin.studentorder.domain.Person;

public interface CityRegisterChecker {
    CityRegisterCheckerResponse checkPerson(Person person);
}
