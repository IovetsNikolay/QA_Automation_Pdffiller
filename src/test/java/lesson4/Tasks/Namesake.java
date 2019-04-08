package lesson4.Tasks;

import java.util.Scanner;

public class Namesake {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = scan.next();
        System.out.print("Enter second name: ");
        String secondName = scan.next();
        if (firstName.equals(secondName)) {
            System.out.println("They are namesake!!");
        }
        else System.out.println("They are not namesake!!");
    }
}
