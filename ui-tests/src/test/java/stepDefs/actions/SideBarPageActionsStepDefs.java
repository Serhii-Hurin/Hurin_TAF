package stepDefs.actions;

import elements.implementations.sidebarpage.SideBarPageDesktopImpl;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SideBarPageActionsStepDefs {

    SideBarPageDesktopImpl sideBarPageDesktop = new SideBarPageDesktopImpl();

    public SideBarPageActionsStepDefs() {
    }

    @When("User clicks Launches button")
    public void clickLaunchesButton() {
        log.info("User clicks launches button");
        sideBarPageDesktop.clickLaunchesButton();
    }
}
