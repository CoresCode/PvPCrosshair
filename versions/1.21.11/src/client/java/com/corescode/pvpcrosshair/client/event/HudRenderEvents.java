package com.corescode.pvpcrosshair.client.event;

import com.corescode.pvpcrosshair.PvPCrosshair;
import com.corescode.pvpcrosshair.client.render.Canvas;
import com.corescode.pvpcrosshair.client.render.CrosshairRenderer;

import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;

import net.minecraft.client.gui.GuiGraphics;

public final class HudRenderEvents {

    private HudRenderEvents() {
    }

    public static void register() {

        HudElementRegistry.attachElementAfter(
                VanillaHudElements.CROSSHAIR,
                PvPCrosshair.id("crosshair"),
                (graphics, deltaTracker) ->
                        CrosshairRenderer.render(new GuiCanvas(graphics))
        );
    }

    private record GuiCanvas(GuiGraphics graphics) implements Canvas {

        @Override
        public int guiWidth() {
            return graphics.guiWidth();
        }

        @Override
        public int guiHeight() {
            return graphics.guiHeight();
        }

        @Override
        public void fill(int x1, int y1, int x2, int y2, int color) {
            graphics.fill(x1, y1, x2, y2, color);
        }
    }
}
