package lesson2.ClassWork;

public class Main {
    public static int a = 3;
    public static int b = 4;

    public static int x = 6, y = 3;

    public static final String URL = "Some String";

    public static void main(String[] args) {
        System.out.println(x + "," + y);
        x = 4;

        //Simple tipes
        boolean bool = true;
        byte b = 1;
        char ch = 'f';
        double db = 1.0934234234234;
        float fl = 1.7f;
        int i = 72342342;
        long l = 1;
        short s = 1;

        b = (byte) ch;
        System.out.println("byte to char  " + b);

        char ch1 = (char) b;
        System.out.println("byte to char  " + b);

        fl = (float) i;
        System.out.println("int to float  " + fl);

        fl = (float) db;
        System.out.println("double to float  " + fl);

        //Compose tipes
        Byte b1 = 1;
        Character ch2 = 'f';
        Double db1 = 1.0934234234234;
        Float fl1 = 1.7f;
        Integer i1 = 72342342;
        Long l3 = 1l;
        Short s1 = 1;

        db1 = fl1.doubleValue();
        System.out.println("Float to Double" + db1);


    }
}
