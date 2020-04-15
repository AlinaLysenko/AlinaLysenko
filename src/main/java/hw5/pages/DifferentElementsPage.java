package hw5.pages;

import hw5.emums.Colors;
import hw5.emums.Elements;
import hw5.emums.Metals;
import hw5.pages.components.DifferentElementsInputFieldsComponent;
import hw5.pages.components.DifferentElementsLogsComponent;
import hw5.pages.components.HeaderSectionComponent;
import hw5.pages.components.LeftSectionMenuComponent;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class DifferentElementsPage extends AbstractPage {

    private HeaderSectionComponent headerSectionComponent;
    private LeftSectionMenuComponent leftSectionMenuComponent;
    private DifferentElementsLogsComponent differentElementsLogsComponent;
    private DifferentElementsInputFieldsComponent differentElementsInputFieldsComponent;

    public DifferentElementsPage() {
        super();
    }

    @Override
    void initElementsOnPage() {
        differentElementsLogsComponent = new DifferentElementsLogsComponent();
        differentElementsInputFieldsComponent = new DifferentElementsInputFieldsComponent();
    }

    public boolean logSectionContains(List<String> expectedLogs) {
        return differentElementsLogsComponent.logSectionContains(expectedLogs);
    }


    public void clickOnCheckbox(Elements element) {
        differentElementsInputFieldsComponent.clickOnCheckbox(element);
    }

    public void clickOnRadiobutton(Metals metal) {
        differentElementsInputFieldsComponent.clickOnRadiobutton(metal);
    }

    public void selectColor(Colors color) {
        differentElementsInputFieldsComponent.selectColor(color);
    }
}
