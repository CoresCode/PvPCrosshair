package com.corescode.pvpcrosshair.client.color;

import com.corescode.pvpcrosshair.client.detection.TargetState;

public final class ColorResolver {

    private static final int DEFAULT_COLOR = 0xFFFFFFFF;

    private static final int TARGET_COLOR = 0xFF00FF00;

    private static final int SHIELD_COLOR = 0xFFFF0000;

    private ColorResolver() {
    }

    public static int getColor(TargetState state) {

        return switch (state) {

            case IDLE -> DEFAULT_COLOR;

            case TARGET -> TARGET_COLOR;

            case SHIELD -> SHIELD_COLOR;
        };
    }
}