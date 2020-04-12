package hw4.ex1;

import hw4.BaseTestClass;
import hw4.pages.TableWithPagesPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Ex1 extends BaseTestClass {

    TableWithPagesPage tableWithPagesPage;

    @DataProvider
    public Object[][] searchData() {
        return new Object[][]{
                {10, "junit"}
        };
    }

    @Test (dataProvider = "searchData")
    public void checkTableWithPagesContent(int tableLength, String searchValue) {
        tableWithPagesPage = new TableWithPagesPage();
        softAssert.assertEquals(driver.getTitle(), "Home Page", "Not expected Index page title");
        //4	Assert Username is loggined	"ROMAN IOVLEV"
        softAssert.assertTrue(homePage.usernameIsDisplayed());
        softAssert.assertEquals(homePage.getUsername(), "ROMAN IOVLEV",
                "Not expected logged user");

        homePage.switchToTableWithPage();
        softAssert.assertEquals(tableWithPagesPage.getTableLength(), "5", "Unexpected table length value");
        tableWithPagesPage.selectTableLength(String.valueOf(tableLength));
        softAssert.assertEquals(tableWithPagesPage.getTableLength(), String.valueOf(tableLength), "Unexpected result table size");
        softAssert.assertEquals(tableWithPagesPage.getResultTableSize(),tableLength, "Unexpected amount of search results");
        tableWithPagesPage.searchValue(searchValue);
        softAssert.assertTrue(tableWithPagesPage.verifyAllSearchResultsContent(searchValue));
        softAssert.assertAll();
    }
}
