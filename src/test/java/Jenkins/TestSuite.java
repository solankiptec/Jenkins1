package Jenkins;


import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuite extends BaseTest {

    HomePage homePage = new HomePage();
    @Test
    public void navigationToRegisterPage() {

        homePage.userShouldAbleToVerifyUrl();
        String expectedRegisterUrl = "http://demo.nopcommerce.com/";
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedRegisterUrl),"To verify url is correct or not");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }
    @Test
    public void navigationToElectronicPage(){
        homePage.userShouldAbleToVerifyElectronicPageUrl();
        String expectedRegisterUrl = "http://demo.nopcommerce.com/electronics";
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedRegisterUrl),"To verify url is correct or not");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }
    @Test
    public void navigationToJwelloryPage(){
        homePage.userShouldAbleToVerifyJwelloryPage();
        String expectedRegisterUrl = "http://demo.nopcommerce.com/jewelry";
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedRegisterUrl),"To verify url is correct or not");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

    }
}
