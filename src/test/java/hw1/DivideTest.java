package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DivideTest extends CalculatorTest {
    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @DataProvider
    public Object[][] divideTwoDigitsDataProvider() {
        return new Object[][]{
                {6, 2, 3},
                {18, 3, 6},
        };
    }

    @Test(dataProvider = "divideTwoDigitsDataProvider", groups = {"gr2"})
    public void divideTwoDigitsWithDataProvider(double a, double b, double expected) {
        System.out.println("divideTwoDigits " + a + " " + b);
        double actual = calculator.div(a, b);
        assertEquals(actual, expected);
    }

    @AfterMethod
    public void tearDownClass() {
        calculator = null;
    }
}
