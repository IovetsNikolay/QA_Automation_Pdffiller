package lesson14.Homework;

/* Минимальное из n чисел
1. Ввести с клавиатуры число n.
2. Считать n целых чисел и заполнить ими список - метод getIntegerList.
3. Найти минимальное число среди элементов списка - метод getMinimum.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SolutionMin {
        public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

        public static int getMinimum(List<Integer> list) {
        list.sort((i1, i2) -> i1.compareTo(i2));
        return list.get(0);
    }

        public static List<Integer> getIntegerList() throws IOException {
            String userInput;
            List<Integer> intList = new ArrayList<>();
            do {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                userInput = reader.readLine();
                if (userInput.isEmpty())
                    break;
                intList.add(Integer.parseInt(userInput));
            } while (true);
            return intList;
    }
}
