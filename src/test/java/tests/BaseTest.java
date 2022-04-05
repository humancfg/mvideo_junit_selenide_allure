package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import driver.DriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.HeaderMainPage;
import steps.*;
import steps.assertions.*;

public class BaseTest {

    HeaderMainPage headerMainPage;

    MainPageSteps mainPageSteps;
    HeaderMainPageSteps headerMainPageSteps;
    ProductListPageSteps productListPageSteps;
    ProductComparisonPageSteps productComparisonPageSteps;

    AssertMainPageSteps assertMainPageSteps;
    AssertCartPageSteps assertCartPageSteps;
    AssertDriverManagerSteps assertDriverManagerSteps;
    AssertHeaderMainPageSteps assertHeaderMainPageSteps;
    AssertFavouritesPageSteps assertFavouritesPageSteps;
    AssertProductListPageSteps assertProductListPageSteps;
    AssertAuthModalWindowPageSteps assertAuthModalWindowPageSteps;
    AssertProductComparisonPageSteps assertProductComparisonPageSteps;
    AssertComparisonWidgetDiscountsSteps assertComparisonWidgetDiscountsSteps;

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
                .includeSelenideSteps(true));
    }

    @BeforeEach
    public void beforeEach() {
        DriverManagerSteps.openUrl("https://www.mvideo.ru");

        headerMainPage = Selenide.page(new HeaderMainPage());
        mainPageSteps = new MainPageSteps();
        headerMainPageSteps = new HeaderMainPageSteps();
        productListPageSteps = new ProductListPageSteps();
        productComparisonPageSteps = new ProductComparisonPageSteps();

        assertMainPageSteps = new AssertMainPageSteps();
        assertCartPageSteps = new AssertCartPageSteps();
        assertDriverManagerSteps = new AssertDriverManagerSteps();
        assertHeaderMainPageSteps = new AssertHeaderMainPageSteps();
        assertFavouritesPageSteps = new AssertFavouritesPageSteps();
        assertProductListPageSteps = new AssertProductListPageSteps();
        assertAuthModalWindowPageSteps = new AssertAuthModalWindowPageSteps();
        assertProductComparisonPageSteps = new AssertProductComparisonPageSteps();
        assertComparisonWidgetDiscountsSteps = new AssertComparisonWidgetDiscountsSteps();
    }

    @AfterEach
    public void afterEach() {
        DriverManager.closeDriver();
    }
}
