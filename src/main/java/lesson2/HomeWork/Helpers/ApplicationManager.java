package lesson2.HomeWork.Helpers;

import java.util.Scanner;

public class ApplicationManager {

    public Scanner scan = new Scanner(System.in);
    protected TypeTesterHelper typeTester = new TypeTesterHelper();
    protected DataTypesConversionHelper dataTypesConversionHelper = new DataTypesConversionHelper(typeTester);
    protected DataTypesConversionWithUserInputHelper dataTypesConversionWithUserInputHelper =
            new DataTypesConversionWithUserInputHelper(typeTester, dataTypesConversionHelper, scan);
    protected DivisionWithReminderHelper divisionWithReminderHelper = new DivisionWithReminderHelper ();
    protected OperationsWithNumbersHelper operationsWithNumbersHelper = new OperationsWithNumbersHelper (scan);

}