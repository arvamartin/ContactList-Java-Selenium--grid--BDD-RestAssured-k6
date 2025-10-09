package pages;

import framework.core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.net.ConnectException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class LoginPage extends BasePage{

    @FindBy(xpath = "//h1[normalize-space(text())='Contact List App']")
    private WebElement headingTitle;
    @FindBy(xpath = "//h1[text()='Contact List App']/following-sibling::div")
    private WebElement welcomeMessage;
    @FindBy(xpath = "//p[normalize-space(text())='Log In:']")
    private WebElement loginHeading;
    @FindBy(xpath = "//p[text()='Log In:']/following-sibling::p")
    private WebElement signUpText;
    @FindBy(xpath = "//footer")
    private WebElement footer;

    public void navigate(String url) throws ConnectException {
        try {
            driver.get(url);
        } catch (Exception e) {
            logger.warn("Unable to load url");
            throw new ConnectException();
        }
    }

    public LoginPage verifyHeadingTitle() {
        boolean headingTitleIsPresent = wait(headingTitle).isDisplayed();
        assertThat(headingTitleIsPresent, is(true));

        String fontSize = headingTitle.getCssValue("font-size");
        boolean isCorrectFontSize = fontSize.equals("48px");
        assertThat(isCorrectFontSize, is(true));

        String titleText = headingTitle.getText();
        boolean isCorrectText = titleText.equals("Contact List App");
        assertThat(isCorrectText, is(true));

        return this;
    }

    public LoginPage verifyWelcomeMessage() {
        boolean welcomeMessageIsPresent = wait(welcomeMessage).isDisplayed();
        assertThat(welcomeMessageIsPresent, is(true));

        String messageText = welcomeMessage.getText();
        boolean isCorrectText = messageText.equals("Welcome! This application is for testing purposes only. The database will be purged as needed to keep costs down.");
        assertThat(isCorrectText, is(true));
        return this;
    }

    public LoginPage verifyLoginHeader() {
        assertThat(loginHeading.isDisplayed(), is(true));
        assertThat(loginHeading.getText(), is("Log In:"));
        return this;
    }

    public LoginPage verifySignUpTextVisible() {
        assertThat(signUpText.isDisplayed(), is(true));

        boolean isCorrectText = signUpText.getText().equals("Not yet a user? Click here to sign up!");
        assertThat(isCorrectText, is(true));
        return this;
    }

    public void verifyFooter() {
        boolean footerIsPresent = wait(footer).isDisplayed();
        assertThat(footerIsPresent, is(true));

        String footerText = footer.getText();
        boolean isCorrectText = footerText.equals("Created by Kristin Jackvony, Copyright 2021");
        assertThat(isCorrectText, is(true));
    }
}
