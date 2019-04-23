package lesson7;

import java.util.Scanner;

public class Polindrome {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter string:");
        String polindrCheck = scan.next();
        char [] charArr = polindrCheck.toCharArray();
        int j = charArr.length-1;
        boolean logicVar = true;
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] != charArr[j]) {
                logicVar = false;
            }
            j--;
        }
        if (logicVar) {
            System.out.println("IsPolindrome");
        } else {
            System.out.println("notPolindrome");
        }
    }

}
