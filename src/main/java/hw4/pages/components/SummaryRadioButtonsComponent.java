package hw4.pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SummaryRadioButtonsComponent extends AbstractComponent {

    @FindBy(css = "#even-selector > p ") //четные
            List<WebElement> evenNumbers;

    @FindBy(css = "#odds-selector > p ")
    List<WebElement> oddNumbers;

    public SummaryRadioButtonsComponent() {
        super();
    }

    public void setNumber(String number) {
        int num = Integer.valueOf(number);
        if (num > 0 && num < 9) {
            if (num % 2 == 0) {
                evenNumbers.get(num / 2 - 1).click();
            } else {
                oddNumbers.get(num / 2).click();
            }
        }
    }
}
