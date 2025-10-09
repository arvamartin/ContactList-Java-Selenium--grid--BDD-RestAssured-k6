package stepDefinitions.ui;

import pages.RegistrationPage;
import utils.LoginAction;
import framework.core.utils.Browser;
import framework.core.utils.RandomGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RegistrationStep {

    private final RegistrationPage registrationPage = new RegistrationPage();
    private LoginAction loginAction = new LoginAction(Browser.getDriver());



    @When("user enters firstname")
    public void userEntersFirstname() {
        String firstName = RandomGenerator.generateRandomNames();
        loginAction .fillFirstNameInput(firstName);
    }

    @And("user enters lastname")
    public void userEntersLastname() {
        String lastName = RandomGenerator.generateRandomNames();
        loginAction .fillLastNameInput(lastName);
    }

    @And("user enters acceptable email")
    public void userEntersAcceptableEmail() {
        String email = RandomGenerator.generateRandomEmailAddress();
        loginAction.fillEmailInput(email);
    }

    @And("user enters acceptable password")
    public void userEntersAcceptablePassword() {
        String password = RandomGenerator.generateRandomString(10);
        loginAction .fillPassword(password);
    }

    @And("user enters unacceptable email")
    public void userEntersUnacceptableEmail() {
        String email = RandomGenerator.generateRandomFakeEmail();
        loginAction .fillEmailInput(email);
    }

    @And("user enters unacceptable password")
    public void userEntersUnacceptablePassword() {
        String password = RandomGenerator.generateRandomString(5);
        loginAction .fillPassword(password);
    }

    @And("user clicks on the cancel button")
    public void userClicksOnTheCancelButton() {
        loginAction .clickOnCancelBtn();
    }

    @Then("error message is displayed")
    public void errorMessageIsDisplayed() {
        boolean isDisplayed = registrationPage.isErrorMessageDisplayed();
        assertThat(isDisplayed, is(true));
    }

}
