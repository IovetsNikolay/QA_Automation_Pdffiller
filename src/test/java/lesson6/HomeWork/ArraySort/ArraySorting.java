package lesson6.HomeWork.ArraySort;

import java.util.Scanner;

public class ArraySorting {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter size of the arraay with random numbers: ");
        int arrSize = scan.nextInt();
        RandomArray randomArray = new RandomArray();
        int [] arr = randomArray.createRandomArr (arrSize);
        for (int arrElem : arr) {
            System.out.print(arrElem + " ");
        }
        System.out.println();
        InsertionSort insertionSort = new InsertionSort(arr);
        SelectionSort selectionSort = new SelectionSort(arr);
        arr = selectionSort.arrSelectionSort();
        for (int arrElem : arr) {
            System.out.print(arrElem + " ");
        }
    }
}
