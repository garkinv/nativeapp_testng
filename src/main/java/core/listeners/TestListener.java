package core.listeners;

import core.data.provider.TestDataReader;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import static core.driver.DriverManager.*;
import static core.reporting.AllureListener.takeScreenshot;
import static org.apache.logging.log4j.LogManager.getLogger;

/**
 * Created by Vladimir Garkin on 2/23/18
 */
public class TestListener extends TestListenerAdapter {

    private static final Logger LOG = getLogger();

    public static void failCurrentTest(String message) {
        Assert.fail(message);
    }

    @Override
    public void onStart(ITestContext testContext) {
        super.onStart(testContext);
        // Initialize all needed data for server
        new TestDataReader();
        LOG.info("Test run started");
    }

    @Override
    public void onTestStart(ITestResult result) {
        super.onTestStart(result);
        launchApp();
        LOG.info("Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        super.onTestSuccess(iTestResult);
        closeApp();
        LOG.info("Test succeed: " + iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        super.onTestFailure(iTestResult);
        takeScreenshot(iTestResult.getName());
        closeApp();
        LOG.info("Test failed: " + iTestResult.getName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        super.onTestSkipped(iTestResult);
        closeApp();
        LOG.info("Test skipped: " + iTestResult.getName());
    }

    @Override
    public void onFinish(ITestContext testContext) {
        super.onFinish(testContext);
        getDriver().quit();
        LOG.info("Test run finished");
    }
}