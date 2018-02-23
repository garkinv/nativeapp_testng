package core.constants;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import static core.driver.DriverManager.getDriver;

/**
 * Created by Vladimir Garkin on 2/23/18
 */
public class Constants {
    public static final class Configuration {
        public static final String PLATFORM_PROPERTY = "platform";
        public static final String TEST_SERVER = "server";
        public static final String PROPERTIES_PATH_PROPERTY = "path_to_properties";
        public static final String DEFAULT_DRIVER_URL = "http://127.0.0.1:4723/wd/hub";
        public static final String IOS_CONFIG_PATH = "config/ios.json";
        public static final String ANDROID_CONFIG_PATH = "config/android.json";
    }

    public static final class DataServers {
        public static final String SIT = "sit";
        public static final String SIT_2 = "sit2";
        public static final String ZONE = "zone";
    }

    public static final class Devices {
        public static final String IOS = "ios";
        public static final String ANDROID = "android";
    }

    public static final class Driver {
        public static final boolean IS_ANDROID = getDriver() instanceof AndroidDriver;
        public static final boolean IS_IOS = getDriver() instanceof IOSDriver;
    }
}