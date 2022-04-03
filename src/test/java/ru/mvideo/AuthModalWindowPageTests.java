package ru.mvideo;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Order(4)
@DisplayName("Модальное окно авторизации")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
