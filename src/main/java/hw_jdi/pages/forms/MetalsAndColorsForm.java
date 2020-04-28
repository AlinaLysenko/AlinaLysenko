package hw_jdi.pages.forms;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import hw_jdi.entities.MetalsAndColorsData;
import hw_jdi.enums.Vegetables;

public class MetalsAndColorsForm {
    @UI("[name=custom_radio_odd]")
    private RadioButtons oddSummary;

    @UI("[name=custom_radio_even]")
    private RadioButtons evenSummary;

    @FindBy(xpath = "//p[@class='checkbox'][contains(., '%s')]//label")
    private UIElement elements;

    @JDropdown(root = "#colors",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Dropdown colors;

    @JDropdown(root = "#metals",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Dropdown metals;

    @JDropdown(root = "#vegetables",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Dropdown vegetables;

    @FindBy(css = "#submit-button")
    private Button submit;

    public void fillAndSubmitForm(MetalsAndColorsData data) {
        oddSummary.select(String.valueOf(data.getSummary().get(0)));
        evenSummary.select(String.valueOf(data.getSummary().get(1)));
        data.getElements().forEach(el -> elements.select(el.name()));
        colors.select(data.getColor().name());
        metals.select(data.getMetals().name());
        uncheckedDefaultValue();
        data.getVegetables().forEach(v -> vegetables.select(v.name()));
        submit.click();
    }

    private void uncheckedDefaultValue() {
        vegetables.select(Vegetables.Vegetables.name());
    }
}
