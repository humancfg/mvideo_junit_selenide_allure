package steps;

import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class MainPageSteps extends BaseSteps{

    @Step("Нажать у товара дня на кнопку \"В корзину\"")
    public void clickAddToCartButtonDayProduct() {
        mainPage.saveDayProductName();
        mainPage.saveDayProductPrice();
        mainPage.clickAddToCartButtonOnMainDayProduct();
        headerMainPage.cartButtonShouldBeEnabled();
    }

    @Step("Нажать на кнопку \"В корзину\" у первых двух товаров")
    @Description("В блоке \"Самые просматриваемые\"")
    public void clickAddToCartOnFirstTwoMostViewedProducts() {
        mainPage.collectMostViewedProductsMap();
        mainPage.clickAddToCartOnFirstActiveButton();
        headerMainPage.cartButtonShouldBeEnabled();
        mainPage.clickAddToCartOnFirstActiveButton();
        headerMainPage.cartBubbleShouldHave("2");
    }
}
