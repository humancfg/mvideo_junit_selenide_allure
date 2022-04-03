package driver;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    public static void openUrl(String url) {
        Selenide.open(url);
    }

    public static String getCurrentUrl() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    public static WebDriver getCurrentDriver() {
        return WebDriverRunner.getWebDriver();
    }

    public static void closeDriver() {
        Selenide.closeWebDriver();
    }
}
