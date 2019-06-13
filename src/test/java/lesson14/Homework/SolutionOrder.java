/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

package lesson14.Homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.ListIterator;

public class SolutionOrder {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }
        String iteratorTempString;
        ArrayList<Integer> intList = new ArrayList<>();
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()){
            iteratorTempString = listIterator.next().toString();
            if(isNumber(iteratorTempString)) {
                intList.add(Integer.parseInt(iteratorTempString));
                listIterator.remove();
            }
        }
        int maxListLeght = (intList.size() > list.size())?intList.size():list.size();

        list.sort(String::compareTo);
        intList.sort((i1,i2)->i2-i1);

        for (int i =0; i < maxListLeght; i++) {
            if (i < list.size())
                System.out.println(list.get(i));
            if (i < intList.size())
                System.out.println(intList.get(i));
        }
    }
    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
