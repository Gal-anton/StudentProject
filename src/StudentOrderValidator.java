public class StudentOrderValidator {
    public static void main(String[] args) {
    }

    static void checkAll(StudentOrder studentOrder) {

        while (true) {
            if (studentOrder == null) {
                break;
            }
            AnswerCityRegister cityAnswer = checkCityRegister(studentOrder);
            if (cityAnswer.success == true) {
                AnswerWedding wedAnswer = checkWedding(studentOrder);
                AnswerChildren childAnswer = checkChildren(studentOrder);
                AnswerStudent studentAnswer = checkStudent(studentOrder);

                sendMail(studentOrder);
            }

            studentOrder = readStudentOrder();
        }
    }

    static StudentOrder readStudentOrder() {
        StudentOrder studentOrder = new StudentOrder();
        return null;
    }

    static AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        CityRegisterValidator crv1 = new CityRegisterValidator();
        crv1.hostName = "hostName1";
        crv1.login = "login1";
        crv1.password = "password1";
        CityRegisterValidator crv2 = new CityRegisterValidator();
        crv2.hostName = "hostName2";
        crv2.login = "login2";
        crv2.password = "password2";
        AnswerCityRegister ans1 = crv1.checkCityRegister(studentOrder);
        AnswerCityRegister ans2 = crv2.checkCityRegister(studentOrder);

        return ans1;
    }

    static AnswerWedding checkWedding(StudentOrder studentOrder) {
        return WeddingValidator.checkWedding(studentOrder);
    }

    static AnswerChildren checkChildren(StudentOrder studentOrder) {
        return ChildrenValidator.checkChildren(studentOrder);
    }

    static AnswerStudent checkStudent(StudentOrder studentOrder) {
        return StudentValidator.checkStudent(studentOrder);
    }

    static void sendMail(StudentOrder studentOrder) {

    }
}
