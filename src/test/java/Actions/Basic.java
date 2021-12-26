package Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Basic {
protected WebDriver driver;
protected WebDriverWait wait;


    @BeforeAll
    public static void setupWebDriverManager(){
    WebDriverManager.chromedriver().setup();
}

    @BeforeEach
    public void BeforeTest() {
    setUpDriverSession();
}

    @AfterEach
    public void quitBrowser() {
        if (driver!= null) {
            driver.quit();
        }
    }

    private void setUpDriverSession() {
    ChromeOptions options = new ChromeOptions();
    //options.setScriptTimeout(Duration.ofSeconds(30));
    options.addArguments("--kiosk");
    driver = new ChromeDriver(options);
   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
   wait = new WebDriverWait(driver, 10);
}

    protected  String readScript(String fileName) {
        InputStream is =getClass().getClassLoader().getResourceAsStream(fileName);
        assert  is !=null;
        return new BufferedReader(new InputStreamReader(is))
                .lines().collect(Collectors.joining("\n"));
}

}
