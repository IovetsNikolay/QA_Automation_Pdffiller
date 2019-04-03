package lesson2.HomeWork;

import lesson2.HomeWork.Helpers.ApplicationManager;

public class OperationsWithNumbers extends ApplicationManager {

    public static void main(String[] args) {
        OperationsWithNumbers operationsWithNumbersObj = new OperationsWithNumbers();

        int twoDigNum = operationsWithNumbersObj.operationsWithNumbersHelper.getIntFromUserInput(true);
        System.out.println(twoDigNum);
        int threeDigNum = operationsWithNumbersObj.operationsWithNumbersHelper.getIntFromUserInput(false);
        System.out.println(threeDigNum);
        double fracPartNum = operationsWithNumbersObj.operationsWithNumbersHelper.getDoubleFromUserInput();
        System.out.println(fracPartNum);
    }
}
