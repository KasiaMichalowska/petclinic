package pageobject.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OwnerPage {

    @FindBy(linkText = "ownerName")
    private WebElement ownerNameFieldElement;

    @FindBy(name = "findOwnerButton")
    private WebElement findOwnerButton;

    @FindBy(name = "AddOwnerButton")
    private WebElement AddOwnerButton;


/* //a[@href='/owners/1'] - owner */

    @FindBy(linkText = "Home")
    private WebElement homeLinkElement;

    public void clickOnHomeLink() { homeLinkElement.click(); }

    public void clickonfindOwnerButton() {findOwnerButton.click(); }

    public void ckickonAddOwnerButton() { AddOwnerButton.click(); }

    public void clickOnOwnerNameFieldElement() { ownerNameFieldElement.click(); }
}


