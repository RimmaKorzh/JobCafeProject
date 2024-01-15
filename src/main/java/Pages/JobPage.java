package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class JobPage extends BasePage {


    private static final String SEARCH_BUTTON = "//*[text()='search']";
    private static final String RESET_BUTTON = "//*[text()='reset']";
    private static final String COMPANY = "//input[@placeholder='company']";
    private static final String LOCATION = "//input[@placeholder='location']";
    private static final String POSITION = "//input[@placeholder='position']";







public WebElement searchButton(){

    return findElementByXpath(SEARCH_BUTTON);
}

    public WebElement resetButton(){
        return findElementByXpath(RESET_BUTTON);
    }


 public WebElement companyTab(By xpath){
    return  findElementByXpath(COMPANY);
 }

    public WebElement locationTab(By xpath){

        return findElementByXpath(LOCATION);

    }


    public WebElement positionTab(){

        return findElementByXpath(POSITION);
    }

    public DisplayedResult message(){
    findElementByXpath(POSITION).click();
    findElementByXpath(SEARCH_BUTTON).click();
    return  new DisplayedResult();
    }

















}