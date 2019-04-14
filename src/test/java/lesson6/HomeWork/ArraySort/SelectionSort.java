package lesson6.HomeWork.ArraySort;

public class SelectionSort {

    int [] arrToSort;

    SelectionSort (int [] arrToSort) {

        this.arrToSort = arrToSort;
    }

    public int [] arrSelectionSort () {
        int arrMinValue;
        int tempIndex;
        for (int i = 0; i < arrToSort.length; i++) {
            arrMinValue = arrToSort [i];
            tempIndex = i;
            for (int j = i; j < arrToSort.length; j++) {
                if (arrToSort [j] < arrMinValue) {
                    arrMinValue = arrToSort [j];
                    tempIndex = j;
                }
            }
            arrToSort [tempIndex] = arrToSort [i];
            arrToSort [i] = arrMinValue;
            for (int elem : arrToSort){
                System.out.print(elem + " ");
            }
            System.out.println();
        }
        return arrToSort;
    }
}
