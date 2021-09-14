package runner.browsermanager.browsers.edge;

import org.openqa.selenium.edge.EdgeDriver;
import runner.browsermanager.DriverManager;

public class EdgeDriverManager extends DriverManager {
    @Override
    public void createDriver() {
        System.setProperty("webdriver.edge.driver", "./src/test/assets/driversbrowsers/edge/msedgedriver");
        driver = new EdgeDriver();
    }
}
