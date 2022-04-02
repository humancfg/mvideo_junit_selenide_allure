package ru.mvideo;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ru.mvideo.pages.CityModal;

@Order(7)
@DisplayName("Модальное окно выбора локации")
public class CityModalTests extends BaseTest {
    private CityModal cityModal = Selenide.page(new CityModal());

    @Test
    @Order(1)
    @DisplayName("Проверка изменения города")
    public void chooseCityTest() {
        headerMainPage.clickLocationButton();
        cityModal.checkThatModalVisible();
        cityModal.checkThatModalWindowHaveTitle("Выберите город");
        cityModal.clickOnCityInLIst("Краснодар");
        cityModal.checkThatModalDisappear();
        headerMainPage.locationButtonHave("Краснодар");
    }
}
