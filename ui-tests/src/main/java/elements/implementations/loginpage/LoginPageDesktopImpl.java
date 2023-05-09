package elements.implementations.loginpage;

import static utils.WebDriverWaiter.waitForVisibilityOfElement;

import configurations.driverconfigs.ThreadSafeSingleton;
import elements.abstractions.page.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageDesktopImpl extends AbstractPage {

    @FindBy(xpath = "//input[@placeholder='Login']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    public LoginPageDesktopImpl() {
    }


    public void setLogin(String login) {
        waitForVisibilityOfElement(100, loginInput);
        loginInput.sendKeys(login);
    }

    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void openWebSite() {
        ThreadSafeSingleton.getDriverInstance().get(getPageUrl());
    }

}
