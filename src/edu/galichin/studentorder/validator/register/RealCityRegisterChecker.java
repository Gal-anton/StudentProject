package edu.galichin.studentorder.validator.register;

import edu.galichin.studentorder.domain.Person;
import edu.galichin.studentorder.domain.register.CityRegisterResponse;
import edu.galichin.studentorder.exception.CityRegisterException;
import edu.galichin.studentorder.exception.TransportException;

public class RealCityRegisterChecker implements CityRegisterChecker {

    public CityRegisterResponse checkPerson(Person person)
            throws CityRegisterException, TransportException {
        return null;
    }
}
