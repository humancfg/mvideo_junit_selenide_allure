package steps.assertions;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import steps.BaseSteps;

public class AssertComparisonWidgetDiscountsSteps extends BaseSteps {

    @Step("Проверка: Отображается виджет со скидками")
    public void comparisonWidgetDiscountsIsVisible() {
        String message = "Не отображается виджет со скидками";
        Assertions.assertTrue(comparisonWidgetDiscounts.isWidgetVisible(), message);
    }
}
