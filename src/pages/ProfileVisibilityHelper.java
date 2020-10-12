package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;

public class ProfileVisibilityHelper extends PageBase {
    @FindBy (xpath = "//div[@class='phenom mod-attachment-type'][1]")
    WebElement lastRecordInActivity;
    @FindBy (className = "_24AWINHReYjNBf")
            WebElement menuButton;
    @FindBy (xpath = "//span[text()='Activity']//..//span[@class='_1uK2vQ_aMRS2NU']")
            WebElement activityButton;

String tabName;

    public ProfileVisibilityHelper(WebDriver driver, String tabName) {

        super(driver);
        this.tabName = tabName;
        PageFactory.initElements(driver, this);
    }

    public String clickActivityButton() {
        waitUntilElementIsClickable( activityButton, 10);
        //WebElement ActivityButton = driver.findElement(By.xpath("//span[text()='Activity']//..//span[@class='_1uK2vQ_aMRS2NU']"));
        activityButton.click();
        return activityButton.getText();
                //driver.findElement(By.className("tabbed-pane-nav-item-button.js-member-activity.active")).getText();
    }

    public void openMemberMenuButton() {
        waitUntilElementIsClickable(menuButton, 15);
      //  WebElement openMemberMenuButton = driver.findElement(By.className("_24AWINHReYjNBf"));
        menuButton.click();
       // waitUntilElementIsPresent(By.className("_2Un9i9htRmbUrY"), 15);
    }

    public String lastRecordActivity() {
        return lastRecordInActivity.getText();
    }
}
