package lesson4.Tasks;

import java.util.Scanner;

public class DateMonth {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        for (;;) {
            System.out.println("Enter the number of the month: ");
            int mounthNum = scan.nextInt();
            if ((0 <= mounthNum) && (mounthNum < 3) || (mounthNum == 12)) {
                System.out.println("It's winter time");
            } else if ((3 <= mounthNum) && (mounthNum < 6)) {
                System.out.println("It's spring time");
            } else if ((6 <= mounthNum) && (mounthNum < 9)) {
                System.out.println("It's summer time");
            } else if ((9 <= mounthNum) && (mounthNum < 12)) {
                System.out.println("It's autumn time");
            } else System.out.println("Please enter correct month number");
        }
    }
}
