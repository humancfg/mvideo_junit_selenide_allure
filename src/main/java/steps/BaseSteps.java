package steps;

import com.codeborne.selenide.Selenide;
import ru.mvideo.pages.*;

public class BaseSteps {
    protected HeaderMainPage headerMainPage = Selenide.page(new HeaderMainPage());
    protected MainPage mainPage = Selenide.page(new MainPage());
    protected CartPage cartPage = Selenide.page(new CartPage());
    protected ProductListPage productListPage = Selenide.page(new ProductListPage());
    protected AuthModalWindowPage authModalWindowPage = Selenide.page(new AuthModalWindowPage());
    protected ProductComparisonPage productComparisonPage = Selenide.page(new ProductComparisonPage());
    protected ComparisonWidgetDiscounts comparisonWidgetDiscounts = Selenide.page(new ComparisonWidgetDiscounts());
    protected FavouritesPage favouritesPage = Selenide.page(new FavouritesPage());
}
