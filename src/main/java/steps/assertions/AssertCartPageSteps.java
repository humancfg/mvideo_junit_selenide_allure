package steps.assertions;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import ru.mvideo.pages.MainPage;
import steps.BaseSteps;

public class AssertCartPageSteps extends BaseSteps {
    @Step("Проверка: В корзине отображаются карточки с наименованиями добавленных товаров")
    public void assertThatCartOrdersNamesEqualsAddedMostViewedNames() {
        String message = "В корзине не отображаются карточки с наименованиями добавленных товаров";
        String[] twoActualNames = new String[]{
                cartPage.getOrderNamesList().get(0),
                cartPage.getOrderNamesList().get(1)
        };
        String[] twoExpectedNames = new String[]{
                MainPage.mostViewedNamesList.get(0),
                MainPage.mostViewedNamesList.get(1)
        };
        Assertions.assertArrayEquals(twoExpectedNames, twoActualNames, message);
    }

    @Step("Проверка: Сумма всей корзины равна сумме цен добавленных товаров")
    public void assertThatCartCostPriceEqualsAddedMostViewedPrices() {
        String message = "Сумма всей корзины не равна сумме цен добавленных товаров";
        int actualCost = cartPage.getCostLinePrice();
        int expectedCost = MainPage.mostViewedPricesList.get(0) + MainPage.mostViewedPricesList.get(1);
        Assertions.assertEquals(expectedCost, actualCost, message);
    }

    @Step("Проверка: Цена совпадает с ценой добавленного товара")
    public void assertThatCartOrderPriceEqualsAddedDayProductPrice() {
        String message = "Цена не совпадает с ценой добавленного товара";
        String expectedPrice = MainPage.dayProductPrice;
        String actualPrice = cartPage.getFirstOrderPrice();
        Assertions.assertEquals(expectedPrice, actualPrice, message);
    }

    @Step("Проверка: В правом блоке отображается текст \"{expectedText}\"")
    public void assertThatRightBlockHaveExact(String expectedText) {
        String message = "Не отображается текст \"{expectedText}\" в правом блоке";
        Assertions.assertEquals(expectedText, cartPage.getRightCostBlockTitleText(), message);
    }

    @Step("Проверка: Отображается кнопка \"Перейти к оформлению\"")
    public void assertThatGoToCheckoutButtonIsVisible() {
        String message = "Не отображается кнопка \"Перейти к оформлению\"";
        Assertions.assertTrue(cartPage.isGoToCheckoutButtonIsVisible(), message);
    }

    @Step("Проверка: Отображаются карточки с товарами")
    public void assertThatCardOrdersIsVisible() {
        String message = "Не отображаются карточки с товарами";
        Assertions.assertTrue(cartPage.cartOrdersIsVisible(), message);
    }

    @Step("Проверка: Отображается карточка с наименованием добавленного товара")
    public void assertThatCartOrderNameEqualsAddedDayProductName() {
        String message = "Не отображается карточка с наименованием добавленного товара";
        String expectedName = MainPage.dayProductName;
        String actualName = cartPage.getFirstOrderName();
        Assertions.assertEquals(expectedName, actualName, message);
    }

    @Step("Проверка: Отображается заголовок \"{expectedTitle}\"")
    public void assertThatCartPageTitleEquals(String expectedTitle) {
        String message = "Не отображается заголовок \"" + expectedTitle + "\"";
        Assertions.assertEquals(expectedTitle, cartPage.getCartPageTitleText(), message);
    }
}
