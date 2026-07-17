package com.corescode.pvpcrosshair.client.color;

import com.corescode.pvpcrosshair.client.config.ConfigManager;
import com.corescode.pvpcrosshair.client.detection.TargetState;
import com.corescode.pvpcrosshair.client.util.ColorUtil;

public final class ColorResolver {

    private ColorResolver() {
    }

    public static int getColor(TargetState state) {

        return switch (state) {

            case IDLE -> ColorUtil.applyOpacity(
                    ConfigManager.idleColor(),
                    ConfigManager.idleOpacity()
            );

            case TARGET -> ColorUtil.applyOpacity(
                    ConfigManager.targetColor(),
                    ConfigManager.targetOpacity()
            );

            case SHIELD -> ColorUtil.applyOpacity(
                    ConfigManager.shieldColor(),
                    ConfigManager.shieldOpacity()
            );
        };
    }
}