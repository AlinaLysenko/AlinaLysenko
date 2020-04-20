package hw6.pages;

import hw6.emums.Colors;
import hw6.emums.Elements;
import hw6.emums.Metals;
import hw6.pages.AbstractPage;
import hw6.pages.components.DifferentElementsInputFieldsComponent;
import hw6.pages.components.DifferentElementsLogsComponent;
import hw6.pages.components.HeaderSectionComponent;
import hw6.pages.components.LeftSectionMenuComponent;

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

    public int getLogListSize() {
        return differentElementsLogsComponent.getLogListSize();
    }
}
