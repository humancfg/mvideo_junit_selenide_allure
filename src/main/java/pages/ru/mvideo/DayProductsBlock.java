package pages.ru.mvideo;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static helpers.MVCollections.collectDayProductsInfoToMap;

public class DayProductsBlock extends BasePage{
    private String dayProductBlockXpath = "//mvid-day-products-block";
    private String toCartButtonsXpath = "//span[normalize-space(text())='В корзину']";

    public DayProductsBlock checkThatDayProductsVisible() {
       $x(dayProductBlockXpath).shouldBe(visible);
        return this;
    }

    public DayProductsBlock clickFirstDayProductToCartButton() {
        ElementsCollection dayProductsButtons = $$x(toCartButtonsXpath);
        dayProductsButtons.get(1).shouldBe(visible).click();
        return this;
    }

    public <T extends BasePage> T clickFirstDayProductToCartButton(Class<T> pageObjectClass) {
        ElementsCollection dayProductsButtons = $$x(toCartButtonsXpath);
        dayProductsButtons.get(1).shouldBe(visible).click();
        return page(pageObjectClass);
    }

    public DayProductsBlock collectDayProductInfo() {
        By namesXpath = By.xpath(".//div[contains(@class, 'title')]/a");
        By prices = By.xpath(".//span[@class= 'price__main-value']");
        ElementsCollection namesElements = $x(dayProductBlockXpath).findAll(namesXpath);
        ElementsCollection pricesElements = $x(dayProductBlockXpath).findAll(prices);
        collectDayProductsInfoToMap(namesElements, pricesElements);
//        System.out.println(dayProductsCollection);
        return this;
    }
}
