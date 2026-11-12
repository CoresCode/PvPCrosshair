package com.corescode.pvpcrosshair.client.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.fabricmc.loader.api.FabricLoader;

/**
 * Mod Menu entrypoint. Mod Menu and Cloth Config are both optional:
 * this class is only loaded by Mod Menu, and the config screen is only
 * offered when Cloth Config is present.
 */
public final class ModMenuIntegration implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {

        if (!FabricLoader.getInstance().isModLoaded("cloth-config")) {
            return parent -> null;
        }

        return ClothConfigScreen::create;
    }
}
