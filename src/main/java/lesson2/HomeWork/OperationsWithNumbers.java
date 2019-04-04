package lesson2.HomeWork;

import lesson2.HomeWork.Helpers.ApplicationManager;

public class OperationsWithNumbers extends ApplicationManager {

    public static void main(String[] args) {
        OperationsWithNumbers operationsWithNumbersObj = new OperationsWithNumbers();

        /*2. В переменной n хранится натуральное двузначное число. Создайте программу,
        вычисляющую и выводящую на экран сумму цифр числа n.*/

        int twoDigNum = operationsWithNumbersObj.operationsWithNumbersHelper.userInputInt(true);
        System.out.println(twoDigNum);
        System.out.println("Result: " + operationsWithNumbersObj.operationsWithNumbersHelper.getSummOfTwoDigInt(twoDigNum));

        /*
        3. В переменной n хранится вещественное число с ненулевой дробной частью.
        Создайте программу, округляющую число n до ближайшего целого и выводящую результат на экран.*/

        double fracPartNum = operationsWithNumbersObj.operationsWithNumbersHelper.userInputDouble();
        System.out.println(fracPartNum);
        System.out.println("Result: " + operationsWithNumbersObj.operationsWithNumbersHelper.getRoundDouble(fracPartNum));

        /*4. В переменной n хранится натуральное трёхзначное число. Создайте программу,
        вычисляющую и выводящую на экран сумму цифр числа n.*/

        int threeDigNum = operationsWithNumbersObj.operationsWithNumbersHelper.userInputInt(false);
        System.out.println(threeDigNum);
        System.out.println("Result: " + operationsWithNumbersObj.operationsWithNumbersHelper.getSummOfThreeDigInt(threeDigNum));
    }
}
