package hw4.pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SearchComponent extends AbstractComponent {

    @FindBy(css = "#table-with-pages_length > label > select")
    WebElement tableLengthSelector;

    @FindBy(css = "#table-with-pages > tbody > tr")
    List<WebElement> searchResults;

    @FindBy(css = "#table-with-pages_filter > label > input")
    WebElement searchInputField;

    public SearchComponent() {
        super();
    }

    public String getTableLength() {
        return new Select(tableLengthSelector).getFirstSelectedOption().getText();
    }

    public void selectTableLength(String length) {
        new Select(tableLengthSelector).selectByVisibleText(length);
    }

    public int getResultTableSize (){
        return searchResults.size();
    }

    public void searchValue(String value) {
        searchInputField.sendKeys(value);
    }

    public List<String> getSearchResults(){
        return getWebElementsText(searchResults);
    }

    public boolean verifyAllSearchResultsContent(String value){
        return  getWebElementsText(searchResults).stream()
                .filter(s -> !s.toLowerCase().contains(value.toLowerCase()))
                .count() == 0;
    }
}
