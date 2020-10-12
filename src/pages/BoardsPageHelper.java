package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardsPageHelper extends PageBase {
    @FindBy(xpath = "//button[@data-test-id='header-boards-menu-button']")
    WebElement boardsButton;

    public BoardsPageHelper (WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(boardsButton, 45);
    }

    public void openCurrentBoardPage(String boardName) {
        WebElement board = driver.findElement(By.xpath("//li[@class='boards-page-board-section-list-item'][.//div[@title ='" + boardName + "']]"));
        board.click();
    }

    public String getBoardIconName(){

        return boardsButton.getText();
    }
}
