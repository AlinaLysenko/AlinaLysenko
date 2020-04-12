package hw4.pages.components;

import hw4.enums.Colors;
import hw4.enums.Metals;
import hw4.enums.Vegetables;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;


public class SelectFieldsComponent extends AbstractComponent {
    @FindBy(css = "#colors > div > div > ul > li")
    List<WebElement> colorsSelector;

    @FindBy(css = "#colors > div > button")
    WebElement colorsButton;

    @FindBy(css = "#metals > input")
    WebElement metals;

    @FindBy(css = "#salad-dropdown > button")
    WebElement vegetables;

    @FindBy(css = "#salad-dropdown > ul > li")
    List<WebElement> vegetableCheckboxes;

    public SelectFieldsComponent() {
        super();
    }

    public void selectMetal(Metals metal) {
        metals.clear();
        metals.sendKeys(metal.name());
    }

    public void selectColor(Colors color) {
        colorsButton.click();
        colorsSelector.get(color.ordinal() + 1).click();
    }

    public void SelectVegetables(List<Vegetables> vegetables) {
        this.vegetables.click();
        vegetableCheckboxes.get(2).click();
        vegetables.stream().forEach(e -> {
            vegetableCheckboxes.get(e.ordinal()).click();
        });
    }

    public void unselectVegetables(List<Vegetables> vegetables) {
        this.vegetables.click();
        vegetableCheckboxes.get(2).click();
    }
}
