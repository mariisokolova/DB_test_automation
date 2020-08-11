package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    public ChromeDriver driver;
    public WebDriverWait wait15second;

    @BeforeEach
    public void beforeAll() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        wait15second = new WebDriverWait(driver, 15);
    }


    @AfterEach
    public void afterAll() {
        driver.quit();
    }

}