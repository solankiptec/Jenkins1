package Jenkins;


import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static Jenkins.Utils.captureScreenshot;

public class BaseTest extends BasePage {

    Browser_Factory browser_factory =new Browser_Factory();
    Load_Property load_property = new Load_Property();


    @BeforeMethod

    public void set_up_Browser() {
        browser_factory.selectBrowser(load_property.getProperty("browser"));
        driver.get(load_property.getProperty("baseUrl"));
        driver.manage().deleteAllCookies();

    }
    @AfterMethod

    public void quitDriver(ITestResult result) {
        if(ITestResult.FAILURE==result.getStatus()) {
            captureScreenshot(browser_factory.browser1 +"__"+ result.getName()+"__");
        }
        driver.quit();
    }


}
