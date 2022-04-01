package helpers;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import java.util.*;

import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MVCollections {

    public static final String NAME = "NAME";
    public static final String PRICE = "PRICE";
    public static final String ADD_TO_CART_BUTTON = "ADD_TO_CART_BUTTON";
    public static final String ADD_TO_FAVOURITES_BUTTON = "ADD_TO_FAVOURITES_BUTTON";
    public static final String ADD_TO_COMPARISON_BUTTON = "ADD_TO_COMPARISON_BUTTON";

    public static Map<String, String> dayProductsCollection = new LinkedHashMap<>();
    public static Map<String, String> cartPageProductsCollection = new LinkedHashMap<>();

    public static List<Map<String, Object>> mostViewedProductsCollection = new LinkedList<>();

    public static void collectDayProductsInfoToMap(ElementsCollection names, ElementsCollection prices) {
        Assertions.assertAll(
                () -> assertNotNull(names),
                () -> assertNotNull(prices)
        );

        List<SelenideElement> visibleNames = collectVisible(names);
        List<SelenideElement> visiblePrices = collectVisible(prices);

        for (SelenideElement name : visibleNames) {
            for (SelenideElement price : visiblePrices) {
                dayProductsCollection.put(
                        name.getText(),
                        price.getText()
                                .replaceAll("\\s+", "")
                );
            }
        }

//        names.forEach(name ->
//                prices.forEach(price ->
//                        dayProductsCollection.put(
//                                name.getText().trim(),
//                                price.getText().replaceAll("\\s+", "")
//                        )
//                )
//        );
    }

    private static List<SelenideElement> collectVisible(ElementsCollection elements) {
        assertNotNull(elements);

        List<SelenideElement> temp = new ArrayList<>();

        for (SelenideElement ele : elements) {
            if (ele.is(visible)) {
                temp.add(ele);
            }
        }

        return temp;
    }

    public static void collectCartPageProductsInfoToMap(ElementsCollection names, ElementsCollection prices) {

        Assertions.assertAll(
                () -> assertNotNull(names),
                () -> assertNotNull(prices)
        );

        for (SelenideElement name : names) {
            for (SelenideElement price : prices) {
                cartPageProductsCollection.put(
                        name.getText()
                                .replaceAll("[\\u00A0\\s]+", " ")
                                .trim(),
                        price.getText()
                                .replaceAll("[\\u00A0\\s]+", "")
                                .replaceAll("\\s+", "")
                                .replace('¤', ' ')
                                .trim()
                );
            }
        }
    }

    public static void collectMostViewedProductsInfoToMap(ElementsCollection names, ElementsCollection prices,
                                                          ElementsCollection addToCartButtons,
                                                          ElementsCollection addToFavouritesButtons,
                                                          ElementsCollection addToComparisonButtons) {
        Assertions.assertAll(
                () -> assertNotNull(names),
                () -> assertNotNull(prices),
                () -> assertNotNull(addToCartButtons),
                () -> assertNotNull(addToFavouritesButtons),
                () -> assertNotNull(addToComparisonButtons)
        );

        for (int i = 0; i < names.size(); i++) {
            mostViewedProductsCollection.add(
                    Map.of(
                            NAME, names
                                    .get(i)
                                    .getText(),
                            PRICE, prices
                                    .get(i)
                                    .getText()
                                    .replaceAll("\\s+", "")
                                    .trim(),
                            ADD_TO_CART_BUTTON, addToCartButtons.get(i),
                            ADD_TO_FAVOURITES_BUTTON, addToFavouritesButtons.get(i),
                            ADD_TO_COMPARISON_BUTTON, addToComparisonButtons.get(i)
                    )
            );
        }
    }
}
