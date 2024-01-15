import Pages.DisplayedResult;
import Pages.JobPage;
import Pages.MainPage;
import Utils.UseCaseBase;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.support.locators.RelativeLocator.with;




public class JobPageTest extends UseCaseBase {


    protected static MainPage mainPage;
    protected static JobPage jobPage;
    protected static DisplayedResult displayedResult;
    public static final Logger logger = LogManager.getLogger(MainPageTest.class);

    @BeforeAll
    public static void classSetup() {
        mainPage = new MainPage();
        jobPage = new JobPage();



    }

    @BeforeEach
    public void beforeTest() {
        mainPage.navigateToMainPage();
        mainPage.findJobButton().click();

    }
    @AfterAll
    public static void afterTest(){
        WebElement resetButton = jobPage.resetButton();
        assertNotNull(resetButton);
        resetButton.click();

    }



@Test
    public void locationTab() throws InterruptedException {

    WebElement locationElement = jobPage.locationTab(By.xpath("//*[contains(text(),'Location']"));
    assertNotNull(locationElement);
    locationElement.sendKeys("Toronto");

    WebElement searchButton = jobPage.searchButton();
    assertNotNull(searchButton);
    searchButton.click();
    Thread.sleep(2000);
    locationElement.clear();

    WebElement locationElement2 = jobPage.locationTab(By.xpath("//*[contains(text(),'Location']"));
    assertNotNull(locationElement2);
    locationElement2.sendKeys("Tel Aviv");
    searchButton.click();
    Thread.sleep(2000);
    locationElement.clear();



    WebElement locationElement3 = jobPage.locationTab(By.xpath("//*[contains(text(),'Location']"));
    assertNotNull(locationElement3);
    locationElement3.sendKeys("Chicago");
    searchButton.click();
    Thread.sleep(2000);
    locationElement.clear();



}
@Test
    public void companyTab() throws InterruptedException {

    WebElement companyTab = jobPage.companyTab(By.xpath("//*[contains(text(),'company']"));
    WebElement companyInput = jobPage.companyTab(with(By.xpath("//input")).near(companyTab));
    companyInput.sendKeys("Google");
    jobPage.searchButton().click();
    Thread.sleep(2000);


}
        @Test
                public void positionTab() throws InterruptedException {
            WebElement position = jobPage.positionTab();
            assertNotNull(position);
            position.sendKeys("Developer");
            jobPage.searchButton().click();
            Thread.sleep(5000);
            position.clear();

            WebElement position2 = jobPage.positionTab();
            assertNotNull(position2);
            position.sendKeys("QA");
            jobPage.searchButton().click();
            Thread.sleep(5000);
            position.clear();



    }


    @Test
    public void combinedTest() throws InterruptedException, IOException {


        WebElement position = jobPage.positionTab();
        position.sendKeys("Manager");

        WebElement company = jobPage.companyTab(By.xpath("//input[@placeholder='company']"));
        company.sendKeys("Google");

        WebElement location = jobPage.locationTab(By.xpath("//input[@placeholder='location']"));
        location.sendKeys("USA");

        jobPage.searchButton().click();
        Thread.sleep(5000);
        jobPage.resetButton().click();

        File file = position.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("position"));




    }
@Test
    public void abracadabraTest() throws InterruptedException {

        WebElement position = jobPage.positionTab();
        position.sendKeys("ABRAKADABRA");

        WebElement searchButton = jobPage.searchButton();
        searchButton.click();
        Thread.sleep(2000);

DisplayedResult message = jobPage.message();
boolean isLoaded = message.isDisplayedResultVisible();
assertTrue(isLoaded);





}





}

