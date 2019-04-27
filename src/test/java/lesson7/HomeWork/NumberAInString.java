package lesson7.HomeWork;

import java.util.ArrayList;
import java.util.Scanner;

public class NumberAInString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("I will coount amount of \"a\" char in String");
        System.out.print("Please enter String :");
        String stringToAnalize = scan.next();
        char [] charArr = stringToAnalize.toCharArray();
        ArrayList<Integer> numArr = new ArrayList<>();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr [i] == 'a') {
                numArr.add(i);
            }
        }
        System.out.print("Result: Number of the \"a\" chars is: " + numArr.size() + ", indexes of the \"a\" char is: [");
        for (int i = 0; i < numArr.size()-1; i++) {
            System.out.print(numArr.get(i) + ", ");
        }
        System.out.println(numArr.get(numArr.size()-1) + "]");
    }
}
