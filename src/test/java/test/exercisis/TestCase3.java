package test.exercisis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.SortedMap;

public class TestCase3 {

    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeMethod
    public void start() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa1.vytrack.com/");
        driver.manage().window().fullscreen();
        wait = new WebDriverWait(driver, 10);

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        BrowserUtils.wait(2);
        WebElement elmnt1 = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        wait.until(ExpectedConditions.visibilityOf(elmnt1));
        wait.until(ExpectedConditions.elementToBeClickable(elmnt1));
        elmnt1.click();
        BrowserUtils.wait(3);
        WebElement activities = driver.findElement(By.linkText("Activities"));
        //BrowserUtills.wait(2);
        wait.until(ExpectedConditions.visibilityOf(activities));
        wait.until(ExpectedConditions.elementToBeClickable(activities));
        activities.click();
        BrowserUtils.wait(2);
        WebElement ClndrAct = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(ClndrAct));
        wait.until(ExpectedConditions.elementToBeClickable(ClndrAct));
        ClndrAct.click();
        BrowserUtils.wait(2);
    }


    @Test(description = "")
    public void Testcase3(){

        WebElement CreateCalenderEventButton = driver.findElement(By.cssSelector("[title='Create Calendar event']"));
       wait.until(ExpectedConditions.visibilityOf(CreateCalenderEventButton));
        CreateCalenderEventButton.click();

        BrowserUtils.wait(2);

        WebElement SaveAndCloseButton = driver.findElement(By.cssSelector("[class='btn-success btn dropdown-toggle']"));
        wait.until(ExpectedConditions.visibilityOf(SaveAndCloseButton));
        SaveAndCloseButton.click();

        // "//li[1]//button[contains(text(), 'Save')]"

        for(int i = 1; i<=3; i++){
            WebElement obtions = driver.findElement(By.xpath("//li[1]//button[contains(text(), 'Save')]"));
            Assert.assertTrue(obtions.isDisplayed(), "is not display check again");
        }

    }

    @Test
    public void test4(){

        WebElement CreateCalenderEventButton = driver.findElement(By.cssSelector("[title='Create Calendar event']"));
        wait.until(ExpectedConditions.visibilityOf(CreateCalenderEventButton));
        CreateCalenderEventButton.click();

        BrowserUtils.wait(2);

        WebElement CancelButton = driver.findElement(By.cssSelector("[title='Cancel']"));
        CancelButton.click();

        BrowserUtils.wait(2);

        //String expectedText = "All Calendar Events";
        WebElement ActualText = driver.findElement(By.xpath("//h1[contains(text(), 'All')]"));
        Assert.assertTrue(ActualText.isDisplayed(), "Subtitile is not displayed please check your code");

    }


    @Test
    public void test5(){

        WebElement CreateCalenderEventButton = driver.findElement(By.cssSelector("[title='Create Calendar event']"));
        wait.until(ExpectedConditions.visibilityOf(CreateCalenderEventButton));
        CreateCalenderEventButton.click();

        BrowserUtils.wait(2);
        WebElement Time1 = driver.findElement(By.cssSelector("[class='input-small timepicker-input start ui-timepicker-input']"));
        Time1.click();
        WebElement Starttime = driver.findElement(By.xpath("//li[contains(text(), '10:00 PM')]"));
        Starttime.click();
        String StartTimetext = Starttime.getText();
        System.out.println(StartTimetext);

        String ExpectedTime = "11:00 PM";
        BrowserUtils.wait(2);
        WebElement EndTime = driver.findElement(By.cssSelector("[class='input-small timepicker-input end ui-timepicker-input']"));
        EndTime.click();
        String text2 = EndTime.getText();


        BrowserUtils.wait(3);
        Assert.assertEquals(text2, ExpectedTime);


    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
