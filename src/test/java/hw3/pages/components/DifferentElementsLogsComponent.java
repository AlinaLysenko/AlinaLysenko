package hw3.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.regex.Pattern;

public class DifferentElementsLogsComponent extends AbstractComponent {
    public DifferentElementsLogsComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".logs > li")
    List<WebElement> logList;

    private static boolean verifyLogsListContains(List<String> logList, String log) {
        Pattern pattern = Pattern.compile("^\\d{2}:\\d{2}:\\d{2}\\s+" + log);
        return logList.stream()
                .filter(s -> pattern.matcher(s).find())
                .count() == 1;
    }

    public boolean logSectionContains(List<String> expectedlogs) {
        return expectedlogs.stream()
                .filter(s -> verifyLogsListContains(getWebElementsText(logList), s))
                .count() == expectedlogs.size();

    }


}
