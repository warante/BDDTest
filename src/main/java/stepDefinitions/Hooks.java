package stepDefinitions;

import com.google.common.io.Files;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Hooks {
    static WebDriver driver;

    @Before
    public void setUp(){
        String browser = "chrome"; //chrome | firefox
        Boolean options = false;
        driver = utilities.DriverFactory.setDriver(browser, options);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);

            try{
                Files.move(screenshot, new File("resources/screenshots/" + scenario.getName() + "-" + scenario.getLines() + ".png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
