package lesson2.HomeWork;

import java.util.Scanner;

public class DataTypeHelper {

    private final TypeTester typeTester = new TypeTester();
    private Scanner scan = new Scanner(System.in);

    protected char intToChar(int a) {
        typeTester.printType(a);
        System.out.print("converts to ");
        char ch = (char) a;
        typeTester.printType(ch);
        System.out.println();
        return ch;
    }

    protected char floatToChar(float f) {
        typeTester.printType(f);
        System.out.print("converts to ");
        char ch = (char) f;
        typeTester.printType(ch);
        System.out.println();
        return ch;
    }

    protected int floatToCharToInt(float f) {
        typeTester.printType(f);
        System.out.print("converts to ");
        char ch = (char) f;
        typeTester.printType(ch);
        System.out.print("converts to ");
        int i = (int) ch;
        typeTester.printType(i);
        System.out.println();
        return i;
    }

    protected void charToIntWithUserInput() {
        System.out.println("Please enter some char value that will be converted to int");
        char ch = scan.next().charAt(0);
        typeTester.printType(ch);
        System.out.print("converts to ");
        int i = (int) ch;
        typeTester.printType(i);
        System.out.println();
    }

    protected void intToCharWithUserInput() {
        System.out.println("Please enter some int value that will be converted to char");
        int i = scan.nextInt();
        typeTester.printType(i);
        System.out.print("converts to ");
        char ch = (char) i;
        typeTester.printType(ch);
        System.out.println();
    }

}
