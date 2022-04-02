package ru.mvideo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.Isolated;

@Order(1)
@DisplayName("Шапка главной страницы")
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
        assertHeaderMainPageSteps.assertThatCartBubbleHave("1");
    }
}
