package elements.implementations.signinpage;


import configurations.driverconfigs.ThreadSafeSingleton;
import elements.abstractions.page.AbstractPage;
import org.junit.Assert;

public class SignInPageDesktopImpl extends AbstractPage {

    private static final String TITLE = "Report Portal";

    public SignInPageDesktopImpl() {
    }

    public void verifyUserIsRedirected() {
        Assert.assertEquals(TITLE, (ThreadSafeSingleton.getDriverInstance().getTitle()));
    }

}
