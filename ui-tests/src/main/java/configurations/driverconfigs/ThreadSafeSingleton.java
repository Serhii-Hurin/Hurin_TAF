package configurations.driverconfigs;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Slf4j
public class ThreadSafeSingleton {

    Scenario scenario;

    private static ThreadLocal<WebDriver> DRIVER_POOL;
    private static final int IMPLICIT_WAIT = 60;

    private ThreadSafeSingleton() {
    }

    static {
        WebDriverManager.chromedriver().setup();
        DRIVER_POOL = new ThreadLocal<>();
    }

    public static WebDriver getDriverInstance() {
        if (Objects.isNull(DRIVER_POOL.get())) {
            DRIVER_POOL = setSettings();
        }
        return DRIVER_POOL.get();
    }

    private static ThreadLocal<WebDriver> setSettings() {
        DRIVER_POOL.set(new ChromeDriver());
        DRIVER_POOL.get().manage().timeouts()
                .implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        DRIVER_POOL.get().manage().window().maximize();
        return DRIVER_POOL;
    }


    @After
    public void tearDown() {
        if (scenario.isFailed()) {
            log.error("TEST " + scenario.getName() + " FAILED!");
        }
        if (DRIVER_POOL != null) {
            DRIVER_POOL.get().quit();
            DRIVER_POOL.set(null);
        }
    }

}
