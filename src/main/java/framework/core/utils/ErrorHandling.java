package framework.core.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ErrorHandling {

    private final WebDriver driver;

    @FindBy(id = "error")
    private WebElement errorMessage;
    private final Logger logger;

    public ErrorHandling(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logger = LogManager.getLogger(getClass());
    }

    public boolean isErrorMessageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            logger.warn("missing error message or problem with ErrorHandling class");
            return false;
        }
    }
}
