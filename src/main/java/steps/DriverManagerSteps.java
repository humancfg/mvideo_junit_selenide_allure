package steps;

import driver.DriverManager;
import io.qameta.allure.Step;

public class DriverManagerSteps {

    @Step("Открыть ссылку {url}")
    public static void openUrl(String url) {
        DriverManager.openUrl(url);
    }
}
