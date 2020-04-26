package hw_jdi.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw_jdi.entities.MetalsAndColorsData;
import hw_jdi.pages.forms.MetalsAndColorsForm;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

@Url("metals-colors.html") @Title("Metal and Colors")
public class MetalsAndColorsPage extends AbstractPage {

    @FindBy(xpath = "//ul[@class='panel-body-list results']//li")
    private UIElement results;

    private MetalsAndColorsForm metalsAndColorsForm;

    public void fillAndSubmitMetalAndColorsForm(MetalsAndColorsData defaultData) {
        metalsAndColorsForm.fillForm(defaultData);
        metalsAndColorsForm.submitForm();
    }

    public List<String> getResults() {
        return results.getAll()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
