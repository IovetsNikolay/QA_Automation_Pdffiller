package lesson4;

public class WhileExample {

    public static void main(String[] args) {
        int i = 1;

        while (i < 5) {
            System.out.println(i);
            i++;
        }
        i = 0;
        do {
            i++;
            System.out.println(i + " ");
        } while (i < 5);
    }
}