package edu.galichin.studentorder.validator;

import edu.galichin.studentorder.domain.register.CityRegisterCheckerResponse;
import edu.galichin.studentorder.domain.Person;
import edu.galichin.studentorder.exception.CityRegisterException;

public interface CityRegisterChecker {
    CityRegisterCheckerResponse checkPerson(Person person) throws CityRegisterException;
}
