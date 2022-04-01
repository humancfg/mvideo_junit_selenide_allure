package pages.ru.mvideo;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import helpers.Buttons;
import helpers.Scroll;
import org.openqa.selenium.By;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;
import static helpers.Buttons.cartButton;
import static helpers.MVCollections.*;

public class MostViewedBlock extends BasePage {
    private String mostViewedXpath = "//h2[text()='Самые просматриваемые']/ancestor::mvid-simple-product-collection";

    public MostViewedBlock checkThatMostViewedBlockVisible() {
        $x(mostViewedXpath).scrollIntoView(Scroll.center);
        $x(mostViewedXpath).shouldBe(visible);
        return this;
    }

    public MostViewedBlock collectMostViewedProductsToMap() {
        By mostViewedNames = By.xpath(".//a/div[text()]");
        By mostViewedPrices = By.xpath(".//mvid-price-2//span[@class='price__main-value']");
        By mostAddToCartButtons = By.xpath(".//button[@title='Добавить в корзину']");
        By mostAddToFavouritesButtons = By.xpath(".//button[@title='Добавить в избранное']");
        By mostAddToComparisonButtons = By.xpath(".//button[@title='Добавить в сравнение']");

        ElementsCollection eleNames = $x(mostViewedXpath).findAll(mostViewedNames);
        ElementsCollection elePrices = $x(mostViewedXpath).findAll(mostViewedPrices);
        ElementsCollection eleAddToCartButtons = $x(mostViewedXpath).findAll(mostAddToCartButtons);
        ElementsCollection eleAddToFavouritesButtons = $x(mostViewedXpath).findAll(mostAddToFavouritesButtons);
        ElementsCollection eleAddToComparisonButtons = $x(mostViewedXpath).findAll(mostAddToComparisonButtons);

        eleNames.get(0).scrollIntoView(Scroll.center);

        collectMostViewedProductsInfoToMap(eleNames, elePrices, eleAddToCartButtons, eleAddToFavouritesButtons,
                eleAddToComparisonButtons);

//        System.out.println(mostViewedProductsCollection);

        return this;
    }

    public MostViewedBlock clickButton(String buttonName) {
//доработать - с ожиданием бабла кликает через одну кнопку
//        AtomicInteger bubbleCounter = new AtomicInteger();
//        mostViewedProductsCollection.stream()
//                .peek(x -> x.get(buttonName))
//                .limit(buttonClicksLimit)
//                .collect(Collectors.toList())
//                .forEach(x ->
//                        {
//                            SelenideElement button = (SelenideElement) x.get(buttonName);
//                            button.click();
//                            checkThatHeaderButtonEnabled(cartButton);
//                            bubbleCounter.getAndIncrement();
//                            headerAddToCartBubble.shouldHave(text(bubbleCounter.toString()));
//                        }
//                );
        SelenideElement element = (SelenideElement) mostViewedProductsCollection.stream()
                .peek(x->x.get(buttonName))
                .findFirst()
                .get()
                .get(buttonName);
        element.click();

        return this;
    }

    public <T extends BasePage> T clickButton(String buttonName, Class<T> pageObjectClass) {
        SelenideElement element = (SelenideElement) mostViewedProductsCollection.stream()
                .peek(x->x.get(buttonName))
                .findFirst()
                .get()
                .get(buttonName);
        element.click();
        return page(pageObjectClass);
    }

}
