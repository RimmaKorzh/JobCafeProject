package Pages;

import Utils.Consts;
import org.openqa.selenium.WebElement;

import static Pages.BasePage.webDriver;

public class MainPage extends BasePage {

    private static final String LOGO_IMG ="//img[@src='/img/site_bg.jpg']";
    private static final String ABOUT_US_BUTTON ="//a[@name='About Us']";
    private static final String ABOUT_US_LOGO ="//*[text()=' CAFE']";
    private static final String FIND_jOB_BUTTON ="//a[@name='Find Job']";




    public void navigateToMainPage(){
        webDriver.get(Consts.MAIN_URL);

    }
    public boolean isLogoVisible(){
        boolean isVisible = elementExists(LOGO_IMG);
        return isVisible;
    }
public WebElement aboutUsButton(){

return findElementByXpath(ABOUT_US_BUTTON);

}
public WebElement findJobButton(){

        return findElementByXpath(FIND_jOB_BUTTON);


}


}
