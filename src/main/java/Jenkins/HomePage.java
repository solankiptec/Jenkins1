package Jenkins;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public void userShouldAbleToVerifyUrl(){
    }

    public void userShouldAbleToVerifyElectronicPageUrl(){
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/a")).click();
    }
    public void userShouldAbleToVerifyJwelloryPage(){
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[6]/a")).click();
    }
}
