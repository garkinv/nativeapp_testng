package core.listeners;

import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static org.apache.logging.log4j.LogManager.getLogger;

/**
 * Created by Vladimir Garkin on 2/23/18
 */
public class RetryAnalyzer implements IRetryAnalyzer {

    private static final Logger LOG = getLogger();

    int count = 0;
    int maxTry = 3;

    /*
     * (non-Javadoc)
     *
     * @see org.testng.IRetryAnalyzer#retry(org.testng.ITestResult)
     *
     * This method decides how many times a test needs to be rerun. TestNg will
     * call this method every time a test fails. So we can put some code in here
     * to decide when to rerun the test.
     *
     * Note: This method will return true if a tests needs to be retried and
     * false it not.
     *
     */

    @Override
    public boolean retry(ITestResult result) {

        if (!result.isSuccess()) {                      //Check if test not succeed
            if (count < maxTry) {                            //Check if maxtry count is reached
                count++;                                     //Increase the maxTry count by 1
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