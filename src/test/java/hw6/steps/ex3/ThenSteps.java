package hw6.steps.ex3;

import hw6.pages.UserTablePage;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class ThenSteps {

    UserTablePage usersTablePage;

    public ThenSteps() {
        usersTablePage = new UserTablePage();
    }

    @Then("{int} log row has {string} text in log section")
    public void checkLogRow(int logAmount, String expectedLog) {
        assertThat(usersTablePage.getLogListSize()).isEqualTo(logAmount);
        assertThat(usersTablePage.logSectionContains(expectedLog)).isTrue();
    }
}
