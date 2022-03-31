package ru.mvideo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

public class ProductComparisonPageTests extends BaseTest{

    @Test
    @DisplayName("Проверка добавления товаров в список сравнения")
    public void addProductsToComparisonTest() {
        assertHeaderMainPageSteps.assertThatInputSearchFieldIsVisible();
        headerMainPageSteps.fillSearchFieldAndClickSearchButton("apple");
        assertDriverManagerSteps.assertThatUrlContains("/product-list-page");
        assertDriverManagerSteps.assertThatUrlContains("apple");
        productListPageSteps.scrollEachResultSearchElement();
        productListPageSteps.clickAddToComparisonButtonOnFirstVisibleProduct();
        assertHeaderMainPageSteps.assertThatComparisonBubbleBecomeEnabled();
        assertHeaderMainPageSteps.assertThatComparisonBubbleHave("1");
        productListPageSteps.clickAddToComparisonButtonOnFirstVisibleProduct();
        assertHeaderMainPageSteps.assertThatComparisonBubbleHave("2");
        productListPageSteps.clickAddToComparisonButtonOnFirstVisibleProduct();
        assertHeaderMainPageSteps.assertThatComparisonBubbleHave("3");
        headerMainPageSteps.clickComparisonButton();
        assertDriverManagerSteps.assertThatUrlContains("/product-comparison");
        assertProductComparisonPageSteps.assertThatComparisonPageTitleContains("Сравнение товаров");
    }

}
