package tests;

import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;

@Order(3)
@DisplayName("Поиск")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductListPageTests extends BaseTest {

    @Test
    @Order(1)
    @DisplayName("Поиск товаров")
    public void querySearchTest() {
        step("\"Поиск товаров\"", () -> {
            assertHeaderMainPageSteps.assertThatInputSearchFieldIsVisible();
        });
        step("\"Заполнить поле\"", () -> {
            assertHeaderMainPageSteps.assertThatInputSearchFieldIsVisible();
        });
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
