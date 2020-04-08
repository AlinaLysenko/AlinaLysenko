package hw3.tests.ex1;

import hw3.tests.MainTestClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class Ex1 extends MainTestClass {

    //Browser title equals "Home Page"  Browser title equals "Home Page"

    @Test
    public void checkWebPageContent() {
        softAssert.assertEquals(driver.getTitle(), "Home Page", "Not expected Index page title");

        //Perform login username: Roman pass: Jdi1234
        //4	Assert Username is loggined	"ROMAN IOVLEV"
        softAssert.assertTrue(homePage.usernameIsDisplayed());
        softAssert.assertEquals(homePage.getUsername(), "ROMAN IOVLEV",
                "Not expected logged user");

        //5	Assert that there are 4 items on the header section are displayed and they have proper texts
        // "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"
        softAssert.assertTrue(homePage.allHeaderElementsAreDisplayed());
        softAssert.assertEquals(homePage.getHeaderElementListSize(), 4);
        List<String> expectedHeaderText = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        softAssert.assertEquals(homePage.getHeaderElementListContent(), expectedHeaderText);

        //6	Assert that there are 4 images on the Index Page and they are displayed	4 images	Images are displayed
        softAssert.assertEquals(homePage.getIndexImageWebElementListSize(), 4,
                "Not expected count of images on the Index Page");
        softAssert.assertTrue(homePage.allIndexImageElementsAreDisplayed());

        //7	Assert that there are 4 texts on the Index Page under icons and they have proper text
        // 4 texts below of each image
        softAssert.assertEquals(homePage.getIndexTextWebElementListSize(), 4);
        softAssert.assertTrue(homePage.allIndexTextElementsAreDisplayed());
        List<String> expectedIndexText = Arrays.asList(
                "To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more\u2026");
        softAssert.assertEquals(
                homePage.getIndexTextElementListContent(),
                expectedIndexText,
                "Not expected text under images on the Index Page"
        );

        //8	Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(getWithWaitUntilVisible(By.id("frame")).isDisplayed());

        //9	Switch to the iframe and check that there is “Frame Button” in the iframe
        softAssert.assertTrue(homePage.isFrameDisplayed());
        homePage.switchToFrame();
        homePage.isButtonInFrameDisplayed();

        //10	Switch to original window back
        homePage.switchToDefaultWindow();

        //11	Assert that there are 5 items in the Left Section are displayed and they have proper text
        // “Home”, “Contact form”, “Service”, “Metals & Colors”, “Elements packs”
        softAssert.assertEquals(
                homePage.getLeftSectionMenuListSize(),
                5,
                "Not expected count of images on the Left Section Menu"
        );
        softAssert.assertTrue(homePage.allLeftSectionMenuAreDisplayed());

        List<String> expectedMenuContentText = Arrays.asList(
                "Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        softAssert.assertEquals(
                homePage.getLeftSectionMenuListContent(),
                expectedMenuContentText,
                "Not expected text under images on the Left Section Menu"
        );
        softAssert.assertAll();
    }
}
