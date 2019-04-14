package lesson6.ClassWork;

public class CharArray {

    public static void main(String[] args) {
        int [] charArr = new int [255];
        for (int i = 0; i < 255; i++) {
            charArr [i] = i;
        }

        for (int elem : charArr)
        System.out.print((char)elem + " ");
    }
}