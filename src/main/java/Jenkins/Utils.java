package Jenkins;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


public class Utils extends BasePage {

    public static void clickElement(By by){
        driver.findElement(by).click();
    }
    public static void enterText(By by, String text){
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    public static String get_text(By by){
        return
                driver.findElement(by).getText();
    }
    public static void selectByVisibleText(By by,String text){
        new Select(driver.findElement(by)).selectByVisibleText(text);
    }
    public static void selectByIndex(By by,int number){
        new Select(driver.findElement(by)).selectByIndex(number);

    }
    public static void selectByValue(By by,String value){
        Select select=new Select(driver.findElement(by));
        select.selectByValue(value);
    }
//
//    public static void captureScreenshot( String screenshotName) {
//        try {
//            TakesScreenshot takesScreenshot = (TakesScreenshot) driver; //down casting
//            File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
//            SimpleDateFormat format = new SimpleDateFormat("dMMMyHms");
//            FileUtils.copyFile(source,new File("C:\\SwordProject1\\.idea\\Screenshot" + screenshotName + format.format(new Date()) +".png"));
//            System.out.println("Screenshot taken");
//        } catch (Exception e) {
//            System.out.println("Exception while taking screenshot" + e.getMessage());
//        }
//    }

    public static void captureScreenshot( String screenshotName) {
        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver; //down casting
            File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
            SimpleDateFormat format = new SimpleDateFormat("dMMMyHms");
            FileUtils.copyFile(source,new File("C:\\Users\\Welcome\\IdeaProjects\\NewJenkins4\\.idea\\Screenshot" + screenshotName + format.format(new Date()) +".png"));
            System.out.println("Screenshot taken");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot" + e.getMessage());
        }
    }


    public  String randomDate()
    {
        DateFormat format=new SimpleDateFormat("ddMMMyyHHmmss");
        return  format.format(new Date());
    }

//    public static void captureScreenShot(String screenshotName)
//    {
//        try {
//            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
//            File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
//            try {
//                copyFile(source, new File("C:\\Users\\Welcome\\IdeaProjects\\NewJenkins4\\.idea\\Screenshot" + screenshotName +  ".png"));
//                System.out.println("Screenshot has been taken");
//            } catch (IOException e) {
//                System.out.println("Exception while taking screenshot"+e.getMessage());
//            }
//        }finally {
//
//        }
//    }

    public void Select_The_Checkbox(WebElement element) {
        try {
            if (element.isSelected()) {
                System.out.println("Checkbox: " + element + "is already selected");
            } else {
                // Select the checkbox
                element.click();
            }
        } catch (Exception e) {
            System.out.println("Unable to select the checkbox: " + element);
        }

    }

    public static String randomNumber() {
        DateFormat format = new SimpleDateFormat("ddmmyy");
        return format.format(new Date());
    }

    public static void clearAndEnterText(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    public static boolean isVisible(WebDriver driver, String eachField) {
        return (!driver.findElement(By.id(eachField)).isDisplayed());

    }

    public static WebElement switchToNewWindow(WebDriver driver, String iframeId) {
        driver.switchTo().frame(iframeId);
        WebElement window = driver.switchTo().activeElement();
        return window;
    }

    public static void checkRadio(WebDriver driver, By by) {
        WebElement inputElement = driver.findElement(by);
        inputElement.click();
    }

    public static void goToTab(WebDriver driver, By by) {
        waitUntilClickable(driver, by);
        driver.findElement(by).click();
    }

    public static WebElement waitUntilClickable(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, 45);
        //noinspection Since15
        WebElement element = wait.until((com.google.common.base.Function<? super WebDriver, WebElement>) elementToBeClickable(by));
        return element;
    }

    public static void populateTextBox(WebDriver driver, By by, String value) {
        WebElement inputElement = driver.findElement(by);
        if ("".equals(value)) {
            inputElement.clear();
        } else {
            inputElement.sendKeys(value);
        }
    }

    public static boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            return true;
        } // try
        catch (Exception e) {
            return false;
        } // catch
    }

    public static void untilElementLoadImplicitWait(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void printPageSourceLength() {
        String pageSource = driver.getPageSource();// Storing Page Source in String variable
        int pageSourceLength = pageSource.length();// Storing Page Source length in Int variable
        System.out.println("Total length of the Pgae Source is : " + pageSourceLength);
    }

    public static void homePage(String baseURL) {
        driver.navigate().to(baseURL);
    }

    public static void backPage() {
        driver.navigate().back();
    }

    public static void nextPage() {
        driver.navigate().forward();
    }

    public static void refreshBrowser() {
        driver.navigate().refresh();
    }

    public static boolean isAlreadySelected(By by) {
        WebElement element = driver.findElement(by);
        boolean status = element.isSelected();
        return status;
    }

    public static void printAllOptionsDropDownList(By by) {
        Select oSelect = new Select(driver.findElement(by));
        List<WebElement> elementCount = oSelect.getOptions();
        int iSize = elementCount.size();
        for (int i = 0; i < iSize; i++) {
            String sValue = elementCount.get(i).getText();
            System.out.println(sValue);
        }
    }

    public static boolean compareActualTextWithExpectedText(By by,String expectedText) {
        String actualText = driver.findElement(by).getText();
        boolean status = actualText.equals(expectedText);
        return status;
    }

    public void thread() throws InterruptedException
    {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
