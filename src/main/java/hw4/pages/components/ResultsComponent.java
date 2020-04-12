package hw4.pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultsComponent extends AbstractComponent{
    @FindBy (id = "submit-button")
    WebElement submitButton;

    @FindBy(css = ".results > li")
    List<WebElement> resultsList;

    public ResultsComponent(){
        super();
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public List<String> getResultsText(){
        return getWebElementsText(resultsList);
    }
}
