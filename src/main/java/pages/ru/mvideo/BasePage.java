package pages.ru.mvideo;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;
import static helpers.MVConditions.buttonHeaderExistsAndEnabled;
import static properties.TestData.propsUrl;

public abstract class BasePage {

    SelenideElement headerAddToCartBubble = $x("//mvid-header-icon[@title='Корзина']//mvid-bubble");

    public BasePage checkThatUrlContains(String uri) {
        webdriver().shouldHave(currentFrameUrl(propsUrl.baseUrlMVideo() + uri));
        return this;
    }

    public <T extends BasePage> T checkThatHeaderButtonEnabled(String buttonName, Class<T> pageObjectClass) {
        ElementsCollection tabBarButtons = $$x("//mvid-tap-bar/descendant::mvid-header-icon");
        tabBarButtons = $$x("//mvid-tap-bar/descendant::mvid-header-icon");
        tabBarButtons.find(text(buttonName)).shouldBe(buttonHeaderExistsAndEnabled);
        return page(pageObjectClass);
    }

    public <T extends BasePage> T checkThatHeaderButtonBubbleHave(String bubbleNumber, String buttonName, Class<T> pageObjectClass) {
        SelenideElement tabBarButtonBubble = $x("//mvid-header-icon[@title='" + buttonName + "']//mvid-bubble");

        tabBarButtonBubble.shouldHave(text(bubbleNumber));
        return page(pageObjectClass);
    }

}
