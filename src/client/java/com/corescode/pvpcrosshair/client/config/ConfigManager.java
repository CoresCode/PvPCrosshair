package com.corescode.pvpcrosshair.client.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;

public final class ConfigManager {

    private ConfigManager() {
    }

    public static void register() {

        AutoConfig.register(
                ModConfig.class,
                Toml4jConfigSerializer::new
        );
    }

    public static ModConfig get() {

        return AutoConfig
                .getConfigHolder(ModConfig.class)
                .getConfig();
    }
}