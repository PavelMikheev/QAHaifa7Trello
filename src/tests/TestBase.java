package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public static final String LOGIN = "pavelmikheev65@gmail.com";
    public static final String PASSWORD = "Perfect10)";
    WebDriver driver;

    public void waitUntilElementIsClickable(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsPresent(By locator, int time){
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsInvisible(By locator, int time){
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementsAreVisible(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void StartAppl() throws InterruptedException {
                //driver initiaziation. open Trello application.
                //ChromeOptions options = new ChromeOptions();
                //  options.addArguments("--lang=" + "en");
                //  WebDriver driver = new ChromeDriver(options);
                driver = new ChromeDriver();
        driver.get("https://trello.com/");
        Thread.sleep(10000);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();

    }

}
