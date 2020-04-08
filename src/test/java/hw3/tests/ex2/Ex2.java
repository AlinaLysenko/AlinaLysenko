package hw3.tests.ex2;

import hw3.pages.DifferentElementsPage;
import hw3.tests.MainTestClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Ex2 extends MainTestClass {


    @Test
    private void checkDifferentElementsLogs() throws InterruptedException {
        //2	Assert Browser title equals "Home Page"
        assertEquals(driver.getTitle(), "Home Page", "Not expected Index page title");

        //4	Assert Username is loggined	"ROMAN IOVLEV"
        homePage.usernameIsDisplayed();
        assertEquals(homePage.getUsername(), "ROMAN IOVLEV", "Not expected logged user");

        //5	Open through the header menu Service -> Different Elements Page
        homePage.switchToDifferentElements();
        diffPage = new DifferentElementsPage(driver);
        assertEquals(
                driver.getTitle(),
                "Different Elements",
                "Not expected Different elements page title"
        );

        List<String> expectedLogs = new ArrayList<>();

        //6	Select checkboxes	Water, Wind	Elements are checked
        diffPage.clickOnField("Water");
        expectedLogs.add("Water: condition changed to true");
        diffPage.clickOnField("Wind");
        expectedLogs.add("Wind: condition changed to true");

        //7	Select radio	Selen	Element is checked
        diffPage.clickOnField("Selen");
        expectedLogs.add("metal: value changed to Selen");

        //8	Select in dropdown	Yellow	Element is selected
        diffPage.selectColor("Yellow");
        expectedLogs.add("Colors: value changed to Yellow");

        //9	Assert that
        //•	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //•	for radio button there is a log row and value is corresponded to the status of radio button
        //•	for dropdown there is a log row and value is corresponded to the selected value.
        assertTrue(diffPage.logSectionContains(expectedLogs));
    }
}
