public class StudentOrderValidator {
    public static void main(String[] args) {
        checkAll();
    }

    static void checkAll() {
        StudentOrder studentOrder = readStudentOrder();

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
                studentOrder = readStudentOrder();
            }

        }
    }

    static StudentOrder readStudentOrder() {
        StudentOrder studentOrder = new StudentOrder();
        return studentOrder;
    }

    static AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        AnswerCityRegister answer = new AnswerCityRegister();
        answer.success = false;
        return answer;
    }

    static AnswerWedding checkWedding(StudentOrder studentOrder) {
        AnswerWedding answer = new AnswerWedding();
        return answer;
    }

    static AnswerChildren checkChildren(StudentOrder studentOrder) {
        AnswerChildren answer = new AnswerChildren();
        return answer;
    }

    static AnswerStudent checkStudent(StudentOrder studentOrder) {
        AnswerStudent answer = new AnswerStudent();
        return answer;
    }

    static void sendMail(StudentOrder studentOrder) {

    }
}
