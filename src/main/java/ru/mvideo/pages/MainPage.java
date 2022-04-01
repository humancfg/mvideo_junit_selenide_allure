package ru.mvideo.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import helpers.MVConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;

public class MainPage {
    @FindBy(xpath = "//mvid-day-products-block")
    private SelenideElement dayProductsBlock;
    @FindBy(xpath = "//mvid-day-product[contains(@class,'main')]//span[normalize-space(text())='В корзину']/ancestor::button")
    private SelenideElement mainDayProductAddToCartButton;
    @FindBy(xpath = "//h2[text()='Самые просматриваемые']/ancestor::mvid-simple-product-collection")
    private SelenideElement mostViewedBlock;
    @FindBy(xpath = "//mvid-simple-product-collection")
    private ElementsCollection blocksCollection;



    public static Map<String, Integer> mostViewedProductsMap = new LinkedHashMap<>();
    public static List<String> mostViewedNamesList = new LinkedList<>();
    public static List<Integer> mostViewedPricesList = new LinkedList<>();

    public static Map<String, Integer> dayProductsMap = new LinkedHashMap<>();
    public static List<String> dayProductsNamesList = new LinkedList<>();
    public static List<Integer> dayProductsPricesList = new LinkedList<>();

    public static String dayProductName;
    public static String dayProductPrice;

    int clickCounter;

    public void clickAddToCartOnFirstActiveButton() {
        By activeAddToCartButtons = By.xpath(".//button[@title='Добавить в корзину']");
        mostViewedBlock
                .findAll(activeAddToCartButtons)
                .get(0)
                .click();
    }

    public boolean isMostViewedBlockVisible() {
        return mostViewedBlock.is(MVConditions.existAndVisible());
    }

    public void scrollToMostViewed() {
        mostViewedBlock.scrollIntoView("{block: \"center\"}");
    }

    public void scrollEachBlockOnPage() {
        blocksCollection.forEach(block -> block.scrollIntoView("{block: \"center\"}"));
    }

    public boolean isDayProductsBlockVisible() {
        return dayProductsBlock.is(MVConditions.existAndVisible());
    }

    public void dayProductsBlockShouldBeVisible() {
        dayProductsBlock.shouldBe(visible);
    }

    public void clickAddToCartButtonOnMainDayProduct() {
        mainDayProductAddToCartButton.click();
    }

    public void saveDayProductPrice() {
        By mainProduct = By.xpath(".//mvid-day-product[contains(@class,'main')]");
        By mainPrice = By.xpath(".//span[@class= 'price__main-value']");
        dayProductPrice = dayProductsBlock
                .find(mainProduct)
                .find(mainPrice)
                .getText()
                .replaceAll("\\s+", "");
    }

    public void saveDayProductName() {
        By mainProduct = By.xpath(".//mvid-day-product[contains(@class,'main')]");
        By mainTitle = By.xpath(".//div[contains(@class, 'title')]/a");
        dayProductName = dayProductsBlock
                .find(mainProduct)
                .find(mainTitle)
                .getText()
                .trim();
    }

    public void collectDayProductsMap() {
        collectDayProductsNamesList();
        collectDayProductsPricesList();
        for (String name : dayProductsNamesList) {
            for (Integer price : dayProductsPricesList) {
                dayProductsMap.put(name, price);
            }
        }
    }

    public void collectDayProductsNamesList() {
        By dayProductsNames = By.xpath(".//div[contains(@class, 'title')]/a");
        dayProductsNamesList = dayProductsBlock.findAll(dayProductsNames)
                .stream()
                .map(element -> element.shouldBe(visible)
                        .getText()
                        .trim())
                .collect(Collectors.toList());
    }


    public void collectDayProductsPricesList() {
        By dayProductsPrices = By.xpath(".//mvid-day-product//span[@class='price__main-value']");
        dayProductsPricesList = dayProductsBlock
                .findAll(dayProductsPrices)
                .stream()
                .map(element -> element.shouldBe(visible)
                        .getText()
                        .replaceAll("\\s", ""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void collectMostViewedProductsMap() {
        collectMostViewedNamesList();
        collectMostViewedPricesList();
        for (String name : mostViewedNamesList) {
            for (Integer price : mostViewedPricesList) {
                mostViewedProductsMap.put(name, price);
            }
        }
    }

    public void collectMostViewedNamesList() {
        By mostViewedNames = By.xpath(".//a/div[text()]");
        mostViewedNamesList = mostViewedBlock
                .findAll(mostViewedNames)
                .stream()
                .map(element -> element.shouldBe(exist)
                        .getText())
                .collect(Collectors.toList());
    }

    public void collectMostViewedPricesList() {
        By mostViewedPrices = By.xpath(".//mvid-price-2//span[@class='price__main-value']");
        mostViewedPricesList = mostViewedBlock
                .findAll(mostViewedPrices)
                .stream()
                .map(element -> element.getText().replaceAll("\\s+", "")
                        .trim())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
