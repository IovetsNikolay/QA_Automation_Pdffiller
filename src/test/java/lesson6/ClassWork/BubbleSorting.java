package lesson6.ClassWork;

public class BubbleSorting {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 34, 6, 8, 7, 3443, 6, 45};
        int tempVar;
        boolean isSorted;

        for (int j = 0; j < arr.length; j++) {

            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {

                for (int elem : arr) {
                   System.out.print(" " + elem);
                }
                System.out.println();
                if (arr[i] > arr[i + 1]) {
                    isSorted = false;
                    tempVar = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tempVar;
                }
            }
            if (isSorted) {
                break;
            }
            j++;
            System.out.println("***");
        }
    }
}
