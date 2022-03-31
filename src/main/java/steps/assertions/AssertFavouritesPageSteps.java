package steps.assertions;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import steps.BaseSteps;

public class AssertFavouritesPageSteps extends BaseSteps {

    @Step("Проверка: Отображается заголовок \"{expectedTitleName}\"")
    public void assertThatFavPageTitleContains(String expectedTitleName) {
        String message = " Не отображается заголовок \"{expectedTitleName}\"";
        String actualTitle =favouritesPage.getFavTitleHeaderText();

        Assertions.assertTrue(actualTitle.contains(expectedTitleName), message);
    }
}
