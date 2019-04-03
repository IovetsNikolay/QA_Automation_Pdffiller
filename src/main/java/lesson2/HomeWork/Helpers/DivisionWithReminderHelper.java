package lesson2.HomeWork.Helpers;

import java.util.Scanner;

public class DivisionWithReminderHelper {

    //private Scanner scan;

    /*public DivisionWithReminderHelper (Scanner scan){
        this.scan = scan;
    }*/

    public int calculateRemainingFromDivision (int a, int b) {

        return (a % b);

    }

    public int calculateWholePartOfDivision (int a, int b) {

        return (a - (calculateRemainingFromDivision (a, b)))/b;

    }
}
