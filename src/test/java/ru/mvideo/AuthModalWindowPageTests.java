package ru.mvideo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

public class AuthModalWindowPageTests extends BaseTest {

    @Test
    @DisplayName("Проверка модального окна авторизации клиента")
    public void authModalWindowTest() {
        headerMainPageSteps.clickLoginButton();
        assertAuthModalWindowPageSteps.assertThatAuthModalWindowIsVisible();
        assertAuthModalWindowPageSteps.assertThatCloseModalWindowButtonIsVisible();
        assertAuthModalWindowPageSteps.assertThatAuthModalWindowHeaderHave("Вход или регистрация");
        assertAuthModalWindowPageSteps.assertThatTelephoneInputFieldIsVisible();
        assertAuthModalWindowPageSteps.assertThatTelephoneInputPlaceholderHave("Телефон");
        assertAuthModalWindowPageSteps.assertThatContinueButtonIsVisible();
        assertAuthModalWindowPageSteps.assertThatContinueButtonIsDisabled();
        assertAuthModalWindowPageSteps.assertThatForJuridicalPersonsButtonIsVisibleAndEnabled();
    }
}
