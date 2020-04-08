package hw3.pages;

import hw3.pages.components.FrameWithButtonComponent;
import hw3.pages.components.HeaderSectionComponent;
import hw3.pages.components.LeftSectionMenuComponent;
import hw3.pages.components.PageIndexComponent;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class HomePage extends AbstractPage {

    private HeaderSectionComponent headerSectionComponent;
    private PageIndexComponent pageIndexComponent;
    private LeftSectionMenuComponent leftSectionMenuComponent;
    private FrameWithButtonComponent frameWithButtonComponent;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    void initElementsOnPage() {

        this.headerSectionComponent = new HeaderSectionComponent(driver);
        this.pageIndexComponent = new PageIndexComponent(driver);
        this.leftSectionMenuComponent = new LeftSectionMenuComponent(driver);
        this.frameWithButtonComponent = new FrameWithButtonComponent(driver);
    }

    public void logIn(String username, String password) { //not void
        headerSectionComponent.logIn(username, password);
    }

    public boolean usernameIsDisplayed() { //should be not void
        return headerSectionComponent.usernameIsDisplayed(); //nope
    }

    public String getUsername() { //should be not void
        return headerSectionComponent.getUsername(); //nope
    }


    public int getHeaderElementListSize() {
        return this.headerSectionComponent.getHeaderElementListSize();
    }

    public List<String> getHeaderElementListContent() {
        return this.headerSectionComponent.getHeaderElementListContent();
    }

    public boolean allHeaderElementsAreDisplayed() {
        return headerSectionComponent.allHeaderElementsAreDisplayed();
    }

    public int getIndexImageWebElementListSize() {
        return this.pageIndexComponent.getImageWebElementListSize();
    }

    public boolean allIndexImageElementsAreDisplayed() {
        return pageIndexComponent.allImageElementsAreDisplayed();
    }

    public int getIndexTextWebElementListSize() {
        return pageIndexComponent.getTextWebElementListSize();
    }

    public boolean allIndexTextElementsAreDisplayed() {
        return pageIndexComponent.allTextElementsAreDisplayed();
    }

    public List<String> getIndexTextElementListContent() {
        return pageIndexComponent.getTextElementListContent();
    }

    public int getLeftSectionMenuListSize() {
        return leftSectionMenuComponent.getLeftSectionMenuListSize();
    }

    public List<String> getLeftSectionMenuListContent() {
        return leftSectionMenuComponent.getLeftSectionMenuListContent();
    }

    public boolean allLeftSectionMenuAreDisplayed() {
        return leftSectionMenuComponent.allLeftSectionMenuAreDisplayed();
    }

    public HeaderSectionComponent getHeaderSectionComponent() {
        return headerSectionComponent;
    }

    public boolean isFrameDisplayed() {
        return frameWithButtonComponent.isFrameDisplayed();
    }

    public boolean isButtonInFrameDisplayed() {
        return frameWithButtonComponent.isButtonDisplayed();
    }

    public void switchToDefaultWindow() {
        frameWithButtonComponent.switchToDefaultWindow();
    }

    public void switchToFrame() {
        frameWithButtonComponent.switchToFrame();
    }

    public void switchToDifferentElements() {
        leftSectionMenuComponent.switchToDifferentElements();
    }
}
