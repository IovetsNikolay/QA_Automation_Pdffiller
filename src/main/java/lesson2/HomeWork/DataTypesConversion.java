package lesson2.HomeWork;

import lesson2.HomeWork.Helpers.ApplicationManager;

public class DataTypesConversion extends ApplicationManager {

    /*
    Написать класс в котором будут примеры приведения типов:
    int->char
    float->char
    float->char->int
     */

    public static void main(String[] args) {
        DataTypesConversion obj1 = new DataTypesConversion();
        obj1.dataTypesConversionHelper.intToChar(76);
        obj1.dataTypesConversionHelper.floatToChar(77.46f);
        obj1.dataTypesConversionHelper.floatToCharToInt(77.46f);

    }

}

