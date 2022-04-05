package steps.assertions;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import steps.BaseSteps;


public class AssertHeaderMainPageSteps extends BaseSteps {


    @Step("Проверка: В шапке отображается строка поиска товаров")
    public void assertThatInputSearchFieldIsVisible() {
        String message = "В шапке не отображается строка поиска товаров";
        Assertions.assertTrue(headerMainPage.isInputSearchFieldVisible(), message);
    }

    @Step("Проверка: Кнопка \"Корзина\" не активна")
    public void assertThatCartButtonIsDisabled() {
        String message = "Кнопка \"Корзина\" активна";
        Assertions.assertTrue(headerMainPage.isCartButtonDisabled(), message);
    }

    @Step("Проверка: Кнопка \"Избранное\" не активна")
    public void assertThatFavButtonIsDisabled() {
        String message = "Кнопка \"Избранное\" активна";
        Assertions.assertTrue(headerMainPage.isFavButtonDisabled(), message);
    }

    @Step("Проверка: Кнопка \"Сравнение\" не активна")
    public void assertThatComparisonButtonIsDisabled() {
        String message = "Кнопка \"Сравнение\" активна";
        Assertions.assertTrue(headerMainPage.isComparisonButtonDisabled(), message);
    }

    @Step("Проверка: Кнопка \"Войти\" активна")
    public void assertThatLoginButtonIsEnabled() {
        String message = "Кнопка \"Войти\" не активна";
        Assertions.assertTrue(headerMainPage.isLoginButtonEnabled(), message);
    }

    @Step("Проверка: Кнопка \"Статус заказа\" активна")
    public void assertThatStatusOrderButtonIsEnabled() {
        String message = "Кнопка \"Статус заказа\" не активна";
        Assertions.assertTrue(headerMainPage.isStatusOrderButtonEnabled(), message);
    }

    @Step("Проверка: На кнопке \"Корзина\" отображается число \"{expectedNumber}\"")
    public void assertThatCartBubbleHave(String expectedNumber) {
        String message = "Не отображается число \"" + expectedNumber + "\" на кнопке \"Корзина\" ";
        String actual = headerMainPage.getCartBubbleNumber();
        Assertions.assertEquals(expectedNumber, actual, message);
    }

    @Step("Проверка: Кнопка \"Корзина\" в шапке становится активной")
    public void assertThatCartButtonBecomeEnabled() {
        String message = "Кнопка \"Корзина\" не стала активной";
        Assertions.assertTrue(headerMainPage.isCartButtonEnabled(), message);
    }

    @Step("Проверка: На кнопке \"Сравнение\" отображается \"{expectedNumber}\"")
    public void assertThatComparisonBubbleHave(String expectedNumber) {
        String message = "Не отображается число \"" + expectedNumber + "\" на кнопке \"Сравнение\"";
        String actual = headerMainPage.getComparisonBubbleText();
        Assertions.assertEquals(expectedNumber, actual, message);
    }

    @Step("Проверка: Кнопка \"Сравнение\" в шапке становится активной")
    public void assertThatComparisonBubbleBecomeEnabled() {
        String message = "Кнопка \"Сравнение\" не стала активной";
        Assertions.assertTrue(headerMainPage.isComparisonButtonEnabled(), message);
    }

    @Step("Проверка: На кнопке \"Избранное\" отображается \"{expectedNumber}\"")
    public void assertThatFavBubbleHave(String expectedNumber) {
        String message = "Не отображается число \"" + expectedNumber + "\" на кнопке \"Избранное\"";
        String actual = headerMainPage.getFavBubbleText();
        Assertions.assertEquals(expectedNumber, actual, message);
    }

}
