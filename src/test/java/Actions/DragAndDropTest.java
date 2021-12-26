package ru.otus.actions;

import Actions.Basic;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

import static java.lang.Thread.sleep;

public class DragAndDropTest extends Basic {

    @Test
    public void test() throws InterruptedException {
        final String URL = "https://www.w3schools.com/html/html5_draganddrop.asp";

        driver.get(URL);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        if(!(Boolean) js.executeScript("return (typeof jQuery != \"undefined\")")) {
            js.executeScript(
                    "var headID = document.getElementsByTagName('head')[0];" +
                            "var newScript = document.createElement('script');" +
                            "newScript.type = 'text/javascript';" +
                            "newScript.src = 'https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js';" +
                            "headID.appendChild(newScript);");
            WebDriverWait waitJQ = new WebDriverWait(driver, 30);
            Function<WebDriver, Boolean> jQueryAvailable = WebDriver -> (
                    (Boolean) js.executeScript("return (typeof jQuery != \"undefined\")")
            );
            waitJQ.until(jQueryAvailable);
        }

        WebElement draggableFrom = driver.findElement(By.cssSelector("img[draggable=true]"));
        WebElement draggableTo = driver.findElement(By.cssSelector("#div2"));

        String jsScript = readScript("helper.js") + "$(arguments[0]).simulateDragDrop({dropTarget:arguments[1]});";
        js.executeScript(jsScript, draggableFrom, draggableTo);

        sleep(5000);
    }
}
