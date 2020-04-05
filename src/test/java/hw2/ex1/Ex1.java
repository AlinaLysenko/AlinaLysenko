package hw2.ex1;

import hw2.MainTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class Ex1 extends MainTestClass {

    //Browser title equals "Home Page"  Browser title equals "Home Page"
    @Test
    public void checkTitle() {
        softAssert.assertEquals(driver.getTitle(), "Home Page", "Not expected Index page title");
    }

    //Perform login username: Roman pass: Jdi1234
    //4	Assert Username is loggined	"ROMAN IOVLEV"
    @Test
    public void checkLogIn() {
        softAssert.assertTrue(getWithWaitUntilVisible(By.id("user-name")).isDisplayed());
        softAssert.assertEquals(getWithWaitUntilVisible(By.id("user-name")).getText(),"ROMAN IOVLEV",
                "Not expected logged user");
    }

    //5	Assert that there are 4 items on the header section are displayed and they have proper texts
    // "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"
     @Test
    public void checkHeaderSectionItemsDisplayed() {
        List<WebElement> headerElementList = getElementsWithWaitUntilVisible(By.cssSelector(".m-l8 > li"));
        softAssert.assertEquals(headerElementList.size(), 4);
        headerElementList.forEach(e -> softAssert.assertTrue(e.isDisplayed()));
        List<String> actualText = getWebElementsText(headerElementList);
        List<String> expectedText = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        softAssert.assertEquals(actualText, expectedText);
    }

    //6	Assert that there are 4 images on the Index Page and they are displayed	4 images	Images are displayed
    @Test
    public void checkIndexPageImagesDisplayed() {
        List<WebElement> imageWebElementList = getElementsWithWaitUntilVisible(By.className("benefit-icon"));
        softAssert.assertEquals(imageWebElementList.size(), 4,
                "Not expected count of images on the Index Page");
        imageWebElementList.forEach(e -> softAssert.assertTrue(e.isDisplayed()));
    }

    //7	Assert that there are 4 texts on the Index Page under icons and they have proper text
    // 4 texts below of each image
    @Test
    public void checkIndexPageTextsDisplayed() {
        List<WebElement> textWebElementList = getElementsWithWaitUntilVisible(By.className("benefit-txt"));
        textWebElementList.forEach(e -> softAssert.assertTrue(e.isDisplayed()));
        List<String> actualText = getWebElementsText(textWebElementList);
        List<String> expectedText = Arrays.asList(
                "To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

        softAssert.assertEquals(actualText, expectedText,
                "Not expected text under images on the Index Page");
    }

    //8	Assert that there is the iframe with “Frame Button” exist
    @Test
    public void checkFrameWithFrameButtonIsDisplayed() {
        softAssert.assertTrue(getWithWaitUntilVisible(By.id("frame")).isDisplayed());
    }

    //9	Switch to the iframe and check that there is “Frame Button” in the iframe
    @Test
    public void checkFrameButtonIsInFrame() {
        driver.switchTo().frame("frame");
        softAssert.assertTrue(getWithWaitUntilVisible(By.id("frame-button")).isDisplayed());
        //10	Switch to original window back
        driver.switchTo().defaultContent();
    }

    //11	Assert that there are 5 items in the Left Section are displayed and they have proper text
    // “Home”, “Contact form”, “Service”, “Metals & Colors”, “Elements packs”
    @Test
    private void checkLeftSectionMenuTextDisplayed() {
        List<WebElement> leftSectionMenuList = getElementsWithWaitUntilVisible(By.cssSelector(".sidebar-menu>li"));
        softAssert.assertEquals(leftSectionMenuList.size(), 5,
                "Not expected count of images on the Left Section Menu");
        leftSectionMenuList.forEach(e -> softAssert.assertTrue(e.isDisplayed()));
        List<String> actualText = getWebElementsText(leftSectionMenuList);
        List<String> expectedText = Arrays.asList( "Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        softAssert.assertEquals(actualText,expectedText,
        "Not expected text under images on the Left Section Menu");
    }
}
