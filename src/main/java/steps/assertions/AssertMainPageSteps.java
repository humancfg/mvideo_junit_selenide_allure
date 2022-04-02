package steps.assertions;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import ru.mvideo.pages.MainPage;
import steps.BaseSteps;

public class AssertMainPageSteps extends BaseSteps {
    private MainPage mainPage = Selenide.page(new MainPage());

    @Step("Проверка: На странице отображается блок \"Товары дня\"")
    public void assertThatDayProductsBlockIsVisible() {
        String message = "На странице не отображается блок \"Товары дня\"";
        Assertions.assertTrue(mainPage.isDayProductsBlockVisible(), message);
    }

    @Step("Проверка: На странице отображается блок \"Самые просматриваемые\"")
    public void assertThatMostViewedBlockIsVisible() {
        mainPage.scrollEachBlockOnPage();
        mainPage.scrollToMostViewed();
        String message = "На странице не отображается блок \"Самые просматриваемые\"";
        Assertions.assertTrue(mainPage.isMostViewedBlockVisible(), message);
    }

}
