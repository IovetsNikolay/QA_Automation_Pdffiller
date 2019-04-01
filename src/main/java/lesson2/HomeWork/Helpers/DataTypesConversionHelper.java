package lesson2.HomeWork.Helpers;

public class DataTypesConversionHelper {

    private TypeTesterHelper typeTester;
    DataTypesConversionHelper (TypeTesterHelper typeTester) {
        this.typeTester = typeTester;
    }

    public char intToChar(int a) {
        typeTester.printType(a);
        System.out.print("converts to ");
        char ch = (char) a;
        typeTester.printType(ch);
        System.out.println();
        return ch;
    }

    public char floatToChar(float f) {
        typeTester.printType(f);
        System.out.print("converts to ");
        char ch = (char) f;
        typeTester.printType(ch);
        System.out.println();
        return ch;
    }

    public int floatToCharToInt(float f) {
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
}
