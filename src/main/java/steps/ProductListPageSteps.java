package steps;

import helpers.Scroll;
import io.qameta.allure.Step;
import ru.mvideo.pages.ProductListPage;

public class ProductListPageSteps extends BaseSteps {

    @Step("Нажать кнопку добавления товара в Сравнение")
    public void clickAddToComparisonButtonOnFirstVisibleProduct() {
        productListPage.clickComparisonButtonOnFirstVisibleProduct();
        headerMainPage.hoverComparisonButton();
    }

    @Step("На первых трех товарах нажать кнопку добавления товара в избранное")
    public void clickFavButtonsOnThreeFirstVisibleProducts() {
        productListPage.collectFavButtons();
        productListPage.clickAddToToFavButtonBy(0);
        headerMainPage.favButtonShouldBeEnabled();
        productListPage.clickAddToToFavButtonBy(1);
        headerMainPage.hoverFavButton();
        productListPage.clickAddToToFavButtonBy(2);
        headerMainPage.favBubbleTextShouldHave("3");

    }

    @Step("Проскролить каждый элемент в поисковой выдаче")
    public void scrollEachResultSearchElement() {
        productListPage.scrollToPromoConfiguratorBlock();
        productListPage.scrollEachProductName();
        productListPage.productsNamesShouldBeVisible();
    }

    @Step("Нажать на кнопку вариантов сортировки")
    public void clickVariationSortButton() {
        productListPage.clickVariationSortButton();
        productListPage.variationSortDropDownShouldBeVisible();
    }

    @Step("Выбирать в списке вариантов сортировки значение \"{elementName}\"")
    public void selectVariationSortDropDownElement(String elementName) {
        productListPage.clickOnVariationSortDropDownElement(elementName);
        productListPage.skeletonLoaderShouldBeDisappear();
        productListPage.scrollToPromoConfiguratorBlock();
        productListPage.saveToListProductsPricesSearchResults();
    }
}
