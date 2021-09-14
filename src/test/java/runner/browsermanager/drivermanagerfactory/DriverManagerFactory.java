package runner.browsermanager.drivermanagerfactory;

import runner.browsermanager.DriverManager;
import runner.browsermanager.DriverType;
import runner.browsermanager.browsers.chrome.ChromeDriverManager;
import runner.browsermanager.browsers.edge.EdgeDriverManager;
import runner.browsermanager.browsers.firefox.FirefoxDriverManager;

public class DriverManagerFactory {
    public static DriverManager getManager(DriverType type) {
        DriverManager driverManager = null;
        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            case EDGE:
                driverManager = new EdgeDriverManager();
                break;
            default:
                System.out.println("Browser no seleccionado.");
                System.out.println("Chrome por default.");
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;
    }
}
