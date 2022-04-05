package steps.assertions;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pages.ProductListPage;
import steps.BaseSteps;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AssertProductListPageSteps extends BaseSteps {

    @Step("Проверка: Отображаются только товары содержащие в названии слово \"{expectedWord}\" в любом регистре")
    public void assertThatResultSearchNamesContainsOnly(String expectedWord) {
        String message = "Отображаются не только товары содержащие в названии слово \"{expectedWord}\"";
        Assertions.assertTrue(productListPage.isEachNameInSearchResultContains(expectedWord), message);
    }

    @Step("Проверка: Отображается выпадающий список вариантов сортировки со значением \"{expected}\"")
    public void assertThatVariationSortListContains(String expected) {
        String message = "Не отображается выпадающий список вариантов сортировки со значением \"{expected}\"";
        Assertions.assertTrue(productListPage.isVariationSortDropDownListContains(expected), message);
    }

    @Step("Проверка: Цена следующего (слева-направо) меньше или равна текущего товара")
    public void assertThatPricesInDescendingOrder() {
        String message = "Цены не отображаются в порядке убывания";
        List<Integer> actualPricesList = ProductListPage.productPricesList;
        List<Integer> expectedPricesList = ProductListPage.productPricesList.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        Assertions.assertIterableEquals(expectedPricesList, actualPricesList, message);
    }


}
