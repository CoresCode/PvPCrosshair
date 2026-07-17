package com.corescode.pvpcrosshair.client.config;

import com.corescode.pvpcrosshair.client.render.CrosshairStyle;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.network.chat.Component;

public final class ModMenuIntegration implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {

        return parent -> {

            ConfigBuilder builder = ConfigBuilder.create()
                    .setParentScreen(parent)
                    .setTitle(Component.literal("PvP Crosshair"));

            builder.setSavingRunnable(ConfigIO::save);


            ConfigEntryBuilder entry = builder.entryBuilder();

            ConfigCategory crosshair =
                    builder.getOrCreateCategory(Component.literal("Crosshair"));

            ConfigCategory opacity =
                    builder.getOrCreateCategory(Component.literal("Opacity"));
            ConfigCategory colors =
                    builder.getOrCreateCategory(Component.literal("Colors"));

            /*
             * Style
             */

            crosshair.addEntry(

                    entry.startEnumSelector(
                                    Component.literal("Style"),
                                    CrosshairStyle.class,
                                    ConfigManager.style()
                            )
                            .setDefaultValue(CrosshairStyle.STAR)
                            .setSaveConsumer(ConfigManager::setStyle)
                            .build()
            );

            /*
             * Size
             */

            crosshair.addEntry(

                    entry.startIntSlider(
                                    Component.literal("Size (%)"),
                                    ConfigManager.size(),
                                    50,
                                    100
                            )
                            .setDefaultValue(85)
                            .setTextGetter(v -> Component.literal(v + "%"))
                            .setSaveConsumer(ConfigManager::setSize)
                            .build()
            );

            /*
             * Idle
             */

            opacity.addEntry(

                    entry.startIntSlider(
                                    Component.literal("Idle Opacity"),
                                    ConfigManager.idleOpacity(),
                                    50,
                                    100
                            )
                            .setDefaultValue(90)
                            .setTextGetter(v -> Component.literal(v + "%"))
                            .setSaveConsumer(ConfigManager::setIdleOpacity)
                            .build()
            );

            /*
             * Target
             */

            opacity.addEntry(

                    entry.startIntSlider(
                                    Component.literal("Target Opacity"),
                                    ConfigManager.targetOpacity(),
                                    50,
                                    100
                            )
                            .setDefaultValue(100)
                            .setTextGetter(v -> Component.literal(v + "%"))
                            .setSaveConsumer(ConfigManager::setTargetOpacity)
                            .build()
            );

            colors.addEntry(

                    entry.startAlphaColorField(
                                    Component.literal("Idle Color (ARGB)"),
                                    ConfigManager.idleColor()
                            )
                            .setDefaultValue(0xFFFFFFFF)
                            .setSaveConsumer(ConfigManager::setIdleColor)
                            .build()
            );

            colors.addEntry(

                    entry.startAlphaColorField(
                                    Component.literal("Target Color (ARGB)"),
                                    ConfigManager.targetColor()
                            )
                            .setDefaultValue(0xFF00FF00)
                            .setSaveConsumer(ConfigManager::setTargetColor)
                            .build()
            );

            colors.addEntry(

                    entry.startAlphaColorField(
                                    Component.literal("Shield Color (ARGB)"),
                                    ConfigManager.shieldColor()
                            )
                            .setDefaultValue(0xFFFF0000)
                            .setSaveConsumer(ConfigManager::setShieldColor)
                            .build()
            );

            /*
             * Shield
             */

            opacity.addEntry(

                    entry.startIntSlider(
                                    Component.literal("Shield Opacity"),
                                    ConfigManager.shieldOpacity(),
                                    50,
                                    100
                            )
                            .setDefaultValue(100)
                            .setTextGetter(v -> Component.literal(v + "%"))
                            .setSaveConsumer(ConfigManager::setShieldOpacity)
                            .build()
            );

            return builder.build();
        };
    }
}