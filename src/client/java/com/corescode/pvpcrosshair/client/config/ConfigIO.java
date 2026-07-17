package com.corescode.pvpcrosshair.client.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public final class ConfigIO {

    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    private static final Path CONFIG_PATH =
            FabricLoader.getInstance()
                    .getConfigDir()
                    .resolve("pvpcrosshair.json");

    private ConfigIO() {
    }

    public static void load() {

        if (!Files.exists(CONFIG_PATH)) {
            save();
            return;
        }

        try (Reader reader = Files.newBufferedReader(CONFIG_PATH)) {

            ModConfig loaded =
                    GSON.fromJson(reader, ModConfig.class);

            if (loaded != null) {

                ConfigManager.setStyle(loaded.style);
                ConfigManager.setSize(loaded.size);

                ConfigManager.setIdleOpacity(loaded.idleOpacity);
                ConfigManager.setTargetOpacity(loaded.targetOpacity);
                ConfigManager.setShieldOpacity(loaded.shieldOpacity);

                ConfigManager.setIdleColor(loaded.idleColor);
                ConfigManager.setTargetColor(loaded.targetColor);
                ConfigManager.setShieldColor(loaded.shieldColor);
            }

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void save() {

        try {

            Files.createDirectories(CONFIG_PATH.getParent());

            try (Writer writer = Files.newBufferedWriter(CONFIG_PATH)) {

                GSON.toJson(
                        ConfigManager.config(),
                        writer
                );
            }

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}