package hw5.steps.ex1;

import hw5.pages.HomePage;
import hw5.steps.BaseSteps;
import io.qameta.allure.Step;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Steps extends BaseSteps {
    public Steps() {
        super();
        this.homePage = new HomePage();
    }

    @Step("On the header should be {0} items: {1}")
    public void checkHeaderElements(int expectedSize, List<String> expectedHeaderText) {
        assertTrue(homePage.allHeaderElementsAreDisplayed());
        assertEquals(homePage.getHeaderElementListSize(), 4);
        assertEquals(homePage.getHeaderElementListContent(), expectedHeaderText);
    }

    @Step("On the index page should be displayed {0} images")
    public void checkIndexPageImages(int expectedSize) {
        assertEquals(homePage.getIndexImageWebElementListSize(), expectedSize,
                "Not expected count of images on the Index Page");
        assertTrue(homePage.allIndexImageElementsAreDisplayed());

    }

    @Step("On the index page should be displayed {0} texts: {1}")
    public void checkInexPageText(int expectedSize, List<String> expectedIndexText ) {
        assertEquals(homePage.getIndexTextWebElementListSize(), expectedSize);
        assertTrue(homePage.allIndexTextElementsAreDisplayed());
        assertEquals(
                homePage.getIndexTextElementListContent(),
                expectedIndexText,
                "Not expected text under images on the Index Page"
        );

    }

    @Step ("Frame button should be displayed in the frame")
    public void checkFrameButton(){
        assertTrue(homePage.isFrameDisplayed());
        homePage.switchToFrame();
        homePage.isButtonInFrameDisplayed();
        homePage.switchToDefaultWindow();
    }

    @Step("In the left section menu should be {0} items: {1}")
    public void checkLeftSectionMenuElements(int expectedSize, List<String> expectedMenuContentText) {
        assertEquals(
                homePage.getLeftSectionMenuListSize(),
                expectedSize,
                "Not expected count of images on the Left Section Menu"
        );
        assertTrue(homePage.allLeftSectionMenuAreDisplayed());
        assertEquals(
                homePage.getLeftSectionMenuListContent(),
                expectedMenuContentText,
                "Not expected text under images on the Left Section Menu"
        );
    }


}
