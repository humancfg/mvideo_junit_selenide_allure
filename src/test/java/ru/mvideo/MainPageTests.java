package ru.mvideo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pages.ru.mvideo.MainPage;

import static helpers.Buttons.*;

@Order(1)
@DisplayName("Тесты главной страницы")
public class MainPageTests extends BaseTest {

    @Test
    @Order(1)
    @DisplayName("Проверка шапки главной страницы mvideo")
    void headerButtonsTest() {
        mainPage.checkThatCartButtonEnabled(statusOrderButton, loginButton)
                .checkThatCartButtonDisabled(comparisonButton, favouritesButton, cartButton);
    }

    @Test
    @Order(2)
    @DisplayName("Проверка активации кнопки корзины")
    void cartPageTest() {
        mainPage.getDayProductsBlock()
                .checkThatDayProductsVisible()
                .clickFirstDayProductToCartButton(MainPage.class)
                .checkThatCartButtonEnabled(cartButton)
                .checkThatButtonBubbleHaveNumber(cartButton, "1");
    }

}
