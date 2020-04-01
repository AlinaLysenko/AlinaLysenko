package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SumTest extends CalculatorTest {
    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @DataProvider
    public Object[][] sumTwoDigitsDataProvider() {
        return new Object[][]{
                {1, 2, 3},
                {3, 3, 6},
        };
    }

    @Test (dataProvider = "sumTwoDigitsDataProvider", groups = {"gr1"})
    public void sumTwoDigitsWithDataProvider(double a, double b, double expected) {
        System.out.println("sumTwoDigits"+ a + " " + b);
        double actual = calculator.sum(a,b);
        assertEquals(actual, expected);
    }

    @AfterMethod
    public void tearDownClass() {
        calculator = null;
    }
}
