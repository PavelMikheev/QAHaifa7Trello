package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPageHelper;
import pages.HomePageHelper;
import pages.LoginPageHelper;

public class LoginTests extends TestBase {
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    HomePageHelper homePage;


    @BeforeMethod
    public void initTests() {
        loginPage = PageFactory.initElements (driver, LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver, BoardsPageHelper.class);
        homePage = PageFactory.initElements(driver, HomePageHelper.class);
        homePage.waitUntilPageIsLoaded();
        homePage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();

    }


    @Test
    public void loginNegativeLoginEmpty() {
        loginPage.enterLoginAndPasswordPressLoginButton("", PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessage(), "Missing email");
    }

    @Test
    public void loginPasswordIncorrect() {
        loginPage.enterLoginAndPasswordPressLoginButton("user77","password1");
        waitUntilElementIsVisible(By.id("error"), 15);
        Assert.assertEquals(loginPage.getErrorMessage(), "There isn't an account for this username",
                "The error message is not 'There isn't an account for this username'");
    }


    @Test
    public void PasswordIncorrect() {

        loginPage.enterLoginAndPasswordPressLoginButton(LOGIN,"password1");
        waitUntilElementIsVisible(By.id("password-error"), 15);
        Assert.assertTrue(loginPage.getPasswordErrorMessage().contains("Incorrect email address and"),
                "The error message is not contains the text 'Incorrect email address and'");

    }

    @Test
    public void LoginPositiveTest() {

        loginPage.enterLoginAndPasswordPressLoginButton(LOGIN, PASSWORD);
        boardsPage.waitUntilPageIsLoaded();
        Assert.assertTrue(boardsPage.getBoardIconName().equals("Boards"), "The text button is not BOARDS");
    }

}

