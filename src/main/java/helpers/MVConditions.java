package helpers;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.*;

public class MVConditions {
    /**
     * Если атрибут class не содержит disabled, значит кнопка кликабельна (активна)
     */
    public static Condition buttonHeaderExistsAndEnabled = and("exist and enabled", exist,
                not(have(attribute("class", "disabled"))));

    /**
     * Если атрибут class содержит disabled, значит кнопка не кликабельна (не активна)
     */
    public static Condition buttonHeaderExistsAndDisabled = and("exist and disabled", exist,
                have(attribute("class", "disabled")));

    public static Condition existAndVisible = and("exist and visible", exist, visible);

    public static Condition existVisibleAndDisabled = and("exist and disabled", exist, visible, disabled);

    public static Condition visibleAndEnabled = and("exist and disabled", visible, enabled);
}
