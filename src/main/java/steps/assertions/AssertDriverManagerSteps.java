package steps.assertions;

import driver.DriverManager;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import steps.BaseSteps;

public class AssertDriverManagerSteps extends BaseSteps {

    @Step("Проверка: Адресная строка содержит \"{expectedUri}\"")
    public void assertThatUrlContains(String expected) {
        String message = "Адресная строка не содержит \"" + expected + "\" ";
        Assertions.assertTrue(DriverManager.getCurrentUrl().contains(expected), message);
    }

}
