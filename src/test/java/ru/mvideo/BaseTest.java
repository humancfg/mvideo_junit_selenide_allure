package ru.mvideo;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.ru.mvideo.MainPage;

import static properties.TestData.propsUrl;

public class BaseTest {
    MainPage mainPage;

    @BeforeEach
    public void beforeEach() {
        mainPage = new MainPage();
        Selenide.open(propsUrl.baseUrlMVideo());
//        Configuration.timeout = propsDriver.configurationTimeout();
    }

    @AfterEach
    public void afterEach() {
        Selenide.closeWebDriver();
    }
}
