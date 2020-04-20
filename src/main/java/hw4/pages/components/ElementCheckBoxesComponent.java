package hw4.pages.components;

import hw4.enums.Elements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ElementCheckBoxesComponent extends AbstractComponent {

    @FindBy (css = "#elements-checklist > p")
    List<WebElement> checkboxes;

    public ElementCheckBoxesComponent() {
        super();
    }

    public void click(Elements element) {
        checkboxes.get(element.ordinal()).click();
    }
}
