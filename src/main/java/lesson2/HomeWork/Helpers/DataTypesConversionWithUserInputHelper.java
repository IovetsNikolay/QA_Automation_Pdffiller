package lesson2.HomeWork.Helpers;

import java.util.Scanner;

public class DataTypesConversionWithUserInputHelper {


    private DataTypesConversionHelper dataTypesConversionHelper;
    private TypeTesterHelper typeTester;
    private Scanner scan = new Scanner(System.in);

    DataTypesConversionWithUserInputHelper (TypeTesterHelper typeTester, DataTypesConversionHelper dataTypesConversionHelper) {
        this.typeTester = typeTester;
        this.dataTypesConversionHelper = dataTypesConversionHelper;
    }

    public void charToIntWithUserInput() {
        System.out.println("Please enter some char value that will be converted to int");
        char ch = scan.next().charAt(0);
        typeTester.printType(ch);
        System.out.print("converts to ");
        int i = (int) ch;
        typeTester.printType(i);
        System.out.println();
    }

    public void intToCharWithUserInput() {
        System.out.println("Please enter some int value that will be converted to char");
        int i = scan.nextInt();
        typeTester.printType(i);
        System.out.print("converts to ");
        char ch = dataTypesConversionHelper.intToChar(i);
        typeTester.printType(ch);
        System.out.println();
    }
}
