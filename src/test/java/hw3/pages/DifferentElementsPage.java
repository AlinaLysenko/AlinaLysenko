package hw3.pages;

import hw3.pages.components.DifferentElementsInputFieldsComponent;
import hw3.pages.components.DifferentElementsLogsComponent;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class DifferentElementsPage extends AbstractPage {
    DifferentElementsLogsComponent differentElementsLogsComponent;
    DifferentElementsInputFieldsComponent differentElementsInputFieldsComponent;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    void initElementsOnPage() {
        differentElementsLogsComponent = new DifferentElementsLogsComponent(driver);
        differentElementsInputFieldsComponent = new DifferentElementsInputFieldsComponent(driver);
    }

    public boolean logSectionContains(List<String> expectedlogs) {
        return differentElementsLogsComponent.logSectionContains(expectedlogs);
    }
    public void clickWater(){
        differentElementsInputFieldsComponent.clickWater();
    }
    public void clickWind(){
        differentElementsInputFieldsComponent.clickWind();
    }
    public void selectSelen(){
        differentElementsInputFieldsComponent.selectSelen();
    }
    public void selectYellow(){
        differentElementsInputFieldsComponent.selectYellow();
    }


}
