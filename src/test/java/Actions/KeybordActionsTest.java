package Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class KeybordActionsTest extends Basic {
    @Test
    public void test() {
        final String URL = "https://yandex.ru";
        driver.get(URL);
        Actions actions = new Actions(driver);
        WebElement searchInput = driver.findElement(new By.ByCssSelector("input[name='text']"));
        actions.
                click(searchInput)
                .sendKeys(searchInput, "selenium")
                .pause(2000)
                .build()
                .perform();
    }
}
