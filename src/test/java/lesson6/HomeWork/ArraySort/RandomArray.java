package lesson6.HomeWork.ArraySort;

import java.util.Random;

public class RandomArray {

    Random rand = new Random();

    public int [] createRandomArr(int arrSize) {
        int [] arr = new int[arrSize];
        for (int i = 0; i < arr.length; i++) {
            arr [i] = rand.nextInt(100);
        }
        return arr;
    }

}
