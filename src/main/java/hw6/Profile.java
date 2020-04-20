package hw6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Profile {
    WebElement id;
    WebElement type;
    WebElement username;
    WebElement image;
    WebElement vipCheckbox;
    WebElement deskName;

    public Profile(WebElement userRow) {
        List<WebElement> userData = userRow.findElements(By.cssSelector("td"));
        this.id = userData.get(0);
        this.type = userData.get(1).findElement(By.cssSelector("select"));
         this.username = userData.get(2);
        this.image = userData.get(3).findElement(By.cssSelector("img"));
        this.vipCheckbox = userData.get(3).findElement(By.cssSelector(".user-descr > input"));
        this.deskName = userData.get(3).findElement(By.cssSelector(".user-descr > span"));
    }

    public WebElement getId() {
        return id;
    }

    public WebElement getType() {
        return type;
    }

    public WebElement getUsername() {
        return username;
    }

    public WebElement getImage() {
        return image;
    }

    public WebElement getVipCheckbox() {
        return vipCheckbox;
    }

    public WebElement getDeskName() {
        return deskName;
    }

    public List<String> getIdUsernameDeskList(){
        return new ArrayList<String>() {{
            add(id.getText());
            add(username.getText());
            add(deskName.getText().replaceAll("\n"," "));
        }};
    }

    public List<String> getTypeValyes(){
        return new Select(type).getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
    }
}


