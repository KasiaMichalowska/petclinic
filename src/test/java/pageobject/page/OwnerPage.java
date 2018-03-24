package pageobject.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OwnerPage {

    @FindBy(how = How.XPATH, xpath = "//div[@id='main-navbar']/ul/li[3]/a/span[2]")
    private WebElement findOwnerTab;

    /** To make sure we're on find owner starting page, navigate there before each search */
    protected void navigateToSearchOwnerPage() { findOwnerTab.click(); }
}
