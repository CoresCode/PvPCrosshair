package com.corescode.pvpcrosshair.client.config;

import com.corescode.pvpcrosshair.client.render.CrosshairStyle;

public final class ConfigManager {

    private static final ModConfig CONFIG = new ModConfig();

    private ConfigManager() {
    }

    /*
     * ============================
     * Getters
     * ============================
     */

    public static CrosshairStyle style() {
        return CONFIG.style;
    }

    public static int size() {
        return CONFIG.size;
    }

    public static int idleOpacity() {
        return CONFIG.idleOpacity;
    }

    public static int targetOpacity() {
        return CONFIG.targetOpacity;
    }

    public static int shieldOpacity() {
        return CONFIG.shieldOpacity;
    }

    public static int idleColor() {
        return CONFIG.idleColor;
    }

    public static int targetColor() {
        return CONFIG.targetColor;
    }

    public static int shieldColor() {
        return CONFIG.shieldColor;
    }

    /*
     * ============================
     * Setters
     * ============================
     */

    public static void setStyle(CrosshairStyle style) {
        CONFIG.style = style;
    }

    public static void setSize(int size) {
        CONFIG.size = size;
    }

    public static void setIdleOpacity(int opacity) {
        CONFIG.idleOpacity = opacity;
    }

    public static void setTargetOpacity(int opacity) {
        CONFIG.targetOpacity = opacity;
    }

    public static void setShieldOpacity(int opacity) {
        CONFIG.shieldOpacity = opacity;
    }

    public static void setIdleColor(int color) {
        CONFIG.idleColor = color;
    }

    public static void setTargetColor(int color) {
        CONFIG.targetColor = color;
    }

    public static void setShieldColor(int color) {
        CONFIG.shieldColor = color;
    }
    public static void reset() {

        CONFIG.style = CrosshairStyle.CORNER;

        CONFIG.size = 85;

        CONFIG.idleOpacity = 100;
        CONFIG.targetOpacity = 100;
        CONFIG.shieldOpacity = 100;

        CONFIG.idleColor = 0xFFFFFFFF;
        CONFIG.targetColor = 0xFF00FF00;
        CONFIG.shieldColor = 0xFFFF0000;
    }

    /*
     * Internal access.
     */

    static ModConfig config() {
        return CONFIG;
    }
}