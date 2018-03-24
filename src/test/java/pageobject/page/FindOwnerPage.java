package pageobject.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FindOwnerPage extends OwnerPage {

    @FindBy(how = How.XPATH, xpath = ".//*[@id='search-owner-form']/div[2]/div/button")
    private WebElement findOwnerButton;

    @FindBy(how = How.XPATH, xpath = "//table[@id='vets']/tbody/tr[5]/td")
    private WebElement ownerText;

    @FindBy(xpath = "//html/body/div[1]/div/table[1]/tbody/tr[1]/td/b")
    private WebElement foundOwnerName;

    @FindBy(xpath = ".//*[@id='lastName']")
    private WebElement ownerSearchEditBox;

    @FindBy(xpath = ".//*[@id='lastNameGroup']/div/span/div/p")
    private WebElement notFoundLabel;

    public void searchOwner(String LastName) {
        navigateToSearchOwnerPage();
        ownerSearchEditBox.sendKeys(LastName);
        findOwnerButton.click();
    }

    public String getOwnerText() {
        return ownerText.getText();
    }

    public String getFoundOwnerNameText() {
        return foundOwnerName.getText();
    }

    public boolean isNoneOwnerFound() {
        return notFoundLabel.getText().contains("has not been found");
    }

}


