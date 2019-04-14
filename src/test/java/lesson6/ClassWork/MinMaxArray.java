package lesson6.ClassWork;

public class MinMaxArray {
    public static void main(String[] args) {
        int ar[] = {2,3,-1,6,6,6,7,8,9,0,1111};
        int minVal = 2147483647;
        int maxVal = -2147483648;
        for (int i = 0; i < ar.length; i++) {
            if (ar [i] < minVal) {
                minVal = ar [i];
            }
            if (ar [i] > maxVal) {
                maxVal = ar [i];
            }
        }
        System.out.println("minVal: " + minVal);
        System.out.println("maxVal: " + maxVal);
    }
}
