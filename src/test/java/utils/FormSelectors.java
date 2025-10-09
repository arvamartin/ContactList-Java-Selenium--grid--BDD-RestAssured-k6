package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormSelectors {

    @FindBy(id = "firstName")
    private WebElement firstNameInput;
    @FindBy(id = "lastName")
    private WebElement lastNameInput;
    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "submit")
    private WebElement submitBtn;
    @FindBy(id = "cancel")
    private WebElement cancelBtn;


    public FormSelectors (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    public WebElement getLastNameInput() {
        return lastNameInput;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getSubmitBtn() {
        return submitBtn;
    }

    public WebElement getCancelBtn() {
        return cancelBtn;
    }
}

