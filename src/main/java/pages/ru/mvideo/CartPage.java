package pages.ru.mvideo;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import helpers.Scroll;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static helpers.MVCollections.collectCartPageProductsInfoToMap;

public class CartPage extends BasePage {

    @FindBy(xpath = "//span[contains(@class, 'c-cart-item__price')]")
    ElementsCollection ordersPricesCollection;
    @FindBy(xpath = "//a[contains(@class, 'c-cart-item__title')]")
    ElementsCollection ordersNamesCollection;
    @FindBy(xpath = "//div[@class= 'c-cart__order']")
    ElementsCollection cartOrders;
    @FindBy(xpath = "//div[@id='ui-id-1']")
    SelenideElement rightCostBlock;


    public CartPage checkThatCartPageHeaderTitleContains(String expectedText) {
        SelenideElement cartPageTitle = $x("//span[text()='Моя корзина']");
        cartPageTitle.shouldBe(visible).shouldHave(text(expectedText));
        return this;
    }

    public CartPage checkThatGoToCheckoutButtonVisible() {
        SelenideElement goToCheckoutInputButton = $x("//input[@value='Перейти к оформлению']");
        goToCheckoutInputButton.shouldBe(visible);
        return this;
    }

    public CartPage checkThatCostLineTitleContains(String expectedText) {
        SelenideElement costLineTitle = $x("//span[@class='c-cost-line__title']");
        costLineTitle.shouldHave(text(expectedText));
        return this;
    }

    public CartPage checkThatOrdersVisible() {
        $$x("//div[@class= 'c-cart__order']")
                .forEach(order ->
                        order.scrollIntoView(Scroll.center)
                                .shouldBe(visible));
        return this;
    }

    public CartPage collectCartPageProductsInfo() {
        ElementsCollection namesElements = $$x("//a[contains(@class, 'c-cart-item__title')]");
        ElementsCollection pricesElements = $$x("//span[@class='c-cart-item__price']");
        collectCartPageProductsInfoToMap(namesElements, pricesElements);
//        System.out.println(cartPageProductsCollection);
        return this;
    }

//    public CartPage checkTitleShouldBeVisible() {
//        cartPageTitle.shouldBe(visible);
//        return this;
//    }
//
//    public boolean isRightCostBlockEquals(String expectedText) {
//        return $x("//span[@class='c-cost-line__title']")
//                .getOwnText()
//                .replaceAll("[\\u00A0\\s]+", " ")
//                .trim()
//                .equals(expectedText);
//    }
//
//    public String getRightCostBlockTitleText() {
//        return $x("//span[@class='c-cost-line__title']")
//                .getOwnText()
//                .replaceAll("[\\u00A0\\s]+", " ")
//                .strip();
//    }
//
//    public int getCostLinePrice() {
//        return Integer.parseInt($x("//span[@class='c-cost-line__text']")
//                .getOwnText()
//                .replaceAll("[\\u00A0\\s]+", "")
//                .replace('¤', ' ')
//                .trim());
//    }
//
//    public boolean checkoutBlockIsVisible() {
//        return rightCostBlock.is(existAndVisible());
//    }
//
//    public boolean isGoToCheckoutButtonIsVisible() {
//        return goToCheckoutInputButton.is(existAndVisible());
//    }
//
//    public void cartPageTitleShouldBeVisible() {
//        cartPageTitle.shouldBe(visible);
//    }
//
//    public boolean cartOrdersIsVisible() {
//        return cartOrders.stream()
//                .allMatch(element -> element
//                        .scrollIntoView(Scroll.center)
//                        .is(existAndVisible()));
//    }
//
//    public String getCartPageTitleText() {
//        return cartPageTitle.getText();
//    }
//
//    public boolean orderPricesContains(String price) {
//        return ordersPricesCollection.stream().anyMatch(ele -> ele.getText()
//                .replaceAll("[\\u00A0\\s]+", "")
//                .replaceAll("\\s+", "")
//                .replace('¤', ' ').contains(price));
//    }
//
//    public String getFirstOrderPrice() {
//        return $x("//div[@class= 'c-cart__order']//span[@class='c-cart-item__price']")
//                .getText()
//                .replaceAll("[\\u00A0\\s]+", "")
//                .replaceAll("\\s+", "")
//                .replace('¤', ' ')
//                .trim();
//    }
//
//    public String getFirstOrderName() {
//        return $x("//div[@class= 'c-cart__order']//a[contains(@class, 'c-cart-item__title')]")
//                .getOwnText()
//                .replaceAll("[\\u00A0\\s]+", " ")
//                .trim();
//    }
//
//    public List<String> getOrderNamesList() {
//        return ordersNamesCollection.stream()
//                .map(SelenideElement::getText)
//                .collect(Collectors.toList());
//    }
//
//    public List<Integer> getOrderPricesList() {
//        return ordersPricesCollection.stream()
//                .peek(element -> element.shouldBe(visible))
//                .map(element -> element.getText()
//                        .replaceAll("\\D", ""))
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//    }
}
