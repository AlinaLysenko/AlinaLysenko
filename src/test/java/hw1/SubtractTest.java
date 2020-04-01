package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubtractTest extends CalculatorTest {

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @DataProvider
    public Object[][] subtractTwoDigitsDataProvider() {
        return new Object[][]{
                {3, 2, 1},
                {6, 3, 3},
        };
    }

    @Test(dataProvider = "subtractTwoDigitsDataProvider", groups = {"gr1"})
    public void subtractTwoDigitsWithDataProvider(double a, double b, double expected) {
        System.out.println("subtractTwoDigits" + a + " " + b);
        double actual = calculator.sub(a, b);
        assertEquals(actual, expected);
    }

    @AfterMethod
    public void tearDownClass() {
        calculator = null;
    }
}
