package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static helpers.MVConditions.existAndVisible;

public class ProductComparisonPage {
    @FindBy(xpath = "//div[@class='c-compare-head-title']/h1")
    private SelenideElement comparisonTitle;

    public boolean comparisonTitleIsVisible() {
        return comparisonTitle.is(existAndVisible);
    }

    public void comparisonTitleShouldBeVisible() {
        comparisonTitle.shouldBe(Condition.visible);
    }

    public String getComparisonTitleText() {
        return comparisonTitle.getText().trim();
    }
}
