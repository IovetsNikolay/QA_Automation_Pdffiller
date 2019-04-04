package lesson2.HomeWork;

import lesson2.HomeWork.Helpers.ApplicationManager;

public class DataTypesConversionWithUserInput extends ApplicationManager {

    public static void main(String[] args) {

        DataTypesConversionWithUserInput obj1 = new DataTypesConversionWithUserInput();
        /*
        1. Программа char -> int
            Считывает из консоли символ который вы вводите вручную (в консоль).
            Переобразовывает символ в int
            Выводит числовое значение символа
         */
        obj1.dataTypesConversionWithUserInputHelper.charToIntWithUserInput();
        System.out.println();
        System.out.println("***");
        System.out.println();
        /*
        2.  Программа int -> char
            Тоже самое только int -> char
         */
        obj1.dataTypesConversionWithUserInputHelper.intToCharWithUserInput();

    }
}
