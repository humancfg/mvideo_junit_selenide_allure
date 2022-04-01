package assertions;

import helpers.MVCollections;
import org.junit.jupiter.api.Assertions;

public class MVAssertions {

    public static void assertThatMapsAreEquals () {
        Assertions.assertEquals(MVCollections.dayProductsCollection, MVCollections.cartPageProductsCollection);
    }
}
