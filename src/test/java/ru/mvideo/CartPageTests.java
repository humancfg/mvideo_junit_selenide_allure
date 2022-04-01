package ru.mvideo;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Order(2)
public class CartPageTests extends BaseTest {

    @Test
    @Order(1)
    @DisplayName("Переход в корзину")
    @Execution(ExecutionMode.CONCURRENT)
    public void goToCartPageTest() {
        assertMainPageSteps.assertThatDayProductsBlockIsVisible();
        mainPageSteps.clickAddToCartButtonDayProduct();
        headerMainPageSteps.clickCartButton();
        assertDriverManagerSteps.assertThatUrlContains("/cart");
        assertCartPageSteps.assertThatCartPageTitleEquals("Моя корзина");
        assertCartPageSteps.assertThatCardOrdersIsVisible();
        assertCartPageSteps.assertThatCartOrderNameEqualsAddedDayProductName();
        assertCartPageSteps.assertThatGoToCheckoutButtonIsVisible();
        assertCartPageSteps.assertThatRightBlockHaveExact("В корзине 1 товар");
        assertCartPageSteps.assertThatCartOrderPriceEqualsAddedDayProductPrice();
    }

    @Test
    @Order(2)
    @DisplayName("Добавление в корзину два товара")
    @Description("Тут должно быть описание")
    public void addToCartTwoProductTest() {
        assertMainPageSteps.assertThatMostViewedBlockIsVisible();
        mainPageSteps.clickAddToCartOnFirstTwoMostViewedProducts();
        headerMainPageSteps.clickCartButton();
        assertCartPageSteps.assertThatCartOrdersNamesEqualsAddedMostViewedNames();
        assertCartPageSteps.assertThatCartCostPriceEqualsAddedMostViewedPrices();
    }
}
