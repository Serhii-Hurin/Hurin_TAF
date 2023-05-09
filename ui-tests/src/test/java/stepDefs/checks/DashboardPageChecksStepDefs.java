package stepDefs.checks;

import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static utils.WebDriverWaiter.waitForPageReadyState;

import elements.implementations.launchespage.LaunchesPageDesktopImpl;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.Then;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DashboardPageChecksStepDefs {

    LaunchesPageDesktopImpl launchesPageDesktop = new LaunchesPageDesktopImpl();

    public DashboardPageChecksStepDefs() {
    }

    @Then("Verify demo api tests have the following amount of tests:")
    public void verifyUserIsRedirected(@Transpose Map<String, String> list) {
        waitForPageReadyState(4);
        assertSoftly(softAssertions -> list
                .forEach((k, v) -> softAssertions
                        .assertThat(
                                launchesPageDesktop.getDemonstrationLaunchFragment()
                                        .getTextOfElementsWithoutDiagram(k))
                        .withFailMessage("Error")
                        .isEqualTo(v)));

    }


}
