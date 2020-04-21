package hw6.steps.ex1;

import hw6.emums.Colors;
import hw6.emums.Elements;
import hw6.emums.Metals;
import hw6.pages.DifferentElementsPage;
import io.cucumber.java.en.When;

import java.util.List;

public class WhenSteps {

    DifferentElementsPage differentElementsPage;

    public WhenSteps() {
        differentElementsPage = new DifferentElementsPage();
    }

    @When("I select checkboxes:")
    public void clickDifferentElementsPageCheckboxes(List<String> elements) {
        elements.forEach(e -> differentElementsPage.clickOnCheckbox(Elements.valueOf(e)));
    }

    @When("I select radiobutton {string}")
    public void clickDifferentElementsPageRadiobutton(String metal) {
        differentElementsPage.clickOnRadiobutton(Metals.valueOf(metal));
    }

    @When("I select in color dropdown value {string}")
    public void clickDifferentElementsPageColor(String color) {
        differentElementsPage.selectColor(Colors.valueOf(color));
    }
}
