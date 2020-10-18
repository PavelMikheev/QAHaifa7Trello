package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CurrentBoardPageHelper extends PageBase{
    @FindBy(id = "workspaces-preamble-board-header-button")
    WebElement boardsButton;
    @FindBy(tagName = "h1")
    WebElement boardsHeader;
    @FindBy(xpath = "//input[@class='primary mod-list-add-button js-save-edit']")
    WebElement addList;
    @FindBy(xpath = "//input[@placeholder='Enter list title...']")
    WebElement listTitle;
    @FindBy(xpath = "//span[@class='placeholder']")
    WebElement addNewList;
    @FindBy(xpath ="//div[@class='list-header-target js-editing-target']")
    WebElement qtyOfLists;
    @FindBy (xpath = "//li//a[@class='js-add-card']")
    WebElement addCardButton;
    @FindBy (css =  "textarea.js-card-title")
    WebElement textInCard;
    @FindBy (xpath = "//a[@class='icon-lg icon-close dark-hover js-cancel']")
    WebElement xButton;
    @FindBy (css = "input.js-add-card")
    WebElement addCardButton2;
    @FindBy(xpath = "//a[@class ='open-card-composer js-open-card-composer']")
    List<WebElement> addCardButtonList;
    @FindBy(xpath = "//div[@class='_1FekJJAz6Hu32v']")
    WebElement userNameIcon;
    @FindBy(css = "a.icon-close.dark-hover")
            WebElement xButtonAddList;

    String boardName;

    public CurrentBoardPageHelper(WebDriver driver, String boardName){
        super(driver);
        this.boardName = boardName;
        PageFactory.initElements(driver, this);
    }
    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(boardsButton, 15);
        waitUntilElementIsVisible(boardsHeader, 10);

    }
    public String getCurrentBoardHeader(){

        return boardsHeader.getText();
    }
    public boolean isCorrectCurrentBoard(){
        return boardsHeader.getText().equals(this.boardName);
    }

    public void clickAddListButton() {
        waitUntilElementIsClickable(addList, 15);
        addList.click();
    }

    public void nameForNewListTest() {
        waitUntilElementIsClickable(listTitle, 15);
        listTitle.click();
        listTitle.clear();
        listTitle.sendKeys("test");
    }

    public void addNewList() {
        waitUntilElementIsClickable(addNewList, 15);
        addNewList.click();
    }

    public int getQtyOfLists() {
        System.out.println("Quantity of lists before adding: " + qtyOfLists.getSize());
        return driver.findElements(By.xpath("//div[@class='list-header-target js-editing-target']")).size();

    }

    public void finishAddingNewList() {
        waitUntilElementIsClickable(xButtonAddList, 5);
        xButtonAddList.click();
        waitUntilElementIsClickable(xButtonAddList, 5);
    }

    public void clickArchiveListButton() {
        waitUntilElementIsClickable((By.xpath("//a[@class='js-close-list']")), 15);
        WebElement archiveList = driver.findElement(By.xpath("//a[@class='js-close-list']"));
        archiveList.click();
    }

    public void clickListActionButton() {
        waitUntilElementIsClickable((By.cssSelector("a.list-header-extras-menu")), 15);
        WebElement listAction = driver.findElement(By.cssSelector("a.list-header-extras-menu"));
        listAction.click();
    }
    public String userNameInProfile() {
        waitUntilElementIsClickable(By.xpath("//input[@name='username']"),15);
        String userNameInProfile = driver.findElement(By.xpath("//input[@name='username']")).getAttribute("value");
        return userNameInProfile;
    }

    public void clickProfileAndVisibilityButton() {
        waitUntilElementIsPresent(By.xpath("//span[contains(text(),'Profile and Visibility')]"),10);
        WebElement profileAndVisibility = driver.findElement(By.xpath("//span[contains(text(),'Profile and Visibility')]"));
        profileAndVisibility.click();
    }

    public void openMemberMenu() {
        WebElement openMemberMenu = driver.findElement(By.xpath("//button[@aria-label='Open Member Menu']"));
        openMemberMenu.click();
    }

    public String getNameFromUserNameIcon() {
        System.out.println(userNameIcon);
        return userNameIcon.getAttribute("title");
    }

    public void addAddCardButton() {
        waitUntilElementIsClickable(addCardButton, 15);
        addCardButtonList.get(0).click();
        }

    public void enterNameInCard(String card)  {
     waitUntilElementIsVisible(textInCard, 15);
        textInCard.click();
        textInCard.sendKeys(card);
        addCardButton2.click();
        xButton.click();
}
    public int getListQtyBeforeDeleting() {
        return driver.findElements(By.xpath("//div[@class='list js-list-content']")).size();
    }

    public void addNewListInBoard() {
        addNewList();
        nameForNewListTest();
        clickAddListButton();
    }



}
