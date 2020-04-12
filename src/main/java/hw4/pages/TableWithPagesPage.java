package hw4.pages;

import hw4.pages.components.HeaderSectionComponent;
import hw4.pages.components.LeftSectionMenuComponent;
import hw4.pages.components.SearchComponent;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TableWithPagesPage extends AbstractPage {

    SearchComponent searchComponent;

    @Override
    void initElementsOnPage() {
        headerSectionComponent = new HeaderSectionComponent();
        leftSectionMenuComponent = new LeftSectionMenuComponent();
        searchComponent = new SearchComponent();
    }

    public String getTableLength() {
        return searchComponent.getTableLength();
    }

    public void selectTableLength(String length) {
        searchComponent.selectTableLength(length);
    }

    public int getResultTableSize (){
        return searchComponent.getResultTableSize();
    }

    public void searchValue(String value) {
        searchComponent.searchValue(value);
    }

    public List<String> getSearchResults(){
        return searchComponent.getSearchResults();
    }

    public boolean verifyAllSearchResultsContent(String value){
        return searchComponent.verifyAllSearchResultsContent(value);
    }
}
