package helpers;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.*;

public class MVConditions {
    /**
     * Если атрибут class не содержит disabled, значит кнопка кликабельна (активна)
     * @return condition
     */
    public static Condition buttonHeaderExistsAndEnabled() {
        return and("exist and enabled", exist,
                not(have(attribute("class", "disabled"))));
    }

    /**
     * Если атрибут class содержит disabled, значит кнопка не кликабельна (не активна)
     * @return condition
     */
    public static Condition buttonHeaderExistsAndDisabled() {
        return and("exist and disabled", exist,
                have(attribute("class", "disabled")));
    }

    public static Condition existAndVisible() {
        return and("exist and visible", exist, visible);
    }

    public static Condition existVisibleAndDisabled() {
        return and("exist and disabled", exist, visible, disabled);
    }

    public static Condition visibleAndEnabled() {
        return and("exist and disabled", visible, enabled);
    }
}
