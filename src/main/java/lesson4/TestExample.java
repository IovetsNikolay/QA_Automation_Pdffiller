package lesson4;

import java.util.ArrayList;

public class TestExample {

    public int MinValue (int [] arr) {
        int minValue = 10000;
        for (int i : arr) {
            if (minValue > i) {
                minValue = i;
            }
    }
        return minValue;
}
    public int maxValue (int [] arr) {
        int maxValue = -10000;
            for (int i : arr) {
                if (maxValue < i) {
                    maxValue = i;
                }
    }
        return maxValue;
}


    public static void main(String[] args) {

        TestExample obj1 = new TestExample();

        int[] arr1 = {1, 2, 3, 4};

        System.out.println("MinValue from 4 numbers");
        System.out.println(obj1.MinValue(arr1));

        System.out.println("MaxValue from 4 numbers");
        System.out.println(obj1.maxValue(arr1));

        int[] arr2 = {1, 2, 3, 4, 5};

        System.out.println("MinValue from 5 numbers");
        System.out.println(obj1.MinValue(arr2));

        System.out.println("MaxValue from 6 numbers");
        System.out.println(obj1.maxValue(arr2));

    }
    }

