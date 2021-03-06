package edu.galichin.studentorder.validator.register;

import edu.galichin.studentorder.domain.Adult;
import edu.galichin.studentorder.domain.Child;
import edu.galichin.studentorder.domain.Person;
import edu.galichin.studentorder.domain.register.CityRegisterResponse;
import edu.galichin.studentorder.exception.CityRegisterException;
import edu.galichin.studentorder.exception.TransportException;

public class FakeCityRegisterChecker implements CityRegisterChecker {

    public static final String GOOD_1 = "1000";
    public static final String GOOD_2 = "2000";
    public static final String BAD_1 = "1001";
    public static final String BAD_2 = "2001";
    public static final String ERROR_1 = "1002";
    public static final String ERROR_2 = "2002";
    public static final String ERROR_T_1 = "1003";
    public static final String ERROR_T_2 = "2003";

    public CityRegisterResponse checkPerson(Person person)
            throws CityRegisterException, TransportException {
        CityRegisterResponse response = new CityRegisterResponse();
        if (person instanceof Adult) {
            Adult t = (Adult) person;
            String seria = t.getPassportSeria();
            if (seria.equals(GOOD_1) || seria.equals(GOOD_2)) {
                response.setExisting(true);
                response.setTemporal(false);
            }
            if (seria.equals(BAD_1) || seria.equals(BAD_2)) {
                response.setExisting(false);
            }
            if (seria.equals(ERROR_1) || seria.equals(ERROR_2)) {
                throw new CityRegisterException("1", "GRN Error " + seria);
            }
            if (seria.equals(ERROR_T_1) || seria.equals(ERROR_T_2)) {
                throw new TransportException("Transport Error " + seria);
            }
        } else if (person instanceof Child) {
            response.setExisting(true);
            response.setTemporal(true);
        }

        System.out.println(response);

        return response;
    }
}
