package stepDefs.actions;


import static utils.WebDriverWaiter.waitForPageReadyState;

import dto.AlreadyRegisteredUserDto;
import elements.implementations.loginpage.LoginPageDesktopImpl;
import io.cucumber.java.DataTableType;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.When;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class LoginPageActionsStepDefs {

    LoginPageDesktopImpl loginPageDesktop = new LoginPageDesktopImpl();

    public LoginPageActionsStepDefs() {
    }


    @DataTableType
    public AlreadyRegisteredUserDto convertUserDetails(@Transpose Map<String, String> entry) {
        return new AlreadyRegisteredUserDto(
                entry.get("Login"),
                entry.get("Password")
        );
    }

    @When("User opens the {string} page")
    public void openPage(String page) {
        log.info("Open " + page + " page");
        log.info("Thread ID" + Thread.currentThread().getId());
        loginPageDesktop.openWebSite();
        waitForPageReadyState(4);
    }

    @When("User enters credentials")
    public void fillCardDetails(Map<String, String> map) {
        AlreadyRegisteredUserDto alreadyRegisteredUserDto = convertUserDetails(map);
        loginPageDesktop.setLogin(alreadyRegisteredUserDto.getLoginName());
        loginPageDesktop.setPassword(alreadyRegisteredUserDto.getPassword());
    }

    @When("User clicks {string} button")
    public void clickLoginButton(String button) {
        log.info("Click " + button + " button");
        loginPageDesktop.clickLoginButton();
    }

}
