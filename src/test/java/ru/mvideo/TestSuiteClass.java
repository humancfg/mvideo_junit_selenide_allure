package ru.mvideo;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({
        HeaderMainPageTests.class,
        CartPageTests.class,
        ProductListPageTests.class,
        AuthModalWindowPageTests.class,
        ProductComparisonPageTests.class,
        FavouritesPageTests.class,
})
public class TestSuiteClass {
}
