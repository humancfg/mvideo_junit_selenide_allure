package ru.mvideo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@Order(3)
public class ProductListPageTests extends BaseTest {

    @Test
    @Order(1)
    @DisplayName("Поиск товаров")
    public void querySearchTest() {
        assertHeaderMainPageSteps.assertThatInputSearchFieldIsVisible();
        headerMainPageSteps.fillSearchFieldAndClickSearchButton("apple");
        assertDriverManagerSteps.assertThatUrlContains("/product-list-page");
        assertDriverManagerSteps.assertThatUrlContains("apple");
        productListPageSteps.scrollEachResultSearchElement();
        assertProductListPageSteps.assertThatResultSearchNamesContainsOnly("apple");

    }

    @Test
    @Order(2)
    @DisplayName("Сортировка товаров в листинге")
    public void sortingProductsTest() {
        assertHeaderMainPageSteps.assertThatInputSearchFieldIsVisible();
        headerMainPageSteps.fillSearchFieldAndClickSearchButton("apple");
        assertDriverManagerSteps.assertThatUrlContains("/product-list-page");
        assertDriverManagerSteps.assertThatUrlContains("apple");
        productListPageSteps.scrollEachResultSearchElement();
        assertProductListPageSteps.assertThatResultSearchNamesContainsOnly("apple");
        productListPageSteps.clickVariationSortButton();
        assertProductListPageSteps.assertThatVariationSortListContains("Сначала популярные");
        productListPageSteps.selectVariationSortDropDownElement("Сначала дороже");
        assertProductListPageSteps.assertThatResultSearchNamesContainsOnly("apple");
        assertProductListPageSteps.assertThatPricesInDescendingOrder();
    }

}
