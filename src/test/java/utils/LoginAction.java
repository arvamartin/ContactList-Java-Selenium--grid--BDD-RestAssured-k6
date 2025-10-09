package utils;


import org.openqa.selenium.WebDriver;

public class LoginAction {
    private final FormSelectors formSelectors;

    public LoginAction(WebDriver driver) {
        this.formSelectors = new FormSelectors(driver);
    }

    public void fillEmailInput(String email) {
        formSelectors.getEmailInput().sendKeys(email);
    }

    public void fillPassword(String password) {
        formSelectors.getPasswordInput().sendKeys(password);
    }

    public void clickOnSubmitBtn() {
        formSelectors.getSubmitBtn().click();
    }


    public void fillFirstNameInput(String firstName) {
        formSelectors.getFirstNameInput().sendKeys(firstName);
    }

    public void fillLastNameInput(String lastName) {
        formSelectors.getLastNameInput().sendKeys(lastName);
    }


    public void clickOnCancelBtn() {
        formSelectors.getCancelBtn().click();
    }
}
