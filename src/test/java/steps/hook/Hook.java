package steps.hook;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;

public class Hook {

    private static WebDriver driver;
    private static int countScenario = 0;

    @Before
    public void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "./src/test/assets/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        countScenario++;
        if (countScenario == 1) {
            FileUtils.deleteDirectory(new File("./src/test/assets/screenshots/loanflow"));
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
