package Pages;

public class DisplayedResult extends BasePage {

    private static final String NO_RESULTS_FOUND = "//*[text()='No results found!']";


    public boolean isDisplayedResultVisible(){

        return elementExists(NO_RESULTS_FOUND);
    }
}
