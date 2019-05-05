package lesson8.ClassWork.DevColibryLearn;

import org.testng.annotations.*;

import java.util.List;

public class CalcTest {

    private Calc calc = new Calc();

    public class TestExpectedExceptionTest {

        @Test(expectedExceptions = NullPointerException.class)
        public void testNullPointerException() {
            List list = null;
            int size = list.size();
        }
    }
}
