package tests;

import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.pages.factory.OnboardingPageFactory;
import lib.ui.pages.factory.SearchPageFactory;
import lib.ui.pages.factory.StartPageFactory;
import lib.ui.pages.interfaces.IOnboardingPageObject;
import lib.ui.pages.interfaces.ISearchPageObject;
import lib.ui.pages.interfaces.IStartPageObject;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class SearchTest extends CoreTestCase {

    // 1. Найти кнопку Search Wikipedia - org.wikipedia:id/search_container
    // 2. Кликнуть
    // 3. найти элемент Search
    // 4. Ввести текст Java
    // 5. Дождаться результата
    // 6. Выбрать по тексту Island of indonesia - //*[./*[contains(@text,"Island of Indonesia")]]
    //org.wikipedia:id/search_src_text

    @Test
    public void testSearch() {
        MainPageObject mainPO = new MainPageObject(this.driver);

        WebElement searchInit =  mainPO.waitForElementPresent(
                "id:org.wikipedia:id/search_container",
                "Cannot find Search Wikipedia init input"

        );
        searchInit.click();

        WebElement searchInput = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/search_src_text",
                "Cannot find search input "
        );
        searchInput.sendKeys("Java");

        WebElement expectedResult = mainPO.waitForElementPresent(
                "xpath://*[./*[contains(@text,'Island of Indonesia')]]",
                "Cannot find result 'Island of Indonesia on 'Java' search'"
        );

        expectedResult.click();

    }
}
