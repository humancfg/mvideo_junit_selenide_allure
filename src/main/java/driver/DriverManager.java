package driver;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

public class DriverManager {

    public static void openUrl(String url) {
        Selenide.open(url);
    }

    public static String getCurrentUrl() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }



    public static void closeDriver() {
        Selenide.closeWebDriver();
    }
}
