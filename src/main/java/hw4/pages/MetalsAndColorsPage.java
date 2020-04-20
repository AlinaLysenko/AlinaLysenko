package hw4.pages;

import hw4.builder.TestData;
import hw4.pages.components.*;

import java.util.List;

public class MetalsAndColorsPage extends AbstractPage {

    private ElementCheckBoxesComponent elementCheckBoxesComponent;
    private SelectFieldsComponent selectFieldsComponent;
    private SummaryRadioButtonsComponent summaryRadioButtonsComponent;
    private ResultsComponent resultsComponent;

    @Override
    void initElementsOnPage() {
        headerSectionComponent = new HeaderSectionComponent();
        leftSectionMenuComponent = new LeftSectionMenuComponent();
        elementCheckBoxesComponent = new ElementCheckBoxesComponent();
        selectFieldsComponent = new SelectFieldsComponent();
        summaryRadioButtonsComponent = new SummaryRadioButtonsComponent();
        resultsComponent = new ResultsComponent();
    }

    public void clickButtonsAccordingToData(TestData testData) {
        if (testData.getSummary() != null) {
            testData.getSummary().stream().forEach(e -> summaryRadioButtonsComponent.setNumber(e));
        }
        if (testData.getElements() != null) {
            testData.getElements().stream().forEach(e -> elementCheckBoxesComponent.click(e));
        }
        if (testData.getColors() != null) {
            selectFieldsComponent.selectColor(testData.getColors());
        }
        if (testData.getMetals() != null) {
            selectFieldsComponent.selectMetal(testData.getMetals());
        }
        if (testData.getVegetables() != null) {
            selectFieldsComponent.SelectVegetables(testData.getVegetables());
        } else {
            selectFieldsComponent.unselectVegetables(null);
        }
    }

    public void clickSubmitButton() {
        resultsComponent.clickSubmitButton();
    }

    public List<String> getResultsText() {
        return resultsComponent.getResultsText();
    }
}
