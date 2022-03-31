package ru.mvideo.pages;

import com.codeborne.selenide.SelenideElement;
import helpers.MVConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class AuthModalWindowPage {
    @FindBy(xpath = "//div[contains(@class, 'modal-layout--without-title')]")
    private SelenideElement authModalWindowBlock;
    @FindBy(xpath = "//button/mvid-icon[@type='close']")
    private SelenideElement closeAuthModalButton;
    @FindBy(xpath = "//mvid-login-form//h2[contains(@class, 'login-form__header')]")
    private SelenideElement authModalTitle;
    @FindBy(xpath = "//input[@type='tel']")
    private SelenideElement telephoneInputField;
    @FindBy(xpath = "//mvid-login-form//button[@type='submit']")
    private SelenideElement continueButton;
    @FindBy(xpath = "//mvid-login-form//button[contains(@class, 'login-form__link')]")
    private SelenideElement forJuridicalPersonsButton;


    public boolean isForJuridicalPersonsButtonHave(String text) {
        return forJuridicalPersonsButton.getText().contains(text);
    }

    public boolean isForJuridicalPersonsButtonVisibleAndEnabled() {
        return forJuridicalPersonsButton.is(MVConditions.visibleAndEnabled());
    }

    public boolean isForJuridicalPersonsButtonVisible() {
        return forJuridicalPersonsButton.is(MVConditions.existAndVisible());
    }

    public boolean isContinueButtonVisible() {
        return continueButton.is(MVConditions.existAndVisible());
    }

    public boolean isContinueButtonDisabled() {
        return continueButton.is(MVConditions.existVisibleAndDisabled());
    }

    public void authModalWindowShouldBeVisible() {
        authModalWindowBlock
                .shouldBe(MVConditions.existAndVisible());
    }

    // кнопка закрытия модального окна видна?
    public boolean isCloseAuthModalWindowButtonVisible() {
        return closeAuthModalButton
                .is(MVConditions.existAndVisible());
    }

    public boolean isAuthModalWindowVisible() {
        return authModalTitle.is(MVConditions.existAndVisible());
    }

    public boolean isAuthModalWindowHeaderHave(String header) {
        return authModalTitle
                .getText()
                .trim()
                .equals(header);
    }

    public boolean isTelephoneInputFieldHave(String placeholderName) {
        By placeholderTelephone = By.xpath("./following-sibling::div//span");
        return telephoneInputField
                .find(placeholderTelephone)
                .getText()
                .equals(placeholderName);
    }

    public boolean isTelephoneInputFieldVisible() {
        return telephoneInputField.is(MVConditions.existAndVisible());
    }
}
