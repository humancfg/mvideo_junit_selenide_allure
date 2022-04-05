package tests;

import org.junit.jupiter.api.*;

@Order(2)
@DisplayName("Страница \"Моя корзина\"")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CartPageTests extends BaseTest {

    @Test
    @Order(1)
    @DisplayName("Переход в корзину")
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
    public void addToCartTwoProductTest() {
        assertMainPageSteps.assertThatMostViewedBlockIsVisible();
        mainPageSteps.clickAddToCartOnFirstTwoMostViewedProducts();
        headerMainPageSteps.clickCartButton();
        assertCartPageSteps.assertThatCartOrdersNamesEqualsAddedMostViewedNames();
        assertCartPageSteps.assertThatCartCostPriceEqualsAddedMostViewedPrices();
    }
}
