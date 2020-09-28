package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{


    @BeforeMethod
    public void initTests() {

        //Open login window
        WebElement loginIcon = driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']"));
        loginIcon.click();
       }



    @Test
    public void loginNegativeLoginEmpty() {
        //enter empty login and password
        waitUntilElementIsClickable(By.id("password"), 15);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("Perfect10)");
        //press login button
        waitUntilElementIsClickable(By.id("login"), 10);
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        waitUntilElementIsPresent(By.id("error"), 15);
        //receive error message
       // System.out.println("Error:  " + driver.findElement(By.id("error")).getText());
        Assert.assertEquals(driver.findElement(By.id("error")).getText(), "Отсутствует адрес электронной почты");


    }

    @Test
    public void loginPasswordIncorrect() {

        WebElement loginField = driver.findElement(By.id("user"));
        loginField.click();
        loginField.clear();
        loginField.sendKeys("user77");

        waitUntilElementIsClickable(By.id("password"), 15);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("password1");
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();

        waitUntilElementIsPresent(By.id("error"), 15);
        System.out.println("Error: " + driver.findElement(By.xpath("//div[@id='error']")).getText());

    }

    @Test
    public void PasswordIncorrect() {

        WebElement loginField = driver.findElement(By.id("user"));
        loginField.click();
        loginField.clear();
        loginField.sendKeys("pavelmikheev65@gmail.com");
        waitUntilElementIsClickable(By.id("password"), 15);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("password1");
        waitUntilElementIsClickable(By.id("login"), 15);
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        waitUntilElementIsPresent(By.xpath("//p[contains(text(),'.')]"), 15);
        System.out.println("Error: " + driver.findElement(By.xpath("//p[contains(text(),'.')]")).getText());

    }

    @Test
    public void LoginPositiveTest() {

        waitUntilElementIsClickable(By.id("user"),15);
        WebElement loginField = driver.findElement(By.id("user"));
        loginField.click();
        loginField.clear();
        loginField.sendKeys("pavelmikheev65@gmail.com");
        waitUntilElementIsClickable(By.id("password"), 15);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("Perfect10)");
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        waitUntilElementIsPresent(By.xpath("//button[@data-test-id=\"header-boards-menu-button\"]"), 15);
        //System.out.println(driver.findElement(By.xpath("//button[@data-test-id=\"header-boards-menu-button\"]")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//button[@data-test-id=\"header-boards-menu-button\"]")).getText().equals("Boards"),
                "The text button is not BOARDS");
    }
}

