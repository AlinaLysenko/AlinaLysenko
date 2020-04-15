package hw5.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrameWithButtonComponent extends AbstractComponent {

    @FindBy(id = "frame")
    private WebElement frame;

    @FindBy(id = "button-frame")
    private WebElement button;

    public FrameWithButtonComponent() {
        super();
    }

    public void switchToFrame() {
        driver.switchTo().frame("frame");
    }

    public void switchToDefaultWindow() {
        driver.switchTo().defaultContent();
    }

    public boolean isButtonDisplayed() {
        return button.isDisplayed();
    }

    public boolean isFrameDisplayed() {
        return frame.isDisplayed();
    }
}
