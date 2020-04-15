package hw5.ex2;

import hw5.AllureScreenshotListener;
import hw5.emums.Colors;
import hw5.emums.Elements;
import hw5.emums.Metals;
import hw5.MainTestClass;
import hw5.steps.ex2.Steps;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

@Listeners({AllureScreenshotListener.class})
public class Ex2 extends MainTestClass {

    @Test
    private void checkDifferentElementsLogs() throws InterruptedException {
        Steps steps = new Steps();
        List<String> expectedLogs = new ArrayList<>();
        steps.openSite(url);
        steps.loginAs(username, password);
        steps.checkTitle("Home Page");
        steps.checkUsername("ROMAN IOVLEV");
        steps.switchToDifferentElements("Different Elements");
        steps.clickOnCheckbox(Elements.Water);
        expectedLogs.add("Water: condition changed to true");
        steps.clickOnCheckbox(Elements.Wind);
        expectedLogs.add("Wind: condition changed to true");
        steps.clickOnRadioButton(Metals.Selen);
        expectedLogs.add("metal: value changed to Selen");
        steps.clickOnSelect(Colors.Yellow);
        expectedLogs.add("Colors: value changed to Yellow");
        steps.verifyLogs(expectedLogs);
    }
}
