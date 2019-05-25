package lesson10;

public class ExaptionExaxmple {

    public static void main(String[] args) {
        int a = 4;
        try {
            System.out.println(a / 0);
        } catch (ArithmeticException e) {
            System.out.println("Exception!");
            System.out.println(a/1);

        }
    }


}
