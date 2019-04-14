package lesson6.HomeWork.ArraySort;

public class InsertionSort {

    public int [] arrToSort;

    InsertionSort (int [] arrToSort) {
        this.arrToSort = arrToSort;
    }

    public int [] insertionSort () {
        int newElement;
        int location;
            for (int k = 1; k < arrToSort.length; k++) {
                newElement = arrToSort[k];
                location = k - 1;
                while (location >= 0 && arrToSort[location] > newElement) {
                    arrToSort[location + 1] = arrToSort[location];
                    location--;
                }
                for (int arrElam : arrToSort) {
                    System.out.print(arrElam + " ");
                }
                System.out.println();
                arrToSort[location + 1] = newElement;
            }
        return arrToSort;
    }
}
