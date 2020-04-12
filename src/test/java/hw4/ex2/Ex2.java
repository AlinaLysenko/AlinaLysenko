package hw4.ex2;

import hw4.BaseTestClass;
import hw4.builder.TestData;
import hw4.pages.MetalsAndColorsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Ex2 extends BaseTestClass {

    MetalsAndColorsPage metalsAndColorsPage = new MetalsAndColorsPage();

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "testData")
    public void checkMetalsAndColorsContent(TestData testData, List<String> expectedResult) { //todo: rename test methods
        homePage.switchToMetalsAndColors();
        metalsAndColorsPage.clickButtonsAccordingToData(testData);
        metalsAndColorsPage.clickSubmitButton();
        Assert.assertEquals(expectedResult, metalsAndColorsPage.getResultsText());
    }

}
