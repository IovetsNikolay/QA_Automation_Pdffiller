package lesson14.Homework;

/*
Задача: Вводить с клавиатуры строки до тех пор пока не будет введена пустая строка, после чего вывести строки в отсортированном порядке (алфавитном)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        List<ListFields> listFields = solution.makeList();
        listFields.sort((o1, o2) -> o1.value.compareTo(o2.value));
        for (ListFields s : listFields) {
            System.out.print(s.id + "  ");
            System.out.println(s.value);
        }
    }

    public List<ListFields> makeList () throws IOException {
        List<ListFields> list = new ArrayList<>();
        int iter = 0;
        do {
            String userInput = getUserInput();
            if (userInput.isEmpty())
                break;
            ListFields listFields = new ListFields();
            list.add(listFields);
            list.get(list.size()-1).value = userInput;
            list.get(list.size()-1).id = iter;
            iter++;
        } while(true);
        return list;
    }

    public String getUserInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    public class ListFields {
        public int id;
        public String value;
    }
}