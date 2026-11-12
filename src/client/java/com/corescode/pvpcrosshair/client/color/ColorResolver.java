package com.corescode.pvpcrosshair.client.color;

import com.corescode.pvpcrosshair.client.config.ConfigManager;
import com.corescode.pvpcrosshair.client.detection.TargetState;

public final class ColorResolver {

    private ColorResolver() {
    }

    public static int getColor(TargetState state) {

        return switch (state) {

            case IDLE -> applyOpacity(
                    ConfigManager.idleColor(),
                    ConfigManager.idleOpacity()
            );

            case TARGET -> applyOpacity(
                    ConfigManager.targetColor(),
                    ConfigManager.targetOpacity()
            );

            case SHIELD -> applyOpacity(
                    ConfigManager.shieldColor(),
                    ConfigManager.shieldOpacity()
            );
        };
    }

    private static int applyOpacity(int color, int opacityPercent) {

        opacityPercent = Math.max(0, Math.min(100, opacityPercent));

        int alpha = Math.round(opacityPercent * 255F / 100F);

        return (color & 0x00FFFFFF) | (alpha << 24);
    }
}