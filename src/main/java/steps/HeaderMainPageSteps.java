package steps;

import io.qameta.allure.Step;

public class HeaderMainPageSteps extends BaseSteps {

    @Step("Нажать на кнопку \"Войти\"")
    public void clickLoginButton() {
        headerMainPage.clickLoginButton();
        authModalWindowPage.authModalWindowShouldBeVisible();
    }

    @Step("Нажать на кнопку \"Корзина\"")
    public void clickCartButton() {
        headerMainPage.clickCartButton();
        cartPage.cartPageTitleShouldBeVisible();
    }

    @Step("Нажать на кнопку \"Сравнение\"")
    public void clickComparisonButton() {
        headerMainPage.clickComparisonButton();
        productComparisonPage.comparisonTitleShouldBeVisible();
    }

    @Step("Нажать на кнопку \"Избранное\"")
    public void clickFavButton() {
        headerMainPage.clickFavButton();
        favouritesPage.favTitleShouldBeVisible();
    }

    @Step("Вводим в строку поиска товаров \"{query}\" и нажимаем на кнопку поиска")
    public void fillSearchFieldAndClickSearchButton(String queryText) {
        headerMainPage.fillInputSearchField(queryText);
        headerMainPage.clickSearchButton();
        productListPage.tabsSidePanelBottomShouldBeVisible();
    }



}
