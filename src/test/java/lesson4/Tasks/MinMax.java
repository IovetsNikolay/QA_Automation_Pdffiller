package lesson4.Tasks;

import java.util.Scanner;

public class MinMax {

    private Scanner scan = new Scanner(System.in);

    public int MinValue(int[] arr) {
        int minValue = 10000;
        for (int i : arr) {
            if (minValue > i) {
                minValue = i;
            }
        }
        return minValue;
    }

    public int maxValue(int[] arr) {
        int maxValue = -10000;
        for (int i : arr) {
            if (maxValue < i) {
                maxValue = i;
            }
        }
        return maxValue;
    }

    public int[] formArrayFromUserInput(int numOfElements) {
        int[] intArr = new int[numOfElements];
        for (int i = 0; i < 4; i++) {
            intArr[i] = scan.nextInt();
        }
        return intArr;
    }

    public static void main(String[] args) {
        MinMax obj1 = new MinMax();

        System.out.println("Enter four numbers for array1");
        int[] intArr = obj1.formArrayFromUserInput(4);
        System.out.println("MinValue from 4 numbers");
        System.out.println(obj1.MinValue(intArr));

        int indexOfMax = 0;
        int indexOfMin = 0;
        for (int i = 1; i < intArr.length; i++) {
            if (intArr[i] > intArr[indexOfMax]) {
                indexOfMax = i;
            } else if (intArr[i] < intArr[indexOfMin]) {
                indexOfMin = i;
            }
        }
        //System.out.println("indexOfMax" + indexOfMax);
        //System.out.println("indexOfMin" + indexOfMin);
        int numOfCompares = 0;
        for (int i = 0; i < (intArr.length - 1); i++) {
            if (intArr[i] == intArr[indexOfMin]) {
                numOfCompares++;
            }
        }
        System.out.println("There are " + numOfCompares + " maximum values in array");
        System.out.println("***");
        System.out.println();

        int[] intArr1 = obj1.formArrayFromUserInput(5);

        System.out.println("MinValue from 5 numbers");
        System.out.println(obj1.MinValue(intArr1));

        System.out.println("MaxValue from 6 numbers");
        System.out.println(obj1.maxValue(intArr1));

    }
}

