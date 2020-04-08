package hw3.pages;

import hw3.pages.components.DifferentElementsInputFieldsComponent;
import hw3.pages.components.DifferentElementsLogsComponent;
import hw3.pages.components.HeaderSectionComponent;
import hw3.pages.components.LeftSectionMenuComponent;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class DifferentElementsPage extends AbstractPage {

    private HeaderSectionComponent headerSectionComponent;
    private LeftSectionMenuComponent leftSectionMenuComponent;
    private DifferentElementsLogsComponent differentElementsLogsComponent;
    private DifferentElementsInputFieldsComponent differentElementsInputFieldsComponent;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    void initElementsOnPage() {
        differentElementsLogsComponent = new DifferentElementsLogsComponent(driver);
        differentElementsInputFieldsComponent = new DifferentElementsInputFieldsComponent(driver);
        headerSectionComponent = new HeaderSectionComponent(driver);
        leftSectionMenuComponent = new LeftSectionMenuComponent(driver);
    }

    public boolean logSectionContains(List<String> expectedLogs) {
        return differentElementsLogsComponent.logSectionContains(expectedLogs);
    }

    public void clickOnField(String fieldName) {
        differentElementsInputFieldsComponent.clickOnField(fieldName);
    }

    public void selectColor(String color) {
        differentElementsInputFieldsComponent.selectColor(color);
    }
}
