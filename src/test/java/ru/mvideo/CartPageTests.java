package ru.mvideo;

import assertions.MVAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pages.ru.mvideo.CartPage;
import pages.ru.mvideo.MainPage;
import pages.ru.mvideo.MostViewedBlock;

import static helpers.Buttons.cartButton;
import static helpers.MVCollections.ADD_TO_CART_BUTTON;
import static properties.TestData.propsUrl;

@Order(2)
@DisplayName("Тесты Корзины")
public class CartPageTests extends BaseTest {

    @Test
    @Order(1)
    @DisplayName("Переход в корзину")
    void goToCartPageTest() {
        mainPage.getDayProductsBlock()
                .checkThatDayProductsVisible()
                .collectDayProductInfo()
                .clickFirstDayProductToCartButton(MainPage.class)
                .checkThatCartButtonEnabled(cartButton)
                .clickButton(cartButton, CartPage.class)
                .checkThatCartPageHeaderTitleContains("Моя корзина")
                .checkThatGoToCheckoutButtonVisible()
                .checkThatOrdersVisible()
                .checkThatCostLineTitleContains("В корзине 1 товар")
                .collectCartPageProductsInfo()
                .checkThatUrlContains(propsUrl.cartPageUri());

        MVAssertions.assertThatMapsAreEquals();
    }

    @Test
    @Order(2)
    @DisplayName("Добавление в корзину два товара")
    void addToCartTwoProducts() {
        mainPage.scrollEachBlock(MostViewedBlock.class)
                .checkThatMostViewedBlockVisible()
                .collectMostViewedProductsToMap()
                .clickButton(ADD_TO_CART_BUTTON)
                .checkThatHeaderButtonBubbleHave("1", cartButton, MostViewedBlock.class)
                .clickButton(ADD_TO_CART_BUTTON)
                .checkThatHeaderButtonBubbleHave("2", cartButton, MainPage.class)
                .clickButton(cartButton, CartPage.class);
    }

//    @Test
//    @Order(2)
//    @DisplayName("Добавление в корзину два товара")
//    void sdfdsfsdfsdfsdfsdfsdfsdfsddfffffffffffffffffffffffffffffffffffff() {
//        mainPage.scrollEachBlock(MostViewedBlock.class)
//                .checkThatMostViewedBlockVisible()
//                .collectMostViewedProductsToMap()
//    }
}
