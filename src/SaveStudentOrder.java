public class SaveStudentOrder {
    public static void main(String[] args) {
        StudentOrder so = new StudentOrder();
        so.hFirstName = "Aleksey";
        so.hLastName = "Petrov";
        so.wFirstName = "Daria";
        so.wLastName = "Petrova";

        long answer = saveStudentOrder(so);
        System.out.println(answer);
    }

    static long saveStudentOrder(StudentOrder studentOrder) {
        long answer = 199;
        System.out.println("SaveStudentOrder: " + studentOrder.hLastName);
        return answer;
    }
}
