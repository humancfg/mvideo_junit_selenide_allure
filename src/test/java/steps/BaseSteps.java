package steps;

import com.codeborne.selenide.Selenide;
import pages.*;

public class BaseSteps {
    protected HeaderMainPage headerMainPage = Selenide.page(new HeaderMainPage());
    protected CartPage cartPage = Selenide.page(new CartPage());
    protected ProductListPage productListPage = Selenide.page(new ProductListPage());
    protected AuthModalWindowPage authModalWindowPage = Selenide.page(new AuthModalWindowPage());
    protected ProductComparisonPage productComparisonPage = Selenide.page(new ProductComparisonPage());
    protected ComparisonWidgetDiscounts comparisonWidgetDiscounts = Selenide.page(new ComparisonWidgetDiscounts());
    protected FavouritesPage favouritesPage = Selenide.page(new FavouritesPage());
}
