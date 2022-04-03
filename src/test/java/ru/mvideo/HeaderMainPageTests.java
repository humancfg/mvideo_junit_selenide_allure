package ru.mvideo;

import org.junit.Rule;
import org.junit.jupiter.api.*;
import org.junit.rules.TestRule;

@DisplayName("Шапка главной страницы")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HeaderMainPageTests extends BaseTest {

    @Test
    @Order(1)
    @DisplayName("Проверка шапки главной страницы mvideo")
    public void headerMainPageTest() {
        assertHeaderMainPageSteps.assertThatStatusOrderButtonIsEnabled();
        assertHeaderMainPageSteps.assertThatLoginButtonIsEnabled();
        assertHeaderMainPageSteps.assertThatComparisonButtonIsDisabled();
        assertHeaderMainPageSteps.assertThatFavButtonIsDisabled();
        assertHeaderMainPageSteps.assertThatCartButtonIsDisabled();
    }

    @Test
    @Order(2)
    @DisplayName("Проверка активации кнопки корзины")
    public void activateCartButtonTest() {
//        assertHeaderMainPageSteps.assertThatInputSearchFieldIsVisible();
        assertMainPageSteps.assertThatDayProductsBlockIsVisible();
        mainPageSteps.clickAddToCartButtonDayProduct();
        assertHeaderMainPageSteps.assertThatCartButtonBecomeEnabled();
//        mainPageSteps.cartShouldHaveText("1");
        assertHeaderMainPageSteps.assertThatCartBubbleHave("1");
    }
}
