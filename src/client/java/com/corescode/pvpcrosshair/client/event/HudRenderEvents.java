package com.corescode.pvpcrosshair.client.event;

import com.corescode.pvpcrosshair.client.render.CrosshairRenderer;

import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;

import net.minecraft.resources.Identifier;

public final class HudRenderEvents {

    private HudRenderEvents() {
    }

    public static void register() {

        HudElementRegistry.attachElementAfter(
                VanillaHudElements.CROSSHAIR,
                Identifier.fromNamespaceAndPath(
                        "pvpcrosshair",
                        "crosshair"
                ),
                CrosshairRenderer::extractRenderState
        );
    }
}