package Jenkins;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static Jenkins.Utils.captureScreenshot;

public class BaseTest extends BasePage {


    @BeforeMethod

            public void openBrowser(){
       // String browser1 = "ie";
String browser1=System.getProperty("browser");
//    String browser1 = "browser1";

    if (browser1.equalsIgnoreCase("Firefox")) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Welcome\\IdeaProjects\\NewJenkins4\\src\\Resources\\java\\Driver_Resources\\geckodriver.exe");
        driver = new FirefoxDriver();
    }else if (browser1.equalsIgnoreCase("Chrome")){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Welcome\\IdeaProjects\\NewJenkins4\\src\\Resources\\java\\Driver_Resources\\chromedriver.exe");
        driver=new ChromeDriver();
    }else if (browser1.equalsIgnoreCase("IE")){
        System.setProperty("webdriver.ie.driver","C:\\Users\\Welcome\\IdeaProjects\\NewJenkins4\\src\\Resources\\java\\Driver_Resources\\IEDriverServer.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();

        // Settings to Accept the SSL Certificate in the Capability object
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        driver=new InternetExplorerDriver(capabilities);
    }else {
        System.out.println("Browser name is wrong:-  " +browser1);
    }

    driver.get("http://demo.nopcommerce.com");
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);



}
    @AfterMethod

    public void quitDriver(ITestResult result) {
        if(ITestResult.FAILURE==result.getStatus()) {
            captureScreenshot("__"+ result.getName()+"__");
        }
        driver.quit();
    }


}
