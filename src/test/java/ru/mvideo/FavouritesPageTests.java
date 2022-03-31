package ru.mvideo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

public class FavouritesPageTests extends BaseTest {

    @Test
    @DisplayName("Проверка добавления товаров в список сравнения")
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
