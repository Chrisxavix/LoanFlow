package runner.browsermanager.browsers.firefox;

import org.openqa.selenium.firefox.FirefoxDriver;
import runner.browsermanager.DriverManager;

public class FirefoxDriverManager extends DriverManager {
    @Override
    public void createDriver() {
        System.setProperty("webdriver.gecko.driver", "./src/test/assets/driversbrowsers/firefox/geckodriver");
        driver = new FirefoxDriver();
    }
}
