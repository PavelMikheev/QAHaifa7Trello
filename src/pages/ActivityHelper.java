package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;

public class ActivityHelper extends PageBase {
    @FindBy (xpath = "//div[@class='phenom mod-attachment-type'][1]")
    WebElement lastRecordInActivity;
    @FindBy (className = "_24AWINHReYjNBf")
    WebElement menuButton;
    @FindBy (xpath = "//span[text()='Activity']//..//span[@class='_1uK2vQ_aMRS2NU']")
    WebElement activityButton;
    @FindBy (xpath = "//li[@class='tabbed-pane-nav-item'][2]")
            WebElement boardActivity;

String tabName;

    public ActivityHelper(WebDriver driver, String tabName) {

        super(driver);
        this.tabName = tabName;
        PageFactory.initElements(driver, this);
    }

    public void clickActivityButton()  {

      waitUntilElementIsClickable(activityButton, 15);
        activityButton.click();

    }

    public String activityBoardName(){
        waitUntilElementIsVisible(boardActivity, 15);
        return boardActivity.getText();
    }

    public void openMemberMenuButton() {
        waitUntilElementIsClickable(menuButton, 15);
        menuButton.click();
        waitUntilElementIsVisible(driver.findElement(By.className("_2Un9i9htRmbUrY")),15);
    }

    public String lastRecordActivity() {
        return lastRecordInActivity.getText();
    }
}
