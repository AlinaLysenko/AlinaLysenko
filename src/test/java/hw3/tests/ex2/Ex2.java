package hw3.tests.ex2;

import hw3.pages.DifferentElementsPage;
import hw3.tests.MainTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Ex2 extends MainTestClass {

    private static boolean verifyLogsListContains(List<String> logList, String log) {
        Pattern pattern = Pattern.compile("^\\d{2}:\\d{2}:\\d{2}\\s+" + log);
        return logList.stream()
                .filter(s -> pattern.matcher(s).find())
                .count() == 1;
    }

    @Test
    private void checkDifferentElementsLogs() throws InterruptedException {
        //2	Assert Browser title equals "Home Page"
        assertEquals(driver.getTitle(), "Home Page", "Not expected Index page title");

        //4	Assert Username is loggined	"ROMAN IOVLEV"
        homePage.usernameIsDisplayed();
        assertEquals(homePage.getUsername(), "ROMAN IOVLEV", "Not expected logged user");

        //5	Open through the header menu Service -> Different Elements Page
        assertEquals(homePage.switchToDifferentElements().getTitle(), "Different Elements",
                "Not expected Different elements page title");
        diffPage = new DifferentElementsPage(driver);
        List<String> expectedLogs = new ArrayList<>();

        //6	Select checkboxes	Water, Wind	Elements are checked
        diffPage.clickWater();
        expectedLogs.add("Water: condition changed to true");
        diffPage.clickWind();
        expectedLogs.add("Wind: condition changed to true");

        //7	Select radio	Selen	Element is checked
        diffPage.selectSelen();
        expectedLogs.add("metal: value changed to Selen");

        //8	Select in dropdown	Yellow	Element is selected
        diffPage.selectYellow();
        expectedLogs.add("Colors: value changed to Yellow");


        //9	Assert that
        //•	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //•	for radio button there is a log row and value is corresponded to the status of radio button
        //•	for dropdown there is a log row and value is corresponded to the selected value.
        assertTrue(diffPage.logSectionContains(expectedLogs));
    }
}
