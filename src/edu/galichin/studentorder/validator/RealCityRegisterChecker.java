package edu.galichin.studentorder.validator;

import edu.galichin.studentorder.domain.CityRegisterCheckerResponse;
import edu.galichin.studentorder.domain.Person;
import edu.galichin.studentorder.exception.CityRegisterException;

public class RealCityRegisterChecker implements CityRegisterChecker{

    public CityRegisterCheckerResponse checkPerson(Person person)
            throws CityRegisterException {
        return null;
    }
}
