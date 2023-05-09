package stepDefs.checks;


import static utils.WebDriverWaiter.waitForPageReadyState;

import elements.implementations.signinpage.SignInPageDesktopImpl;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SignInPageChecksStepDefs {

    SignInPageDesktopImpl signInPageDesktop = new SignInPageDesktopImpl();

    public SignInPageChecksStepDefs() {
    }

    @Then("User is redirected to {string} page")
    public void verifyUserIsRedirected(String page) {
        log.info("User is redirected to " + page + " page");
        waitForPageReadyState(4);
        signInPageDesktop.verifyUserIsRedirected();
    }


}
