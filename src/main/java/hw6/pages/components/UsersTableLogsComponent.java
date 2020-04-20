package hw6.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.regex.Pattern;

public class UsersTableLogsComponent extends AbstractComponent{

    @FindBy(css = ".logs > li")
    private List<WebElement> logList;

    public UsersTableLogsComponent() {
        super();
    }

    private static boolean verifyLogsListContains(List<String> logList, String log) {
        Pattern pattern = Pattern.compile("^\\d{2}:\\d{2}:\\d{2}\\s+" + log);
        return logList.stream()
                .filter(s -> pattern.matcher(s).find())
                .count() == 1;
    }

    public boolean logSectionContains(String expectedLog) {
        return verifyLogsListContains(getWebElementsText(logList), expectedLog);
    }

    public int getLogListSize(){
        return logList.size();
    }
}
