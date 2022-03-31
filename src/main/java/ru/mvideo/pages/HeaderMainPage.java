package ru.mvideo.pages;

import com.codeborne.selenide.SelenideElement;
import helpers.MVConditions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class HeaderMainPage {
    @FindBy(xpath = "//mvid-header-icon//a[@title='Статус заказа']")
    private SelenideElement statusOrderButton;
    @FindBy(xpath = "//mvid-header-icon[@tooltiptype='profile']")
    private SelenideElement loginButton;
    @FindBy(xpath = "//mvid-header-icon[@title='Сравнение']")
    private SelenideElement comparisonButton;
    @FindBy(xpath = "//mvid-header-icon[@title='Сравнение']//mvid-bubble")
    private SelenideElement comparisonBubble;
    @FindBy(xpath = "//mvid-header-icon[@title='Избранное']")
    private SelenideElement favButton;
    @FindBy(xpath = "//mvid-header-icon[@title='Избранное']//mvid-bubble")
    private SelenideElement favBubble;
    @FindBy(xpath = "//mvid-header-icon[@title='Корзина']")
    private SelenideElement cartButton;
    @FindBy(xpath = "//mvid-header-icon[@title='Корзина']//mvid-bubble")
    private SelenideElement cartBubble;
    @FindBy(xpath = "//header//input[contains(@class,'input__field')]")
    private SelenideElement inputSearchField;
    @FindBy(xpath = "//header//mvid-icon[@type='search']")
    private SelenideElement searchButton;

    public void clickComparisonButton() {
        comparisonButton.shouldBe(MVConditions.buttonHeaderExistsAndEnabled()).click();
    }

    public void hoverComparisonButton() {
        comparisonButton
                .hover();
    }

    public String getComparisonBubbleText() {
        return comparisonBubble
                .getText();
    }

    public void clickFavButton() {
        favButton
                .shouldBe(MVConditions.buttonHeaderExistsAndEnabled()).click();
    }

    public void hoverFavButton() {
        favButton
                .hover();
    }

    public String getFavBubbleText() {
        return favBubble
                .getText();
    }

    public void favBubbleTextShouldHave(String expectedNumber) {
        favBubble.shouldHave(text(expectedNumber));
    }

    public void favButtonShouldBeEnabled() {
        favButton
                .shouldBe(MVConditions.buttonHeaderExistsAndEnabled());
    }


    public void clickLoginButton() {
        loginButton.shouldBe(visible).click();
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void fillInputSearchField(String query) {
        inputSearchField.sendKeys(query);
    }

    public boolean isInputSearchFieldVisible() {
        return inputSearchField.is(MVConditions.existAndVisible());
    }

    public String getCartBubbleNumber() {
        return cartBubble.getText();
    }

    public void clickCartButton() {
        cartButton.shouldBe(visible).click();
    }

    public void cartBubbleShouldHave(String number) {
        cartBubble.shouldHave(text(number));
    }

    public void cartButtonShouldBeEnabled() {
        cartButton.shouldBe(MVConditions.buttonHeaderExistsAndEnabled());
    }

    public boolean isStatusOrderButtonEnabled() {
        return statusOrderButton.is(MVConditions.buttonHeaderExistsAndEnabled());
    }

    public boolean isLoginButtonEnabled() {
        return loginButton.is(MVConditions.buttonHeaderExistsAndEnabled());
    }

    public boolean isComparisonButtonDisabled() {
        return comparisonButton.is(MVConditions.buttonHeaderExistsAndDisabled());
    }

    public void comparisonButtonShouldBeEnabled() {
        comparisonButton.shouldBe(MVConditions.buttonHeaderExistsAndEnabled());
    }

    public boolean isComparisonButtonEnabled() {
        return comparisonButton.is(MVConditions.buttonHeaderExistsAndEnabled());
    }

    public boolean isFavButtonDisabled() {
        return favButton.is(MVConditions.buttonHeaderExistsAndDisabled());
    }

    public boolean isCartButtonDisabled() {
        return cartButton.is(MVConditions.buttonHeaderExistsAndDisabled());
    }

    public boolean isCartButtonEnabled() {
        cartButtonShouldBeEnabled();
        return cartButton.is(MVConditions.buttonHeaderExistsAndEnabled());
    }


}
