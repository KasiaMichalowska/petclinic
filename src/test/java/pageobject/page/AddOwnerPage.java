package pageobject.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddOwnerPage extends OwnerPage {

    @FindBy(how = How.LINK_TEXT, linkText = "Add Owner")
    private WebElement addOwnerButton1;

    @FindBy(how = How.ID, id = "firstName")
    private WebElement firstNameField;

    @FindBy(how = How.ID, id = "lastName")
    private WebElement lastNameField;

    @FindBy(how = How.ID, id = "address")
    private WebElement addressField;

    @FindBy(how = How.ID, id = "city")
    private WebElement cityField;

    @FindBy(how = How.ID, id = "telephone")
    private WebElement phoneField;

    @FindBy(how = How.XPATH, xpath = ".//*[@id='add-owner-form']/div[2]/div/button")
    private WebElement buttonConfirmAddOwner;

    @FindBy(xpath = "//html/body/div[1]/div/table[1]/tbody/tr[1]/td/b")
    private WebElement foundOwnerName;

    @FindBy(xpath = ".//*[@id='add-owner-form']/div[1]/div[3]/div/span[2]")
    private WebElement missingAddressLabel;

    public void addOwner(String FirstName, String LastName, String Address, String City, String Telephone) {
        navigateToSearchOwnerPage();
        goToAddOwnerPage();
        firstNameField.sendKeys(FirstName);
        lastNameField.sendKeys(LastName);
        addressField.sendKeys(Address);
        cityField.sendKeys(City);
        phoneField.sendKeys(Telephone);
        buttonConfirmAddOwner.click();
    }

    public String getAddedOwnerText() {
        return foundOwnerName.getText();
    }

    public boolean isAddOwnerError() {
        //to be implemented, there should be check if we're trying to add user with the same name
        return false;
    }

    public boolean isMissingAddress() {
        return missingAddressLabel.isDisplayed();
    }

    private void goToAddOwnerPage() {
        addOwnerButton1.click();
    }

}


