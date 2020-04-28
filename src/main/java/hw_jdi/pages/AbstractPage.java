package hw_jdi.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import hw_jdi.entities.User;
import hw_jdi.enums.HeaderMenuItem;
import hw_jdi.pages.forms.LoginForm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hamcrest.Matchers;


public class AbstractPage extends WebPage {
    private LoginForm loginForm;

    @Css("#user-name")
    private Label userName;

    @Css("#user-icon")
    private Button userIcon;

    @Css(".m-l8 > li")
    private Menu headerMenu;

    public void login(User user) {
        userIcon.click();
        loginForm.login(user);
    }

    public void checkLoggedIn(User user) {
        userName.shouldBe().text(Matchers.equalTo(user.getFullName()));
    }

    public void clickOnHeaderMenuItem(HeaderMenuItem item){
        headerMenu.get(item.ordinal()+1).click();
    }
}
