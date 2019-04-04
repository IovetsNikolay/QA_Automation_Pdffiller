package lesson2.HomeWork;

import lesson2.HomeWork.Helpers.ApplicationManager;

public class DivisionWithReminder extends ApplicationManager {

    public static void main(String[] args){
        DivisionWithReminder helperObj = new DivisionWithReminder();
        /*1. В переменных q и w хранятся два натуральных числа. Создайте программу,
        выводящую на экран результат деления q на w с остатком.
        Пример вывода программы (для случая, когда в q хранится 21, а в w хранится 8):
        21 / 8 = 2 и 5 в остатке*/

        System.out.println("Division of two natural numbers");
        System.out.println("***");
        System.out.print("Enter first natural number: ");
        int a = helperObj.scan.nextInt();
        System.out.print("Enter second natural number: ");
        int b = helperObj.scan.nextInt();
        System.out.println("***");
        System.out.println("Result of the division: ");
        System.out.println("Reaming from the division = " + helperObj.divisionWithReminderHelper.calculateRemainingFromDivision(a, b));
        System.out.println("Whole part of the division = " + helperObj.divisionWithReminderHelper.calculateWholePartOfDivision(a, b));

    }
}
