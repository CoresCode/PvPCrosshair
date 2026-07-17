package com.corescode.pvpcrosshair.client.config;

import com.corescode.pvpcrosshair.client.render.CrosshairStyle;

public final class ModConfig {

    /*
     * Crosshair
     */

    public CrosshairStyle style = CrosshairStyle.STAR;

    /*
     * Size
     * 50 - 100
     * (5% increments in UI later)
     */

    public int size = 95;

    /*
     * Opacity
     */

    public int idleOpacity = 60;

    public int targetOpacity = 100;

    public int shieldOpacity = 100;

    /*
     * Colors
     */

    public int idleColor = 0xFFFFFFFF;

    public int targetColor = 0xFF00FF00;

    public int shieldColor = 0xFFFF0000;
}