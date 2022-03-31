package ru.mvideo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class FavouritesPage {

    @FindBy(xpath = "//h1[@class='wishlist-title']")
    private SelenideElement favTitle;

    public void favTitleShouldBeVisible() {
        favTitle.shouldBe(Condition.visible);
    }

    public String getFavTitleHeaderText() {
        return favTitle.getText();
    }
}
