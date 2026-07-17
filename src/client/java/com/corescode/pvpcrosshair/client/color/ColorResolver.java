package com.corescode.pvpcrosshair.client.color;

import com.corescode.pvpcrosshair.client.config.ConfigManager;
import com.corescode.pvpcrosshair.client.detection.TargetState;

public final class ColorResolver {

    private ColorResolver() {
    }

    public static int getColor(TargetState state) {

        return switch (state) {

            case IDLE -> ConfigManager.idleColor();

            case TARGET -> ConfigManager.targetColor();

            case SHIELD -> ConfigManager.shieldColor();
        };
    }
}