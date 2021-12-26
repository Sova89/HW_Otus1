package Actions;

import org.junit.Test;

public class HoverElementsTest extends Basic {
    private final String URL = "https://otus.ru/categories/programming";

    @Test
    public void navigationTabsVisibilityTest() {
        driver.get(URL);

        String courseMenuItemLocator = ".//p[@class= 'header2-menu__item-text' and text()=''Курсы]";
        String testingSubmenuItemLocator = "//div[contains(@class, 'header2-menu_subdropdown-wrapper')]/a[contains(@href,'/categories/testing')]";
        String dropDownMenuTriggerLocator ="//a[contains(@title, 'Тестирование')]/div[contains(@class, 'js-menu-subdropdown-trigger')]";
        String pythonSubmenuItemLocator = "//a[contains(@href, /)]";


    }
}
