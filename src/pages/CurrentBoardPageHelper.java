package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
       // WebElement addListButton = driver.findElement(By.xpath("//input[@class='primary mod-list-add-button js-save-edit']"));
        addList.click();
    }

    public void nameForNewListTest() {
        waitUntilElementIsClickable(listTitle, 15);
        //WebElement enterListTitle = driver.findElement((By.xpath("//input[@placeholder='Enter list title...']")));
        listTitle.click();
        listTitle.clear();
        listTitle.sendKeys("test");
    }

    public void addNewList() {
        waitUntilElementIsClickable(addNewList, 15);
        //WebElement addList = driver.findElement(By.xpath("//span[@class='placeholder']"));
        addNewList.click();
    }

    public int getQtyOfLists() {
        System.out.println("Quantity of lists before adding: " + qtyOfLists.getSize());
        return driver.findElements(By.xpath("//div[@class='list-header-target js-editing-target']")).size();

    }

    public void finishAddingNewList() {
        waitUntilElementIsClickable(By.cssSelector("a.icon-close.dark-hover"), 5);
        WebElement xButton = driver.findElement(By.cssSelector("a.icon-close.dark-hover"));
        xButton.click();
        waitUntilElementIsInvisible(By.cssSelector("a.icon-close.dark-hover"), 5);
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


}
