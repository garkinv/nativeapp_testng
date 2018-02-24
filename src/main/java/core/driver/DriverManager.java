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

    private static AppiumDriver appiumDriver = null;

    public static AppiumDriver getDriver() {
        if (appiumDriver == null) {
            LOG.info("Creating driver and launching app");
            appiumDriver = createDriver();
            isAppOpened = true;
            LOG.info("App opened");
        }
        return appiumDriver;
    }

    public static void launchApp() {
        if (!isAppOpened) {
            LOG.info("Launching app");
            getDriver();
            // this check needs for the first run, because getDriver() runs app already.
            if(!isAppOpened) getDriver().launchApp();
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