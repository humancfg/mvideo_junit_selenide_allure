package ru.mvideo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@Order(7)
public class CityModalTests extends BaseTest {
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
