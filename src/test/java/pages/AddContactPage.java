package pages;

import framework.core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddContactPage extends BasePage {


    @FindBy(xpath = "//h1[normalize-space(text())='Add Contact']")
    private WebElement addContactTitle;
    @FindBy(id = "phone")
    private WebElement phoneNumberInput;


    public boolean isTitleDisplayed() {
        try {
            return wait(addContactTitle).isDisplayed();
        } catch (Exception e) {
            logger.warn("Problem with add new contact title");
            throw new RuntimeException(e);
        }
    }

    public void fillPhoneNumberInput(String phoneNumber){
        phoneNumberInput.sendKeys(phoneNumber);
    }


}
