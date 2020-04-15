package hw5.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.regex.Pattern;

public class DifferentElementsLogsComponent extends AbstractComponent {

    @FindBy(css = ".logs > li")
    private List<WebElement> logList;

    public DifferentElementsLogsComponent() {
        super();
    }

    private static boolean verifyLogsListContains(List<String> logList, String log) {
        Pattern pattern = Pattern.compile("^\\d{2}:\\d{2}:\\d{2}\\s+" + log);
        return logList.stream()
                .filter(s -> pattern.matcher(s).find())
                .count() == 1;
    }

    public boolean logSectionContains(List<String> expectedLogs) {
        return expectedLogs.stream()
                .filter(s -> verifyLogsListContains(getWebElementsText(logList), s))
                .count() == expectedLogs.size();
    }
}
