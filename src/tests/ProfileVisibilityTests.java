package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.util.Collection;

public class ProfileVisibilityTests extends TestBase {
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    CurrentBoardPageHelper qaHaifa7currentBoard;
    HomePageHelper homePage;
    ProfileVisibilityHelper profileVisibilityMenu;

    @BeforeMethod
    public void initTests() {
        loginPage = PageFactory.initElements (driver, LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver, BoardsPageHelper.class);
        homePage = PageFactory.initElements(driver, HomePageHelper.class);
        qaHaifa7currentBoard = new CurrentBoardPageHelper(driver, "QA Haifa7");

        homePage.waitUntilPageIsLoaded();
        homePage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.enterLoginAndPasswordPressLoginButton(LOGIN, PASSWORD);
        boardsPage.waitUntilPageIsLoaded();
        boardsPage.openCurrentBoardPage("QA Haifa7");
        qaHaifa7currentBoard.waitUntilPageIsLoaded();
    }


    @Test
    public void isActivityPage(){
        //waitUntilElementIsClickable(By.className("_24AWINHReYjNBf"), 15);
       // WebElement openMemberMenuButton = driver.findElement(By.className("_24AWINHReYjNBf"));
       // openMemberMenuButton.click();
      //  waitUntilElementIsPresent(By.className("_2Un9i9htRmbUrY"), 15);
       profileVisibilityMenu.openMemberMenuButton();
        profileVisibilityMenu.clickActivityButton();
        Assert.assertEquals(profileVisibilityMenu.clickActivityButton(), "Activity");
    }



    @Test
    public void checkLastRecordActivity() {

        qaHaifa7currentBoard.addNewList();
        qaHaifa7currentBoard.nameForNewListTest();
        qaHaifa7currentBoard.clickAddListButton();
        qaHaifa7currentBoard.finishAddingNewList();
        profileVisibilityMenu.openMemberMenuButton();
        profileVisibilityMenu.clickActivityButton();
        waitUntilElementIsPresent(By.className("tabbed-pane-header"),15);
        Assert.assertEquals(profileVisibilityMenu.lastRecordActivity(), "P\n" +
                "Pavel added list test to QA Haifa7\n" +
                "just now - on board QA Haifa7");
    }

}


