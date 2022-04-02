package ru.mvideo.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.disappear;
import static helpers.MVConditions.existAndVisible;

public class ComparisonWidgetDiscounts{
    @FindBy(xpath = "//section[@class='widget js-widget']")
    private SelenideElement widgetDiscounts;
    @FindBy(xpath = "")
    private SelenideElement widgetCloseButton;

    public boolean isWidgetVisible() {
        return widgetDiscounts.is(existAndVisible);
    }

    public void widgetDiscountsShouldBeDisappear() {
        widgetDiscounts.shouldBe(disappear);
    }
}
