package steps;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import ru.mvideo.pages.MainPage;

public class MainPageSteps extends BaseSteps {

    private MainPage mainPage = Selenide.page(new MainPage());

    @Step("Нажать у товара дня на кнопку \"В корзину\"")
    public void clickAddToCartButtonDayProduct() {
        mainPage.saveDayProductName();
        mainPage.saveDayProductPrice();
        mainPage.clickAddToCartButtonOnMainDayProduct();
        headerMainPage.cartButtonShouldBeEnabled();
    }

    @Step("У кнопки \"Корзина\" отображается {expectedCounter}")
    public void cartShouldHaveText(String expectedCounter) {
        headerMainPage.cartBubbleShouldHaveText(expectedCounter);
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
