package tests;

import org.junit.jupiter.api.*;

@Order(6)
@DisplayName("Страница \"Избранное\"")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FavouritesPageTests extends BaseTest {

    @Test
    @DisplayName("Проверка добавления товаров в список избранного")
    public void addProductsToFavouritesTest() {
        assertHeaderMainPageSteps.assertThatInputSearchFieldIsVisible();
        headerMainPageSteps.fillSearchFieldAndClickSearchButton("apple");
        assertDriverManagerSteps.assertThatUrlContains("/product-list-page");
        assertDriverManagerSteps.assertThatUrlContains("apple");
        productListPageSteps.scrollEachResultSearchElement();
        productListPageSteps.clickFavButtonsOnThreeFirstVisibleProducts();
        assertHeaderMainPageSteps.assertThatFavBubbleHave("3");
        headerMainPageSteps.clickFavButton();
        assertDriverManagerSteps.assertThatUrlContains("/wish-list");
        assertFavouritesPageSteps.assertThatFavPageTitleContains("Избранное");
    }
}
