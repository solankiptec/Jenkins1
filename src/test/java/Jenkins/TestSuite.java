package Jenkins;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuite extends BaseTest {

    @Test
    public void navigationToRegisterPage() {

        String expectedRegisterUrl = "http://demo.nopcommerce.com/";
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedRegisterUrl),"To verify url is correct or not");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }
    @Test
    public void navigationToElectronicPage(){
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/a")).click();
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[6]/div[3]/div[2]/div[2]/div/div[1]/h1")).getText(),"Electronics");
    }
    @Test
    public void navigationToJwelloryPage(){
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[6]/a")).click();
        String expectedRegisterUrl = "http://demo.nopcommerce.com/jewelry";
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedRegisterUrl),"To verify url is correct or not");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

    }
}
