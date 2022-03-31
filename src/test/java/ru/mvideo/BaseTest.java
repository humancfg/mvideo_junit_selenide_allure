package ru.mvideo;

import driver.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import steps.*;
import steps.assertions.*;

public class BaseTest {
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

    @BeforeEach
    public void beforeEach() {
        DriverManagerSteps.openUrl("https://www.mvideo.ru");

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
