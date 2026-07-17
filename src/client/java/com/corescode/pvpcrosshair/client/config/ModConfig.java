package com.corescode.pvpcrosshair.client.config;

import com.corescode.pvpcrosshair.client.render.CrosshairStyle;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "pvpcrosshair")
public class ModConfig implements ConfigData {

    /*
     * ============================
     * Crosshair
     * ============================
     */

    public CrosshairStyle crosshairStyle = CrosshairStyle.STAR;

    public int crosshairSize = 95;

    /*
     * ============================
     * Opacity
     * ============================
     */

    public int idleOpacity = 60;

    public int targetOpacity = 100;

    public int shieldOpacity = 100;
}