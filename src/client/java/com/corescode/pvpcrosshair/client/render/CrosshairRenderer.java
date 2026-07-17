package com.corescode.pvpcrosshair.client.render;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphicsExtractor;

public final class CrosshairRenderer {

    private static final int COLOR = 0xFFFFFFFF;

    private CrosshairRenderer() {
    }

    public static void extractRenderState(
            GuiGraphicsExtractor graphics,
            DeltaTracker deltaTracker
    ) {

        int cx = graphics.guiWidth() / 2;
        int cy = graphics.guiHeight() / 2;

        /*
         * STAR PROTOTYPE (Gap reduced by 1 pixel)
         */

        // Top
        graphics.fill(cx, cy - 5, cx + 1, cy - 1, COLOR);

        // Bottom
        graphics.fill(cx, cy + 2, cx + 1, cy + 6, COLOR);

        // Left
        graphics.fill(cx - 5, cy, cx - 1, cy + 1, COLOR);

        // Right
        graphics.fill(cx + 2, cy, cx + 6, cy + 1, COLOR);

        // Top Left
        graphics.fill(cx - 3, cy - 3, cx - 2, cy - 2, COLOR);
        graphics.fill(cx - 2, cy - 2, cx - 1, cy - 1, COLOR);

        // Top Right
        graphics.fill(cx + 3, cy - 3, cx + 4, cy - 2, COLOR);
        graphics.fill(cx + 2, cy - 2, cx + 3, cy - 1, COLOR);

        // Bottom Left
        graphics.fill(cx - 3, cy + 3, cx - 2, cy + 4, COLOR);
        graphics.fill(cx - 2, cy + 2, cx - 1, cy + 3, COLOR);

        // Bottom Right
        graphics.fill(cx + 3, cy + 3, cx + 4, cy + 4, COLOR);
        graphics.fill(cx + 2, cy + 2, cx + 3, cy + 3, COLOR);
    }
}