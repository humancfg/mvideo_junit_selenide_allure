package ru.mvideo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;

public class CityModal {
    @FindBy(xpath = "//mvid-modal")
    private SelenideElement modalWindow;

    public void checkThatModalVisible() {
        modalWindow
                .shouldBe(Condition.visible);
    }

    public void checkThatModalWindowHaveTitle(String expectedText) {
        modalWindow.find(".modal-layout__title")
                .shouldHave(text(expectedText));
    }

    public void clickOnCityInLIst(String cityName){
        modalWindow
                .findAll(".location-select__location")
                .find(text(cityName)).click();
    }

    public void checkThatModalDisappear() {
        modalWindow
                .shouldBe(Condition.disappear);
    }
}
