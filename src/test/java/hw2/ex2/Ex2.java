package hw2.ex2;

import hw2.MainTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
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
        assertTrue(getWithWaitUntilVisible(By.id("user-name")).isDisplayed());
        assertEquals(getWithWaitUntilVisible(By.id("user-name")).getText(),
                "ROMAN IOVLEV", "Not expected logged user");

        //5	Open through the header menu Service -> Different Elements Page
        getWithWaitUntilClickable(By.linkText("Service")).click();
        getWithWaitUntilClickable(By.linkText("Different elements")).click();
        assertEquals(driver.getTitle(), "Different Elements",
                "Not expected Different elements page title");
        List<String> expectedLogs = new ArrayList<>();

        //6	Select checkboxes	Water, Wind	Elements are checked
        getWithWaitUntilClickable(By.xpath("//label[normalize-space()='Water']")).click();
        expectedLogs.add("Water: condition changed to true");
        getWithWaitUntilClickable(By.xpath("//label[normalize-space()='Wind']")).click();
        expectedLogs.add("Wind: condition changed to true");

        //7	Select radio	Selen	Element is checked
        getWithWaitUntilClickable(By.xpath("//label[normalize-space()='Selen']")).click();
        expectedLogs.add("metal: value changed to Selen");

        //8	Select in dropdown	Yellow	Element is selected
        getWithWaitUntilClickable(By.cssSelector(".colors")).click();
        getWithWaitUntilClickable(By.xpath("//*[text()='Yellow']")).click();
        expectedLogs.add("Colors: value changed to Yellow");
        List<WebElement> webElementLogsList = getElementsWithWaitUntilVisible(By.cssSelector(".logs > li"));
        List<String> logList = getWebElementsText(webElementLogsList);

        //9	Assert that
        //•	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //•	for radio button there is a log row and value is corresponded to the status of radio button
        //•	for dropdown there is a log row and value is corresponded to the selected value.
        expectedLogs.forEach(e -> softAssert.assertTrue(verifyLogsListContains(logList, e)));
    }
}
