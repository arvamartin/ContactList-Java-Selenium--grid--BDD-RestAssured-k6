package stepDefinitions.ui;

import pages.LoginPage;
import utils.LoginAction;
import framework.core.utils.Browser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.ConnectException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class LoginStep {

    private final LoginPage loginPage = new LoginPage();
    private final LoginAction loginAction = new LoginAction(Browser.getDriver());



    @Given("user is already on the {string} page")
    public void userIsOnTheWebPage(String url) throws ConnectException {
        loginPage.navigate(url);
    }

    @When("user verifies login page's ui elements")
    public void userVerifiesLoginPageUiElements() {
        loginPage.verifyHeadingTitle()
                .verifyWelcomeMessage()
                .verifyLoginHeader()
                .verifySignUpTextVisible()
                .verifyFooter();
    }

    @When("user enters {string} email address")
    public void userEntersEmailAddress(String email) {
        loginAction.fillEmailInput(email);
    }

    @And("user enters {string} password")
    public void userEntersPassword(String password) {
        loginAction.fillPassword(password);
    }

    @And("user clicks on the submit button")
    public void userClicksOnTheSubmitButton() {
        loginAction.clickOnSubmitBtn();
    }

    @Then("user is on the {string} page")
    public void userIsOnThePage(String url) {
        boolean isCorrectPage = loginPage.isCorrectPage(url);
        assertThat(isCorrectPage, is(true));
    }
}
