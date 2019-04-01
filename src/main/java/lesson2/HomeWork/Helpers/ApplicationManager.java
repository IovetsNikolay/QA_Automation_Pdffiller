package lesson2.HomeWork.Helpers;

public class ApplicationManager {

    protected TypeTesterHelper typeTester = new TypeTesterHelper ();
    protected DataTypesConversionHelper dataTypesConversionHelper = new DataTypesConversionHelper(typeTester);
    protected DataTypesConversionWithUserInputHelper dataTypesConversionWithUserInputHelper = new DataTypesConversionWithUserInputHelper(typeTester, dataTypesConversionHelper);

}