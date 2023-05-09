package elements.implementations.launchespage;

import elements.abstractions.page.AbstractPage;
import elements.implementations.launchespage.fragments.DemonstrationLaunchFragment;

public class LaunchesPageDesktopImpl extends AbstractPage {

    public LaunchesPageDesktopImpl() {
        super();
    }

    public DemonstrationLaunchFragment getDemonstrationLaunchFragment() {
        return new DemonstrationLaunchFragment();
    }
}

