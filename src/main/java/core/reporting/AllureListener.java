package core.reporting;

import org.apache.logging.log4j.Logger;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import static core.driver.DriverManager.getDriver;
import static java.lang.String.format;
import static org.apache.logging.log4j.LogManager.getLogger;
import static org.openqa.selenium.OutputType.BYTES;

/**
 * Created by Vladimir Garkin on 2/23/18
 */
public class AllureListener {

    private static final Logger LOG = getLogger();

    @Step("{0}")
    public static void stepInfo(String message) {
        LOG.info(message);
    }

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] takeScreenshot(String screenshotName) {
        LOG.info(format("Screenshot for [%s] taken", screenshotName));
        return getDriver().getScreenshotAs(BYTES);
    }
}
