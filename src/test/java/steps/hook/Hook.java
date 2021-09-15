package steps.hook;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import runner.browsermanager.DriverManager;
import runner.browsermanager.DriverType;
import runner.browsermanager.drivermanagerfactory.DriverManagerFactory;
import java.io.File;
import java.io.IOException;

public class Hook {

    private DriverManager driverManager;
    private static WebDriver driver;
    private static int countScenario = 0;

    @Before
    public void setUp() throws IOException {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.manage().window().maximize();
        //driver.get("http://10.1.115.64:8380/WEB3/ingreso.html");
        driver.get("http://10.16.5.64:8380/WEB3/ingreso.html");
        countScenario++;
        if (countScenario == 1) {
            FileUtils.deleteDirectory(new File("./src/test/assets/screenshots/loanflow"));
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) driverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
        driverManager.quitDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
