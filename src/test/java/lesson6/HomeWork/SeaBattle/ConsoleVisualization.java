package lesson6.HomeWork.SeaBattle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleVisualization {

    private final char[] charArr = {'a','b','c','d','e','f','g','h','i','j'};
    private final char[] numArr = {'0','1','2','3','4','5','6','7','8','9'};

    public void playerGreatings () {

    }

    public void prindBoard () {
        System.out.println("     a   b   c   d   e   f   g   h   i   j");
        System.out.println("   =========================================");
            for (int i = 0; i < 10; ++i) {
                for (int j = 0; j < 10; ++j) {
                    if (j == 0) {
                            System.out.print(i + " " + " |" + " - " + "|");
                    } else {
                        System.out.print(" - " + "|");
                    }
                }
                System.out.println();
                if (i < 10) {
                    System.out.println("   =========================================");
                }
            }
        }

    public String userInput (String text) {
        String inputLine = null;
        System.out.print(text + "  ");
        try {
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0 )  return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        inputLine = inputLine.toLowerCase();
        return inputLine;
    }

    public boolean checkUserInput (String userInput) {

        if (userInput == null || !(userInput.length() == 2)) {
            return false;
        }
//        userInput = userInput.toLowerCase();
        boolean letterCheck = false;
        boolean numberCheck = false;
        for (int i = 0; i < 10; i++) {
            if (userInput.charAt(0) == charArr[i]) {
                letterCheck = true;
            }
            if (userInput.charAt(1) == numArr[i]) {
                numberCheck = true;
            }
        }
        return letterCheck && numberCheck;
    }
}
