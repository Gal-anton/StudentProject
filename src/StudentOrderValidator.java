public class StudentOrderValidator {
    public static void main(String[] args) {
        checkAll();
    }

    static void checkAll() {
        StudentOrder studentOrder = readStudentOrder();

        AnswerCityRegister cityAnswer = checkCityRegister(studentOrder);
        AnswerWedding wedAnswer = checkWedding(studentOrder);
        AnswerChildren childAnswer = checkChildren(studentOrder);
        AnswerStudent studentAnswer = checkStudent(studentOrder);

        sendMail(studentOrder);
    }

    static StudentOrder readStudentOrder() {
        StudentOrder studentOrder = new StudentOrder();
        return studentOrder;
    }

    static AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        AnswerCityRegister answer = new AnswerCityRegister();
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
