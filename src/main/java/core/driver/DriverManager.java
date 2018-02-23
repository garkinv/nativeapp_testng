package core.driver;

import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.Logger;

import static core.driver.DriverFactory.createDriver;
import static org.apache.logging.log4j.LogManager.getLogger;

/**
 * Created by Vladimir Garkin on 2/23/18
 */
public class DriverManager {
    private static final Logger LOG = getLogger();

    private static boolean isAppOpened;

    private static ThreadLocal<AppiumDriver> appiumDriver = new ThreadLocal<>();

    public static AppiumDriver getDriver() {
        if (appiumDriver.get() == null) {
            LOG.info("Creating driver and launching app");
            appiumDriver.set(createDriver());
            isAppOpened = true;
            LOG.info("App opened");
        }
        return appiumDriver.get();
    }

    public static void launchApp() {
        if (!isAppOpened) {
            LOG.info("Launching app");
            getDriver();
            isAppOpened = true;
            LOG.info("App launched");
        }
    }

    public static void closeApp() {
        if (isAppOpened) {
            LOG.info("Closing app");
            getDriver().closeApp();
            isAppOpened = false;
            LOG.info("App closed");
        }
    }
}