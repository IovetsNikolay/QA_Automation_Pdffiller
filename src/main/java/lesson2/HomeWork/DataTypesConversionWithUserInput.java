package lesson2.HomeWork;

import lesson2.HomeWork.Helpers.ApplicationManager;

public class DataTypesConversionWithUserInput extends ApplicationManager {

    public static void main(String[] args) {

        DataTypesConversionWithUserInput obj1 = new DataTypesConversionWithUserInput ();

        obj1.dataTypesConversionWithUserInputHelper.charToIntWithUserInput();
        System.out.println();
        System.out.println("***");
        System.out.println();
        obj1.dataTypesConversionWithUserInputHelper.intToCharWithUserInput();

    }
}
