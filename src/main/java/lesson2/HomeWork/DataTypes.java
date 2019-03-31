package lesson2.HomeWork;

public class DataTypes {

    Typetester type = new Typetester();

    public char intToChar (int a) {
        type.printType(a);
        System.out.print("converts to ");
        char ch = (char) a;
        type.printType(ch);
        System.out.println();
        return ch;
    }

    public char floatToChar (float f) {
        type.printType(f);
        System.out.print("converts to ");
        char ch = (char) f;
        type.printType(ch);
        System.out.println();
        return ch;
    }

    public int floatToCharToInt (float f) {
        type.printType(f);
        System.out.print("converts to ");
        char ch = (char) f;
        type.printType(ch);
        System.out.print("converts to ");
        int i = (int) ch;
        type.printType(i);
        System.out.println();
        return i;
    }

    public static void main(String[] args) {
        DataTypes obj1 = new DataTypes();
        obj1.intToChar(76);
        obj1.floatToChar(77.46f);
        obj1.floatToCharToInt(77.46f);

    }

}

