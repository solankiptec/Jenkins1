package Jenkins;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class Browser_Factory extends BasePage {

    Load_Property load_property = new Load_Property();
    String browser1 = load_property.getProperty("browser");

    public void selectBrowser(String browser){

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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

}
