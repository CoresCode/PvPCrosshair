package com.corescode.pvpcrosshair.client.util;

public final class ColorUtil {

    private ColorUtil() {
    }

    /**
     * opacity: 0-100
     */
    public static int applyOpacity(int color, int opacity) {

        opacity = Math.max(0, Math.min(100, opacity));

        int alpha = (opacity * 255) / 100;

        return (alpha << 24) | (color & 0x00FFFFFF);
    }
}