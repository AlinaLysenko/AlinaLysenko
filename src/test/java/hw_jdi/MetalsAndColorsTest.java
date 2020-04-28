package hw_jdi;


import hw_jdi.entities.MetalsAndColorsData;
import hw_jdi.enums.HeaderMenuItem;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MetalsAndColorsTest extends AbstractTestClass {

    @Test(dataProvider = "dataset", dataProviderClass = MetalsAndColorsDataProvider.class)
    public void metalAndColorsTest(MetalsAndColorsData data) {
        JdiSite.homePage.clickOnHeaderMenuItem(HeaderMenuItem.METALS_AND_COLORS);
        JdiSite.metalAndColorsPage.checkOpened();
        JdiSite.metalAndColorsPage.fillAndSubmitMetalAndColorsForm(data);
        Assert.assertEquals(JdiSite.metalAndColorsPage.getResults(), data.getExpectedResults());
    }
}
