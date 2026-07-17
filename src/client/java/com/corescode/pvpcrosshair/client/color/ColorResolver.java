package com.corescode.pvpcrosshair.client.color;

import com.corescode.pvpcrosshair.client.detection.TargetState;
import com.corescode.pvpcrosshair.client.util.ColorUtil;

public final class ColorResolver {

    /*
     * Base Colors
     */
    private static final int DEFAULT_COLOR = 0xFFFFFFFF;

    private static final int TARGET_COLOR = 0xFF00FF00;

    private static final int SHIELD_COLOR = 0xFFFF0000;

    /*
     * Default Opacity
     *
     * These will later come from ConfigManager.
     */
    private static final int IDLE_OPACITY = 60;

    private static final int TARGET_OPACITY = 100;

    private static final int SHIELD_OPACITY = 100;

    private ColorResolver() {
    }

    public static int getColor(TargetState state) {

        return switch (state) {

            case IDLE -> ColorUtil.applyOpacity(
                    DEFAULT_COLOR,
                    IDLE_OPACITY
            );

            case TARGET -> ColorUtil.applyOpacity(
                    TARGET_COLOR,
                    TARGET_OPACITY
            );

            case SHIELD -> ColorUtil.applyOpacity(
                    SHIELD_COLOR,
                    SHIELD_OPACITY
            );
        };
    }
}