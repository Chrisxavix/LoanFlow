package runner.browsermanager.browsers.chrome;

import org.openqa.selenium.chrome.ChromeDriver;
import runner.browsermanager.DriverManager;

public class ChromeDriverManager extends DriverManager {
    @Override
    public void createDriver() {
        System.setProperty("webdriver.chrome.driver", "./src/test/assets/driversbrowsers/chrome/chromedriver");
        driver = new ChromeDriver();
    }
}
