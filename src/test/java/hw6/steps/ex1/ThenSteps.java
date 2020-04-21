package hw6.steps.ex1;

import hw6.pages.DifferentElementsPage;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ThenSteps {

    DifferentElementsPage differentElementsPage;

    public ThenSteps() {
        differentElementsPage = new DifferentElementsPage();
    }

    @Then ("Log section should contain:")
    public void verifyDifferentElementsPageLogs(List<String> expectedLogs){
        assertThat(differentElementsPage.logSectionContains(expectedLogs)).isTrue();
    }
}
