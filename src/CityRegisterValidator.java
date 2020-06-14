import javafx.util.converter.ShortStringConverter;

public class CityRegisterValidator {

    String hostName = "default";
    String password = "default";
    String login = "default";

    AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        System.out.println("checkCityRegister is running: " +
                hostName + ":" + login + ":" + password);
        AnswerCityRegister answer = new AnswerCityRegister();
        return answer;
    }
}
