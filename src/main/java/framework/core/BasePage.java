package framework.core;

import framework.core.utils.Browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger logger;

    public BasePage() {
        this.driver = Browser.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
        logger = LogManager.getLogger(getClass());
    }

    protected WebElement wait(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }
    public boolean isCorrectPage(String url) {
        try {
            wait.until(ExpectedConditions.urlToBe(url));
            return Objects.equals(url, driver.getCurrentUrl());
        } catch (Exception e) {
            logger.warn("problem with url assertion");
            throw new RuntimeException(e);
        }
    }
}
