package steps.assertions;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import steps.BaseSteps;

public class AssertProductComparisonPageSteps extends BaseSteps {

    @Step("Проверка: Отображается заголовок \"{expectedTitleName}\"")
    public void assertThatComparisonPageTitleContains(String expectedTitleName) {
        String message = " Не отображается заголовок \"{expectedTitleName}\"";
        String actualTitle = productComparisonPage.getComparisonTitleText();
        Assertions.assertTrue(actualTitle.contains(expectedTitleName), message);
    }
}
