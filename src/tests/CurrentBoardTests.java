package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CurrentBoardTests extends TestBase{


    @BeforeMethod
    public void initTests() throws InterruptedException {

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
        waitUntilElementIsClickable(By.xpath("//li[@class='boards-page-board-section-list-item'][.//div[@title ='QA Haifa7']]"), 15);
        WebElement boardButton = driver.findElement(By.xpath("//li[@class='boards-page-board-section-list-item'][.//div[@title ='QA Haifa7']]"));
        boardButton.click();
        Thread.sleep(30000);
    }

    @Test
    public void NewListPositiveTest() throws InterruptedException {

        System.out.println("Quantity of lists before adding: " + driver.findElements(By.xpath("//div[@class='list-header-target js-editing-target']")).size());
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


    }

    @Test
    public void DeletingListPositiveTest() throws InterruptedException {
        //printing qty of lists
        int listQty = driver.findElements(By.xpath("//div[@class='list-header-target js-editing-target']")).size();
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
        }
        waitUntilElementIsClickable((By.xpath("//div[@class='board-main-content']//div[1]//div[1]//div[1]//div[2]//a[1]")), 15);
        WebElement listAction = driver.findElement(By.xpath("//div[@class='board-main-content']//div[1]//div[1]//div[1]//div[2]//a[1]"));
        listAction.click();
        waitUntilElementIsClickable((By.xpath("//a[@class='js-close-list']")), 15);
        WebElement archiveList = driver.findElement(By.xpath("//a[@class='js-close-list']"));
        archiveList.click();
        waitUntilElementIsPresent((By.xpath("//div[@class='list-header-target js-editing-target']")), 15);
        System.out.println("Quantity of lists after deleting: " + driver.findElements(By.xpath("//div[@class='list-header-target js-editing-target']")).size());

    }


}