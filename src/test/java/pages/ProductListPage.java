package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.LinkedList;
import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static helpers.MVConditions.existAndVisible;
import static helpers.Scroll.center;
import static helpers.Scroll.end;

public class ProductListPage {
    @FindBy(xpath = "//div[contains(@class, 'product-cards-row')]//a[contains(@class, 'product-title__text')]")
    private ElementsCollection productsNames;
    @FindBy(xpath = "//mvid-product-list-controls//div[@class='dropdown__title']/span")
    private SelenideElement variationSortButton;
    @FindBy(xpath = "//mvid-product-list-controls//div[contains(@class, 'dropdown open')]")
    private SelenideElement variationSortDropDown;
    @FindBy(xpath = "//mvid-product-list-controls//div[@class='dropdown__options']/descendant::div")
    private ElementsCollection variationSortDropDownList;
    @FindBy(xpath = "//mvid-product-cards-row//mvid-price")
    private ElementsCollection productCardsPrices;
    @FindBy(xpath = "//div[@class='skeleton']")
    private SelenideElement skeletonLoader;
    @FindBy(xpath = "//main//child::div[contains(@class, 'carousel')]")
    private ElementsCollection carousels;
    @FindBy(xpath = "//mvid-promo-configurator")
    private SelenideElement promoConfigurator;
    @FindBy(xpath = "//mvid-product-cards-row//button[@title='Добавить в сравнение']")
    private SelenideElement firstComparisonButton;
    @FindBy(xpath = "//mvid-product-cards-row//button[@title='Добавить в избранное']/mvid-icon[@type='love']")
    private ElementsCollection favButtons;
    @FindBy(xpath = "//mvid-product-cards-row/child::div")
    private ElementsCollection productCardsRows;
    @FindBy(xpath = "//mvid-header-icon-tooltip")

    public static List<Integer> productPricesList = new LinkedList<>();
    public static List<SelenideElement> productsFavButtonsList = new LinkedList<>();

    public void collectFavButtons() {
        productsFavButtonsList.addAll(favButtons);

    }

    public void clickAddToToFavButtonBy(int index) {
        if (productsFavButtonsList != null) {
            productsFavButtonsList.get(index).scrollIntoView(center).click();
        }
    }


    public void clickComparisonButtonOnFirstVisibleProduct() {
        firstComparisonButton
                .scrollIntoView(center)
                .shouldBe(visible)
                .click();
    }

    public void skeletonLoaderShouldBeDisappear() {
        skeletonLoader.shouldBe(Condition.disappear);
    }

    public void saveToListProductsPricesSearchResults() {
        $$x("//mvid-product-cards-row/child::div")
                .forEach(row -> {
                    row.shouldBe(visible)
                            .scrollIntoView(center)
                            .findAll(By.xpath(".//mvid-price"))
                            .forEach(price -> {
                                productPricesList.add(
                                        Integer.parseInt(price
                                                .shouldBe(visible)
                                                .getText()
                                                .replaceAll("\\D", "")));
                            });
                });
    }

    public void clickOnVariationSortDropDownElement(String elementName) {
        variationSortDropDownList.stream()
                .filter(element ->
                        element.getText()
                                .contains(elementName))
                .findFirst()
                .get()
                .click();
    }

    public boolean isVariationSortDropDownListContains(String text) {
        return variationSortDropDownList.stream()
                .anyMatch(element ->
                        element.getText()
                                .contains(text));
    }

    public void variationSortDropDownShouldBeVisible() {
        variationSortDropDown.shouldBe(existAndVisible);
    }

    public void clickVariationSortButton() {
        variationSortButton
                .scrollIntoView(end)
                .click();
    }

    public boolean isEachNameInSearchResultContains(String word) {
        return productsNames.stream()
                .allMatch(productName ->
                        productName.getText()
                                .toLowerCase()
                                .contains(word));
    }



    // подгружает каждый элемент
    public void scrollEachProductName() {
        productsNames.forEach(element ->
                element.shouldBe(visible)
                        .scrollIntoView(center));
    }

    // скролит в самый низ страницы, полезно перед тем как подгружать каждый элемент
    public void scrollToPromoConfiguratorBlock() {
        promoConfigurator
                .shouldBe(exist)
                .scrollIntoView(center);
    }

    public void scrollEachCarousel() {
        carousels.forEach(carousel-> carousel.scrollIntoView(center).shouldBe(visible));
    }


    public void productsNamesShouldBeVisible() {
        productsNames.forEach(element ->
                element.shouldBe(existAndVisible));
    }


}
