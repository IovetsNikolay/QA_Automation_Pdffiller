package lesson2.HomeWork.Helpers;

import java.util.Scanner;

public class OperationsWithNumbersHelper {

    Scanner scanner;

    OperationsWithNumbersHelper(Scanner scanner) {
        this.scanner = scanner;
    }

    public int userInputInt(boolean caseState) {                            //caseState = true - two-digit positive number
        int twoDigNum;                                                      //caseState = false - three-digit positive number
        int threeDigNum;
        int counter = 0;
        if (caseState) {
            do {
                if (counter > 0) {
                    System.out.println("Wrong number, please enter two-digit positive number");
                    System.out.println("***");
                }
                counter++;
                System.out.println("Enter two-digit number to calculate summ of its number: ");
                twoDigNum = scanner.nextInt();
                System.out.println(twoDigNum / 10);
            }
            while (((twoDigNum / 10) < 1) || ((twoDigNum / 10) >= 10));
            return twoDigNum;
        } else {
            do {
                if (counter > 0) {
                    System.out.println("Wrong number, please enter three-digit positive number");
                    System.out.println("***");
                }
                counter++;
                System.out.println("Enter three-digit number to calculate summ of its number: ");
                threeDigNum = scanner.nextInt();
                System.out.println(threeDigNum / 100);
            }
            while (((threeDigNum / 10) < 10) || ((threeDigNum / 100) >= 10));
            return threeDigNum;
        }
    }

    public double userInputDouble() {                //double number with not-null with fractional part
        double fracPartNum;
        int counter = 0;

        do {
            if (counter > 0) {
                System.out.println("Wrong number, please enter number with fractional part");
                System.out.println("***");
            }
            counter++;
            System.out.println("Enter number with fractional not-null part to round it to the nearest integer: ");
            fracPartNum = scanner.nextDouble();
            System.out.println(fracPartNum - (int) fracPartNum);
        }
        while (((fracPartNum - (int) fracPartNum) == 0.0));
        return fracPartNum;
    }

    public int getSummOfTwoDigInt (int num) {
        int numSumm;
        numSumm = (num / 10 + num % 10);
        return numSumm;
    }

    public int getSummOfThreeDigInt (int num) {
        int numSumm;
        int temp = num % 100;
        int temp1 = temp % 10;
        numSumm = (temp1 + (temp - temp1)/10 + ((num - temp) / 100));
        return numSumm;
    }
    public double getRoundDouble(double num) {
        double roundValue = Math.round(num);
        return roundValue;
    }
}



