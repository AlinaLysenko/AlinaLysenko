package hw5.ex1;

import hw5.AllureScreenshotListener;
import hw5.MainTestClass;
import hw5.steps.ex1.Steps;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.List;

@Listeners({AllureScreenshotListener.class})
public class Ex1 extends MainTestClass {



    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "testData")
    public void checkWebPageContent(
            List<String> expectedHeaderText,
            List<String> expectedIndexText,
            List<String> expectedMenuContentText) {
        Steps steps = new Steps();
        steps.openSite(url);
        steps.loginAs(username, password);
        steps.checkTitle("Home Page");
        steps.checkUsername("ROMAN IOVLEV");
        steps.checkHeaderElements(4, expectedHeaderText);
        steps.checkIndexPageImages(4);
        steps.checkInexPageText(4, expectedIndexText);
        steps.checkFrameButton();
        steps.checkLeftSectionMenuElements(5, expectedMenuContentText);
    }
}
