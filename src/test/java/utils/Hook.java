package utils;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.Logger;
import static framework.core.utils.Browser.getDriver;
import static framework.core.utils.Browser.quitDriver;
import static framework.core.utils.Constants.SCR_SHOT_PATH;


public class Hook {
    private static Logger logger = LogManager.getLogger(Hook.class);

    @After("@ui")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            takeScreenShot(scenario.getName());
        }
        quitDriver();
    }


    private void takeScreenShot(String name) {
        try {
            File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            File destFile = new File(SCR_SHOT_PATH.getValue() + name + ".png");
            FileUtils.copyFile(scrFile, destFile);
            logger.info("Screenshot saved to: {}", destFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            logger.warn("Problem with taking/saving screenshot");
        }
    }
}