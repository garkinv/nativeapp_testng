import base.BaseTest;
import core.reporting.QtestTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;

public class SimpleTest extends BaseTest {

    @Test
    @Title("specified description for allure report")
    @Features("Favorites")
    @QtestTests({"TC-12312", "TC-12321ss"})
    public void simpleTest() {
        Assert.assertTrue(true);
    }
}