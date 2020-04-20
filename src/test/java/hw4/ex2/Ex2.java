package hw4.ex2;

import hw4.BaseTestClass;
import hw4.builder.TestData;
import hw4.pages.HomePage;
import hw4.pages.MetalsAndColorsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Ex2 extends BaseTestClass {

    MetalsAndColorsPage metalsAndColorsPage;

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "testData")
    public void checkMetalsAndColorsContent(TestData testData, List<String> expectedResult) {
        homePage = new HomePage();
        metalsAndColorsPage = new MetalsAndColorsPage();

        homePage.switchToMetalsAndColors();
        metalsAndColorsPage.clickButtonsAccordingToData(testData);
        metalsAndColorsPage.clickSubmitButton();
        Assert.assertEquals(expectedResult, metalsAndColorsPage.getResultsText());
    }
}
