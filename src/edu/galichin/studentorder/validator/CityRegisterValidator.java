package edu.galichin.studentorder.validator;

import edu.galichin.studentorder.domain.AnswerCityRegister;
import edu.galichin.studentorder.domain.StudentOrder;

public class CityRegisterValidator {

    public String hostName = "default";
    private String password = "default";
    public String login = "default";

    public AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        System.out.println("checkCityRegister is running: " +
                hostName + ":" + login + ":" + password);
        AnswerCityRegister answer = new AnswerCityRegister();
        return answer;
    }
}
