package com.corescode.pvpcrosshair.client.render;

import com.corescode.pvpcrosshair.client.config.ConfigManager;

public final class CrosshairShapes {

    private CrosshairShapes() {
    }

    public static int innerRadius() {
        return 2;
    }

    public static int outerRadius() {

        int size = ConfigManager.size();

        if (size <= 60)
            return 4;

        if (size <= 80)
            return 5;

        if (size <= 95)
            return 6;

        return 7;
    }

    public static int diagonalLength() {

        int size = ConfigManager.size();

        if (size <= 60)
            return 2;

        return 3;
    }
}