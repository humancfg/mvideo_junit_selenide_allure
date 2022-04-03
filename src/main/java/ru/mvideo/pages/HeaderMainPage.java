package ru.mvideo.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.LogEvent;
import com.codeborne.selenide.logevents.LogEventListener;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static helpers.MVConditions.*;

public class HeaderMainPage {
    @FindBy(xpath = "//mvid-slide-panel")
    private SelenideElement tabsSidePanelBottom;
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
    @FindBy(xpath = "//mvid-header//span[contains(@class, 'location-text')]")
    private SelenideElement locationButton;

    public void tabsSidePanelBottomShouldBeVisible() {
        tabsSidePanelBottom
                .shouldBe(existAndVisible);
    }

    public void locationButtonHave(String expectedText) {
        locationButton.shouldHave(text(expectedText));
    }


    public void clickLocationButton() {
        locationButton.shouldBe(visible).click();
    }

    public void clickComparisonButton() {
        comparisonButton.shouldBe(buttonHeaderExistsAndEnabled).click();
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
                .shouldBe(buttonHeaderExistsAndEnabled).click();
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
                .shouldBe(buttonHeaderExistsAndEnabled);
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
        return inputSearchField.shouldBe(visible).is(existAndVisible);
    }

    public String getCartBubbleNumber() {
        return cartBubble.getText();
    }

    public void cartBubbleShouldHaveText(String expected) {
       cartBubble.shouldHave(text(expected));
    }

    public void clickCartButton() {
        cartButton.shouldBe(visible).click();
    }

    public void cartBubbleShouldHave(String number) {
        cartBubble.shouldHave(text(number));
    }

    public void cartButtonShouldBeEnabled() {
        cartButton.shouldBe(buttonHeaderExistsAndEnabled);
    }

    public boolean isStatusOrderButtonEnabled() {
        return statusOrderButton.is(buttonHeaderExistsAndEnabled);
    }

    public boolean isLoginButtonEnabled() {
        return loginButton.is(buttonHeaderExistsAndEnabled);
    }

    public boolean isComparisonButtonDisabled() {
        return comparisonButton.is(buttonHeaderExistsAndDisabled);
    }

    public void comparisonButtonShouldBeEnabled() {
        comparisonButton.shouldBe(buttonHeaderExistsAndEnabled);
    }

    public boolean isComparisonButtonEnabled() {
        return comparisonButton.is(buttonHeaderExistsAndEnabled);
    }

    public boolean isFavButtonDisabled() {
        return favButton.is(buttonHeaderExistsAndDisabled);
    }

    public boolean isCartButtonDisabled() {
        return cartButton.is(buttonHeaderExistsAndDisabled);
    }

    public boolean isCartButtonEnabled() {
        cartButtonShouldBeEnabled();
        return cartButton.is(buttonHeaderExistsAndEnabled);
    }


}
