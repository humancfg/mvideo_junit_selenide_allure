package steps.assertions;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import steps.BaseSteps;

public class AssertAuthModalWindowPageSteps extends BaseSteps {

    @Step("Проверка: Отображается модальное окно")
    public void assertThatAuthModalWindowIsVisible() {
        String message = "Не отображается модальное окно";
        Assertions.assertTrue(authModalWindowPage.isAuthModalWindowVisible(), message);
    }

    @Step("Проверка: У модального окна присутствует заголовок  с текстом \"{expectedHeaderText}\"")
    public void assertThatAuthModalWindowHeaderHave(String expectedHeaderText) {
        String message = "Не отображается модальное окно с заголовком " + expectedHeaderText;
        Assertions.assertTrue(authModalWindowPage.isAuthModalWindowHeaderHave(expectedHeaderText), message);
    }

    @Step("Проверка: Отображается кнопка закрытия модального окна")
    public void assertThatCloseModalWindowButtonIsVisible() {
        String message = "Не отображается кнопка закрытия модального окна";
        Assertions.assertTrue(authModalWindowPage.isCloseAuthModalWindowButtonVisible(), message);
    }

    @Step("Проверка: Отображается поле для ввода текста")
    public void assertThatTelephoneInputFieldIsVisible() {
        String message = "Не отображается поле для ввода текста";
        Assertions.assertTrue(authModalWindowPage.isTelephoneInputFieldVisible(), message);
    }

    @Step("Проверка: Отображается плейсхолдер \"{expectedPlaceholder}\"")
    public void assertThatTelephoneInputPlaceholderHave(String expectedPlaceholder) {
        String message = "Не отображается плейсхолдер \"" + expectedPlaceholder + "\" у поля \"Телефон\"";
        Assertions.assertTrue(authModalWindowPage.isTelephoneInputFieldHave(expectedPlaceholder), message);
    }

    @Step("Проверка: Отображается кнопка \"Продолжить\"")
    public void assertThatContinueButtonIsVisible() {
        String message = "Не отображается кнопка \"Продолжить\"";
        Assertions.assertTrue(authModalWindowPage.isContinueButtonVisible(), message);
    }

    @Step("Проверка: Кнопка \"Продолжить\" не активная")
    public void assertThatContinueButtonIsDisabled() {
        String message = "Кнопка \"Продолжить\" активная";
        Assertions.assertTrue(authModalWindowPage.isContinueButtonDisabled(), message);
    }

    @Step("Проверка:Отображается ссылка \"Для юридических лиц\"")
    public void assertThatForJuridicalPersonsButtonIsVisibleAndEnabled() {
        String message = "Кнопка \"Продолжить\" активная";
        Assertions.assertTrue(authModalWindowPage.isForJuridicalPersonsButtonVisibleAndEnabled(), message);
    }
}
