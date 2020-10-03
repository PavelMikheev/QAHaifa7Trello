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
        waitUntilHomePageIsLoaded();
        openLoginPage();
        waitUntilLoginPageIsLoaded();
    }


    @Test
    public void loginNegativeLoginEmpty() {
        enterEmptyLoginAndPassword(PASSWORD);
        pressLoginButton();
        //receive error message
        Assert.assertEquals(getErrorMessage(), "Missing email");
     }

    @Test
    public void loginPasswordIncorrect() {
        enterIncorrectLogin("user77");
        enterIncorrectPassword("password1");
        pressLoginButton();
        Assert.assertEquals(getErrorMessage(), "There isn't an account for this username",
                "The error message is not 'There isn't an account for this username'");
    }


    @Test
    public void PasswordIncorrect() {

        WebElement loginField = driver.findElement(By.id("user"));
        loginField.click();
        loginField.clear();
        loginField.sendKeys(LOGIN);
        waitUntilElementIsClickable(By.id("password"), 15);
        enterIncorrectPassword("password1");
        waitUntilElementIsClickable(By.id("login"), 15);
        pressLoginButton();
        waitUntilElementIsVisible(By.id("password-error"), 15);
        Assert.assertTrue(driver.findElement(By.id("password-error")).getText().contains("Incorrect email address and"),
                "The error message is not contains the text 'Incorrect email address and'");

    }

    @Test
    public void LoginPositiveTest() {


        WebElement loginField = driver.findElement(By.id("user"));
        loginField.click();
        loginField.clear();
        loginField.sendKeys("pavelmikheev65@gmail.com");
        waitUntilElementIsClickable(By.id("password"), 15);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("Perfect10)");
        pressLoginButton();
        waitUntilElementIsPresent(By.xpath("//button[@data-test-id=\"header-boards-menu-button\"]"), 15);
        //System.out.println(driver.findElement(By.xpath("//button[@data-test-id=\"header-boards-menu-button\"]")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//button[@data-test-id=\"header-boards-menu-button\"]")).getText().equals("Boards"),
                "The text button is not BOARDS");
    }

    private void waitUntilLoginPageIsLoaded() {
        waitUntilElementIsClickable(By.id("password"), 15);
        waitUntilElementIsClickable(By.id("login"),15);
        waitUntilElementIsClickable(By.id("user"),15);
    }

    private void openLoginPage() {
        WebElement loginIcon = driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']"));
        loginIcon.click();
    }

    private void waitUntilHomePageIsLoaded() {
        waitUntilElementIsClickable(By.xpath("//a[@class='btn btn-sm btn-link text-white']"),15);
    }

    public String getErrorMessage(){
        waitUntilElementIsPresent(By.id("error"), 15);
        return driver.findElement(By.id("error")).getText();
    }

    private void pressLoginButton() {
        //press login button
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
    }

    private void enterEmptyLoginAndPassword(String password) {
        //enter empty login and password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("Perfect10)");
    }

    private void enterIncorrectPassword(String password) {
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    private void enterIncorrectLogin(String login) {
        WebElement loginField = driver.findElement(By.id("user"));
        loginField.click();
        loginField.clear();
        loginField.sendKeys(login);
    }
}

