package core.listeners;

import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static org.apache.logging.log4j.LogManager.getLogger;

/**
 * Created by Vladimir Garkin on 2/23/18
 */
public class Retry implements IRetryAnalyzer {

    private static final Logger LOG = getLogger();

    int count = 0;
    int maxTry = 2;

    @Override
    public boolean retry(ITestResult result) {

        if (!result.isSuccess()) {                      //Check if test not succeed
            if (count < maxTry) {                            //Check if maxtry count is reached
                count++;                                     //Increase the maxTry count by 1
                LOG.info("Test failed!!!\nDoing try# " + count + ". For test: " + result.getName());
                result.setStatus(ITestResult.FAILURE);  //Mark test as failed
                return true;                                 //Tells TestNG to re-run the test
            } else {
                result.setStatus(ITestResult.FAILURE);  //If maxCount reached,test marked as failed
            }
        } else {
            result.setStatus(ITestResult.SUCCESS);      //If test passes, TestNG marks it as passed
        }
        return false;
    }
}