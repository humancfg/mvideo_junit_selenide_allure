package pages.ru.mvideo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import helpers.Scroll;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static helpers.MVConditions.buttonHeaderExistsAndDisabled;
import static helpers.MVConditions.buttonHeaderExistsAndEnabled;

public class MainPage extends BasePage {

    private SelenideElement getTabBarButton(String buttonName) {
        ElementsCollection tabBarButtons = $$x("//mvid-tap-bar/descendant::mvid-header-icon");
        tabBarButtons = $$x("//mvid-tap-bar/descendant::mvid-header-icon");
        return tabBarButtons.find(Condition.text(buttonName));
    }

    public MainPage checkThatCartButtonDisabled(String buttonName, String... buttonNames) {

        if (buttonName == null) {
            Arrays.stream(buttonNames).forEach(button ->
                    getTabBarButton(button).shouldBe(buttonHeaderExistsAndDisabled)
            );
        } else {
            getTabBarButton(buttonName).shouldBe(buttonHeaderExistsAndEnabled);
        }

        return this;
    }

    public MainPage checkThatCartButtonEnabled(String buttonName, String... buttonNames) {

        if (buttonName == null) {
            Arrays.stream(buttonNames).forEach(button ->
                    getTabBarButton(button).shouldBe(buttonHeaderExistsAndEnabled)
            );
        } else {
            getTabBarButton(buttonName).shouldBe(buttonHeaderExistsAndEnabled);
        }

        return this;
    }

    public <T extends BasePage> T checkThatCartButtonEnabled(String buttonName, Class<T> pageObjectClass) {
        getTabBarButton(buttonName).shouldBe(buttonHeaderExistsAndEnabled);
        return page(pageObjectClass);
    }

    public MainPage checkThatButtonBubbleHaveNumber(String buttonName, String number) {
        By bubble = By.xpath(".//mvid-bubble");
        getTabBarButton(buttonName).find(bubble).shouldBe(visible).shouldHave(text(number));
        return this;
    }

    public <T extends BasePage> T clickButton(String buttonName, Class<T> pageObjectClass) {
        getTabBarButton(buttonName).click();
        return page(pageObjectClass);
    }

    public <T extends BasePage> T scrollEachBlock( Class<T> pageObjectClass) {
        $$x("//main//child::div[contains(@class, 'carousel')]").forEach(div -> {
            div.scrollIntoView(Scroll.center);
//            $x("//div[@class='skeleton']").shouldBe(disappear);
        });
        return page(pageObjectClass);
    }

    public DayProductsBlock getDayProductsBlock() {
        return page(DayProductsBlock.class);
    }

    public MostViewedBlock getMostViewedBlock() {
        return page(MostViewedBlock.class);
    }



    ////////////////////////////////////////////////

//    public void clickAddToCartOnFirstActiveButton() {
//        By activeAddToCartButtons = By.xpath(".//button[@title='Добавить в корзину']");
//        mostViewedBlock
//                .findAll(activeAddToCartButtons)
//                .get(0)
//                .click();
//    }
//
//    public boolean isMostViewedBlockVisible() {
//        return mostViewedBlock.is(MVConditions.existAndVisible());
//    }
//
//    public void scrollToMostViewed() {
//        mostViewedBlock.scrollIntoView("{block: \"center\"}");
//    }
//
//    public void scrollEachBlockOnPage() {
//        blocksCollection.forEach(block -> block.scrollIntoView("{block: \"center\"}"));
//    }
//
//    public boolean isDayProductsBlockVisible() {
//        return dayProductsBlock.is(MVConditions.existAndVisible());
//    }
//
//    public void dayProductsBlockShouldBeVisible() {
//        dayProductsBlock.shouldBe(visible);
//    }
//
//    public void clickAddToCartButtonOnMainDayProduct() {
//        mainDayProductAddToCartButton.click();
//    }
//
//    public void saveDayProductPrice() {
//        By mainProduct = By.xpath(".//mvid-day-product[contains(@class,'main')]");
//        By mainPrice = By.xpath(".//span[@class= 'price__main-value']");
//        dayProductPrice = dayProductsBlock
//                .find(mainProduct)
//                .find(mainPrice)
//                .getText()
//                .replaceAll("\\s+", "");
//    }
//
//    public void saveDayProductName() {
//        By mainProduct = By.xpath(".//mvid-day-product[contains(@class,'main')]");
//        By mainTitle = By.xpath(".//div[contains(@class, 'title')]/a");
//        dayProductName = dayProductsBlock
//                .find(mainProduct)
//                .find(mainTitle)
//                .getText()
//                .trim();
//    }
//
//    public void collectDayProductsMap() {
//        collectDayProductsNamesList();
//        collectDayProductsPricesList();
//        for (String name : dayProductsNamesList) {
//            for (Integer price : dayProductsPricesList) {
//                dayProductsMap.put(name, price);
//            }
//        }
//    }
//
//    public void collectDayProductsNamesList() {
//        By dayProductsNames = By.xpath(".//div[contains(@class, 'title')]/a");
//        dayProductsNamesList = dayProductsBlock.findAll(dayProductsNames)
//                .stream()
//                .map(element -> element.shouldBe(visible)
//                        .getText()
//                        .trim())
//                .collect(Collectors.toList());
//    }
//
//
//    public void collectDayProductsPricesList() {
//        By dayProductsPrices = By.xpath(".//mvid-day-product//span[@class='price__main-value']");
//        dayProductsPricesList = dayProductsBlock
//                .findAll(dayProductsPrices)
//                .stream()
//                .map(element -> element.shouldBe(visible)
//                        .getText()
//                        .replaceAll("\\s", ""))
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//    }
//
//    public void collectMostViewedProductsMap() {
//        collectMostViewedNamesList();
//        collectMostViewedPricesList();
//        for (String name : mostViewedNamesList) {
//            for (Integer price : mostViewedPricesList) {
//                mostViewedProductsMap.put(name, price);
//            }
//        }
//    }
//
//    public void collectMostViewedNamesList() {
//        By mostViewedNames = By.xpath(".//a/div[text()]");
//        mostViewedNamesList = mostViewedBlock
//                .findAll(mostViewedNames)
//                .stream()
//                .map(element -> element.shouldBe(exist)
//                        .getText())
//                .collect(Collectors.toList());
//    }
//
//    public void collectMostViewedPricesList() {
//        By mostViewedPrices = By.xpath(".//mvid-price-2//span[@class='price__main-value']");
//        mostViewedPricesList = mostViewedBlock
//                .findAll(mostViewedPrices)
//                .stream()
//                .map(element -> element.getText().replaceAll("\\s+", "")
//                        .trim())
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//    }
}
