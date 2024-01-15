import Pages.MainPage;
import Utils.UseCaseBase;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class MainPageTest extends UseCaseBase {


    private static MainPage mainPage;
    public static final Logger logger = LogManager.getLogger(MainPageTest.class);



    @BeforeAll
    public static void classSetup() {
        mainPage = new MainPage();


    }

    @BeforeEach
    public void beforeTest() {
        mainPage.navigateToMainPage();
    }
@Test
    public  void mainPageLoadTest(){
        logger.info("Main page load test");
        boolean success = mainPage.isLogoVisible();
        assertTrue(success);

}
@Test
    public void aboutUsButton() throws IOException {
        logger.info("About Us page load test");
    WebElement aboutUsButton = mainPage.aboutUsButton();
    aboutUsButton.click();
    File file = aboutUsButton.getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(file, new File("AboutUsPage.png"));

}
@Test
    public void openFindJobPage(){
        logger.info("Job page load test ");

        WebElement findJobPage = mainPage.findJobButton();
        assertNotNull(findJobPage);
        findJobPage.click();


}

}
