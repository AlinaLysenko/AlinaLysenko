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
        switch (element) {
            case Water:
                checkboxes.get(0).click();
                break;
            case Earth:
                checkboxes.get(1).click();
                break;
            case Wind:
                checkboxes.get(2).click();
                break;
            case Fire:
                checkboxes.get(3).click();
                break;
        }
    }
}
