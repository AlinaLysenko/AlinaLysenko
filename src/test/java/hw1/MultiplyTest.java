package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MultiplyTest extends CalculatorTest{



    @DataProvider
    public Object[][] multiplyTwoDigitsDataProvider() {
        return new Object[][]{
                {3, 2, 6},
                {6, 3, 18},
        };
    }

    @Test(dataProvider = "multiplyTwoDigitsDataProvider", groups = {"gr2"})
    public void multiplyTwoDigitsWithDataProvider(double a, double b, double expected) {
        System.out.println("multiplyTwoDigits"+ a + " " + b);
        double actual = calculator.mult(a,b);
        assertEquals(actual, expected);
    }

}
