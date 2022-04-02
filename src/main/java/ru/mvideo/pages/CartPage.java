package ru.mvideo.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import helpers.Scroll;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static helpers.MVConditions.existAndVisible;

public class CartPage {
    @FindBy(xpath = "//span[text()='Моя корзина']")
    SelenideElement cartPageTitle;

    @FindBy(xpath = "//span[contains(@class, 'c-cart-item__price')]")
    ElementsCollection ordersPricesCollection;

    @FindBy(xpath = "//a[contains(@class, 'c-cart-item__title')]")
    ElementsCollection ordersNamesCollection;

    @FindBy(xpath = "//div[@class= 'c-cart__order']")
    ElementsCollection cartOrders;

    @FindBy(xpath = "//input[@value='Перейти к оформлению']")
    SelenideElement goToCheckoutInputButton;

    @FindBy(xpath = "//div[@id='ui-id-1']")
    SelenideElement rightCostBlock;

    public boolean isRightCostBlockEquals(String expectedText) {
        return $x("//span[@class='c-cost-line__title']")
                .getOwnText()
                .replaceAll("[\\u00A0\\s]+", " ")
                .trim()
                .equals(expectedText);
    }

    public String getRightCostBlockTitleText() {
        return $x("//span[@class='c-cost-line__title']")
                .getOwnText()
                .replaceAll("[\\u00A0\\s]+", " ")
                .strip();
    }

    public int getCostLinePrice() {
        return Integer.parseInt($x("//span[@class='c-cost-line__text']")
                .getOwnText()
                .replaceAll("[\\u00A0\\s]+", "")
                .replace('¤', ' ')
                .trim());
    }

    public boolean checkoutBlockIsVisible() {
        return rightCostBlock.is(existAndVisible);
    }

    public boolean isGoToCheckoutButtonIsVisible() {
        return goToCheckoutInputButton.is(existAndVisible);
    }

    public void cartPageTitleShouldBeVisible() {
        cartPageTitle.shouldBe(visible);
    }

    public boolean cartOrdersIsVisible() {
        return cartOrders.stream()
                .allMatch(element -> element
                        .scrollIntoView(Scroll.center)
                        .is(existAndVisible));
    }

    public String getCartPageTitleText() {
        return cartPageTitle.getText();
    }

    public boolean orderPricesContains(String price) {
        return ordersPricesCollection.stream().anyMatch(ele -> ele.getText()
                .replaceAll("[\\u00A0\\s]+", "")
                .replaceAll("\\s+", "")
                .replace('¤', ' ').contains(price));
    }

    public String getFirstOrderPrice() {
        return $x("//div[@class= 'c-cart__order']//span[@class='c-cart-item__price']")
                .getText()
                .replaceAll("[\\u00A0\\s]+", "")
                .replaceAll("\\s+", "")
                .replace('¤', ' ')
                .trim();
    }

    public String getFirstOrderName() {
        return $x("//div[@class= 'c-cart__order']//a[contains(@class, 'c-cart-item__title')]")
                .getOwnText()
                .replaceAll("[\\u00A0\\s]+", " ")
                .trim();
    }

    public List<String> getOrderNamesList() {
        return ordersNamesCollection.stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList());
    }

    public List<Integer> getOrderPricesList() {
        return ordersPricesCollection.stream()
                .peek(element -> element.shouldBe(visible))
                .map(element -> element.getText()
                        .replaceAll("\\D", ""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
