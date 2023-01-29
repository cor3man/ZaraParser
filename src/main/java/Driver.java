import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Driver {
    final static String PROJECT_PATH = System.getProperty("user.dir");

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", PROJECT_PATH + "/webdriver/v96/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions
                .addArguments("user-agent=Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.50 Safari/537.36")
                .addArguments("--headless");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        return driver;
    }
}
