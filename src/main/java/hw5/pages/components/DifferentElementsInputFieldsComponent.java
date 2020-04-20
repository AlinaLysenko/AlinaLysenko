package hw5.pages.components;

import hw5.emums.Colors;
import hw5.emums.Elements;
import hw5.emums.Metals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DifferentElementsInputFieldsComponent extends AbstractComponent {

    @FindBy (css = ".label-checkbox")
    List<WebElement> checkboxes;

    @FindBy (css = ".label-radio")
    List<WebElement> radiobuttons;

    @FindBy(css = ".colors > .uui-form-element")
    private WebElement colors;

    public DifferentElementsInputFieldsComponent() {
        super();
    }

    public void clickOnCheckbox(Elements element) {
        checkboxes.get(element.ordinal()).click();
    }

    public void clickOnRadiobutton(Metals metal) {
        radiobuttons.get(metal.ordinal()).click();
    }

    public void selectColor(Colors color) {
        new Select(colors).selectByVisibleText(color.name());
    }
}
