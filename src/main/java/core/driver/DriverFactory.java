package core.driver;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.data.models.DriverConfigs;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static core.constants.Constants.Configuration.*;
import static core.constants.Constants.Devices.ANDROID;
import static core.constants.Constants.Devices.IOS;
import static core.listeners.TestListener.failCurrentTest;
import static io.appium.java_client.remote.MobileCapabilityType.*;
import static java.lang.String.format;
import static java.lang.System.getProperty;
import static java.lang.System.setProperty;
import static org.apache.logging.log4j.LogManager.getLogger;
import static org.springframework.util.ResourceUtils.getFile;

public class DriverFactory {

    private static final Logger LOG = getLogger();

    private static DriverConfigs config;

    public static AppiumDriver createDriver() throws IllegalArgumentException {
        if (getProperty(PLATFORM_PROPERTY) == null) {
            failCurrentTest("Maven profile wasn't selected!!!");
        }
        switch (getProperty(PLATFORM_PROPERTY).toLowerCase()) {
            case IOS: {
                LOG.info("Creating IOS driver");
                loadConfig(IOS);
                return new IOSDriver(getDefaultUrl(), getIosCapabilities());
            }
            case ANDROID: {
                LOG.info("Creating Android driver");
                loadConfig(ANDROID);
                return new AndroidDriver(getDefaultUrl(), getAndroidCapabilities());
            }
            default: {
                throw new IllegalArgumentException(format("Illegal [%s] property specified.\n" +
                                "IOS and Android only supported, specified platform: [%s]",
                        PLATFORM_PROPERTY, getProperty(PLATFORM_PROPERTY)));
            }
        }
    }

    private static DesiredCapabilities getAndroidCapabilities() {
        return getCommonCapabilities(ANDROID_CONFIG_PATH);
    }

    private static DesiredCapabilities getIosCapabilities() {
        return getCommonCapabilities(IOS_CONFIG_PATH);
    }

    private static DesiredCapabilities getCommonCapabilities(String pathToProperties) {
        setProperty(PROPERTIES_PATH_PROPERTY, pathToProperties);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(DEVICE_NAME, config.getDeviceName());
        capabilities.setCapability(PLATFORM_NAME, config.getPlatformName());
        capabilities.setCapability(PLATFORM_VERSION, config.getPlatformVersion());
        capabilities.setCapability(APP, config.getApp());
        capabilities.setCapability(UDID, config.getUdid());
        capabilities.setCapability(FULL_RESET, false);
        capabilities.setCapability(NO_RESET, true);
        capabilities.setCapability(NEW_COMMAND_TIMEOUT, 3000);

        return capabilities;
    }

    private static URL getDefaultUrl() {
        try {
            return new URL(DEFAULT_DRIVER_URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException(format("Invalid Url [%s] specified", "http://127.0.0.1:4723/wd/hub"));
    }

    private static void loadConfig(String platform) {
        try {
            config = new ObjectMapper().readValue(getFile("classpath:config/"
                    + platform + ".json"), DriverConfigs.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}