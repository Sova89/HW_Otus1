package Listeners;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ListenerTestExample {
    @Test
    public void TestOnEventBeforeClick() {
        WebDriverManager.chromedriver().setup();
        EventFiringWebDriver driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new MarkBeforeClickListener());
        driver.manage().window().maximize();
        driver.get("https://yandex.ru/");
        driver.findElement(By.id("text")).click(); // search
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.ARROW_DOWN)
                .pause(1000).sendKeys(Keys.RETURN)
                .pause(5000).build().perform();
        driver.quit();
    }

/*
    private WebDriver driver;

    @BeforeMethod
    public void setUp(ITestContext iTestContext) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        iTestContext.setAttribute("driver", driver);
    }


    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
    @Test
    public void testNgTest() {
        driver.get("https://otus.ru/");
        driver.findElement(By.className("header2-menu__item-text")).click();
    }*/
}
