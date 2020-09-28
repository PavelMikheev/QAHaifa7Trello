package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CurrentBoardTests extends TestBase{


    @BeforeMethod
    public void initTests() {

        //Open login window
        WebElement loginIcon = driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']"));
        loginIcon.click();
        waitUntilElementIsClickable(By.id("user"), 15);
        WebElement loginField = driver.findElement(By.id("user"));
        loginField.click();
        loginField.clear();
        loginField.sendKeys(LOGIN);
        waitUntilElementIsClickable(By.id("password"), 15);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(PASSWORD);
        waitUntilElementIsClickable(By.id("login"), 15);
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        waitUntilElementIsClickable(By.xpath("//button[@data-test-id ='header-boards-menu-button']"),45);
        WebElement boardButton = driver.findElement(By.xpath("//li[@class='boards-page-board-section-list-item'][.//div[@title ='QA Haifa7']]"));
        boardButton.click();
        waitUntilElementIsClickable(By.id("workspaces-preamble-board-header-button"), 15);
        waitUntilElementIsPresent(By.tagName("h1"), 10);

    }


    @Test
    public void  isCorrectCurrentBoard(){
      //  System.out.println("Header of the current board: "+ driver.findElement(By.tagName("h1")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "QA Haifa7", "The header of the script is not 'QA Haifa7'");
    }


    @Test
    public void NewListPositiveTest() {

        System.out.println("Quantity of lists before adding: " + driver.findElements(By.xpath("//div[@class='list-header-target js-editing-target']")).size());
        int qtyListsBeforeAdding =  driver.findElements(By.xpath("//div[@class='list-header-target js-editing-target']")).size();
        waitUntilElementIsClickable((By.xpath("//span[@class='placeholder']")), 15);
        WebElement addList = driver.findElement(By.xpath("//span[@class='placeholder']"));
        addList.click();
        waitUntilElementIsClickable((By.xpath("//input[@placeholder='Enter list title...']")), 15);
        WebElement enterListTitle = driver.findElement((By.xpath("//input[@placeholder='Enter list title...']")));
        enterListTitle.click();
        enterListTitle.clear();
        enterListTitle.sendKeys("test");
        waitUntilElementIsClickable((By.xpath("//input[@class='primary mod-list-add-button js-save-edit']")), 15);
        WebElement addListButton = driver.findElement(By.xpath("//input[@class='primary mod-list-add-button js-save-edit']"));
        addListButton.click();
        waitUntilElementIsPresent((By.xpath("//div[@class='list-header-target js-editing-target']")), 15);
        System.out.println("Quantity of lists after adding: " + driver.findElements(By.xpath("//div[@class='list-header-target js-editing-target']")).size());
        int qtyListAfterAdding = driver.findElements(By.xpath("//div[@class='list-header-target js-editing-target']")).size();
        Assert.assertEquals(qtyListAfterAdding, qtyListsBeforeAdding+1);
    }

    @Test
    public void DeletingListPositiveTest() {
        //printing qty of lists
        int listQty = driver.findElements(By.xpath("//div[@class='list js-list-content']")).size();
        System.out.println("Quantity of lists before deleting: " + listQty);


        if (listQty == 0){
            //adding one more list
            waitUntilElementIsClickable((By.xpath("//span[@class='placeholder']")), 15);
            WebElement addList = driver.findElement(By.xpath("//span[@class='placeholder']"));
            addList.click();
            waitUntilElementIsClickable((By.xpath("//input[@placeholder='Enter list title...']")), 15);
            WebElement enterListTitle = driver.findElement((By.xpath("//input[@placeholder='Enter list title...']")));
            enterListTitle.click();
            enterListTitle.clear();
            enterListTitle.sendKeys("test");
            waitUntilElementIsClickable((By.xpath("//input[@class='primary mod-list-add-button js-save-edit']")), 15);
            WebElement addListButton = driver.findElement(By.xpath("//input[@class='primary mod-list-add-button js-save-edit']"));
            addListButton.click();
            //Cancel the new adding list control
            waitUntilElementIsClickable(By.cssSelector("a.icon-close.dark-hover"), 5);
            WebElement xButton = driver.findElement(By.cssSelector("a.icon-close.dark-hover"));
            xButton.click();
            waitUntilElementIsInvisible(By.cssSelector("a.icon-close.dark-hover"), 5);
        }

        waitUntilElementsAreVisible(By.xpath("//div[@class='list js-list-content']"), 10);
        waitUntilElementIsClickable((By.cssSelector("a.list-header-extras-menu")), 15);
        WebElement listAction = driver.findElement(By.cssSelector("a.list-header-extras-menu"));
        listAction.click();
        waitUntilElementIsClickable((By.xpath("//a[@class='js-close-list']")), 15);
        WebElement archiveList = driver.findElement(By.xpath("//a[@class='js-close-list']"));
        archiveList.click();
       // waitUntilElementIsPresent((By.xpath("//div[@class='list-header-target js-editing-target']")), 15);
       // System.out.println("Quantity of lists after deleting: " + driver.findElements(By.xpath("//div[@class='list-header-target js-editing-target']")).size());
        int listQtyAfterDeleting = driver.findElements(By.xpath("//div[@class='list-header-target js-editing-target']")).size();
       if (listQty != 0) {
           Assert.assertEquals(listQtyAfterDeleting, listQty-1);
       }
       else {
           System.out.println("Quantity of lists after deleting: " + driver.findElements(By.xpath("//div[@class='list-header-target js-editing-target']")).size());
       }
    }

    @Test
    public void UserNameOfAccountInProfileAndVisibilityIsSame(){
        String userNameIcon = driver.findElement(By.xpath("//div[@class='_1FekJJAz6Hu32v']")).getAttribute("title");
        System.out.println(userNameIcon);
        //click on button "P"
        WebElement openMemberMenu = driver.findElement(By.xpath("//button[@aria-label='Open Member Menu']"));
        openMemberMenu.click();
        //select Profile and Visibility
        waitUntilElementIsPresent(By.xpath("//span[contains(text(),'Profile and Visibility')]"),10);
        WebElement profileAndVisibility = driver.findElement(By.xpath("//span[contains(text(),'Profile and Visibility')]"));
        profileAndVisibility.click();
        waitUntilElementIsClickable(By.xpath("//input[@name='username']"),15);
        String userNameInProfile = driver.findElement(By.xpath("//input[@name='username']")).getAttribute("value");
        System.out.println(userNameInProfile);
       //check if userNameIcon contains userNameInProfile
        Assert.assertTrue(userNameIcon.contains(userNameInProfile));

    }
}

