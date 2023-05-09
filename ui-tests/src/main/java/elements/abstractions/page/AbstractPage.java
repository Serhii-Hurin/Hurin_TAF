package elements.abstractions.page;

import configurations.driverconfigs.ThreadSafeSingleton;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    private static final String PAGE_URL = "http://localhost:8080/";

    protected AbstractPage() {
        PageFactory.initElements(ThreadSafeSingleton.getDriverInstance(), this);
    }

    public String getPageUrl() {
        return PAGE_URL;
    }

}
