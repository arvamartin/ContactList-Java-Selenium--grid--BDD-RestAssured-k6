package stepDefinitions.ui;

import pages.RegistrationPage;
import utils.LoginAction;
import framework.core.utils.Browser;
import framework.core.utils.RandomGenerator;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RegistrationStep {

    private final RegistrationPage registrationPage = new RegistrationPage();
    private final LoginAction loginAction = new LoginAction(Browser.getDriver());


    @ParameterType("firstname|lastname")
    public String nameField(String value) {
        return value;
    }

    @ParameterType("acceptable|unacceptable")
    public String credentialQuality(String value) {
        return value;
    }

    @When("user enters {nameField}")
    public void userEntersName(String nameField) {
        String name = RandomGenerator.generateRandomNames();

        switch (nameField) {
            case "firstname" -> loginAction.fillFirstNameInput(name);
            case "lastname" -> loginAction.fillLastNameInput(name);
            default -> throw new IllegalArgumentException("Unsupported name field: " + nameField);
        }
    }

    @And("user enters {credentialQuality} email")
    public void userEntersEmail(String emailType) {
        String email = switch (emailType) {
            case "acceptable" -> RandomGenerator.generateRandomEmailAddress();
            case "unacceptable" -> RandomGenerator.generateRandomFakeEmail();
            default -> throw new IllegalArgumentException("Unsupported email type: " + emailType);
        };
        loginAction.fillEmailInput(email);
    }

    @And("user enters {credentialQuality} password")
    public void userEntersPassword(String passwordType) {
        String password = switch (passwordType) {
            case "acceptable" -> RandomGenerator.generateRandomString(10);
            case "unacceptable" -> RandomGenerator.generateRandomString(5);
            default -> throw new IllegalArgumentException("Unsupported password type: " + passwordType);
        };

        loginAction.fillPassword(password);
    }

    @And("user clicks on the cancel button")
    public void userClicksOnTheCancelButton() {
        loginAction.clickOnCancelBtn();
    }

    @Then("error message is displayed")
    public void errorMessageIsDisplayed() {
        boolean isDisplayed = registrationPage.isErrorMessageDisplayed();
        assertThat(isDisplayed, is(true));
    }

}
