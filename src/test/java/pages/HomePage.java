package pages;


import framework.core.BasePage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class HomePage extends BasePage {

    @FindBy(id = "logout")
    private WebElement logoutBtn;
    @FindBy(id = "add-contact")
    private WebElement addNewContactBtn;
    @FindBy(id = "myTable")
    private List<WebElement> contactsInTable;
    @FindBy(xpath = "//h1[normalize-space(text())='Contact List']")
    private WebElement headingTitle;
    @FindBy(xpath = "//div[@class='main-content']//p[1]")
    private WebElement message;
    @FindBy(id = "myTable")
    private WebElement contentTable;
    @FindBy(xpath = "//footer")
    private WebElement footer;


    public void getCookie(){
        String authToken = System.getProperty("authToken");
        if (authToken != null) {
            Cookie cookie = new Cookie("authToken", authToken);
            driver.manage().addCookie(cookie);
            driver.navigate().refresh();
        } else {
            logger.warn("authToken system property is not set.");
        }
    }

    public void clickOnLogoutBtn(){
        try {
            wait(logoutBtn).click();
        } catch (Exception e) {
            logger.warn("Problem during waiting for logoutBtn");
            throw new RuntimeException(e);
        }
    }

    public void clickOnAddNewContactBtn(){
        try {
            wait(addNewContactBtn).click();
        } catch (Exception e) {
            logger.warn("Problem during waiting for addNewContactBtn");
            throw new RuntimeException(e);
        }
    }

    public boolean isNewContactAppears(String contactPhoneNumber){
        wait.until(ExpectedConditions.visibilityOfAllElements(contactsInTable));
        for (WebElement contact : contactsInTable){
            if (contact.getText().contains(contactPhoneNumber)){
                return true;
            }
        }
        logger.warn("Problem with table loop");
        return false;
    }

    public HomePage verifyHeadingTitle() {
        boolean headingTitleIsPresent = wait(headingTitle).isDisplayed();
        assertThat(headingTitleIsPresent, is(true));

        String fontSize = headingTitle.getCssValue("font-size");
        boolean isCorrectFontSize = fontSize.equals("48px");
        assertThat(isCorrectFontSize, is(true));

        String titleText = headingTitle.getText();
        boolean isCorrectText = titleText.equals("Contact List");
        assertThat(isCorrectText, is(true));

        return this;
    }

    public HomePage verifyMessage() {
        boolean messageIsPresent = wait(message).isDisplayed();
        assertThat(messageIsPresent, is(true));

        String messageText = message.getText();
        boolean isCorrectText = messageText.equals("Click on any contact to view the Contact Details");
        assertThat(isCorrectText, is(true));
        return this;
    }

    public HomePage verifyContentTable() {
        boolean tableIsPresent = wait(contentTable).isDisplayed();
        assertThat(tableIsPresent, is(true));
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
