package elements.abstractions.fragment;

import configurations.driverconfigs.ThreadSafeSingleton;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractFragment {

    protected AbstractFragment() {
        PageFactory.initElements(ThreadSafeSingleton.getDriverInstance(), this);
    }
}
