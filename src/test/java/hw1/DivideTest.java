package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DivideTest {
    private Calculator calculator;

    @DataProvider
    public Object[][] divideTwoDigitsDataProvider() {
        return new Object[][]{
                {6, 2, 3},
                {18, 3, 6},
        };
    }

    @Test(dataProvider = "divideTwoDigitsDataProvider", groups = {"gr2"})
    public void divideTwoDigitsWithDataProvider(double a, double b, double expected) {
        calculator = new Calculator();
        System.out.println("divideTwoDigits" + a + " " + b);
        double actual = calculator.div(a,b);
        assertEquals(actual, expected);
    }
}
