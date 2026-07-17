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

        drawStar(graphics, cx, cy);
    }

    /*
     * ============================
     * Crosshair Styles
     * ============================
     */

    private static void drawStar(
            GuiGraphicsExtractor graphics,
            int cx,
            int cy
    ) {

        drawVerticalArm(graphics, cx, cy, true);
        drawVerticalArm(graphics, cx, cy, false);

        drawHorizontalArm(graphics, cx, cy, true);
        drawHorizontalArm(graphics, cx, cy, false);

        drawDiagonal(graphics, cx, cy, -1, -1);
        drawDiagonal(graphics, cx, cy, 1, -1);
        drawDiagonal(graphics, cx, cy, -1, 1);
        drawDiagonal(graphics, cx, cy, 1, 1);
    }

    /*
     * ============================
     * Arm Rendering
     * ============================
     */

    private static void drawVerticalArm(
            GuiGraphicsExtractor graphics,
            int cx,
            int cy,
            boolean top
    ) {

        int start = top
                ? cy - CrosshairShapes.OUTER_RADIUS
                : cy + CrosshairShapes.INNER_RADIUS;

        int end = top
                ? cy - CrosshairShapes.INNER_RADIUS + 1
                : cy + CrosshairShapes.OUTER_RADIUS + 1;

        graphics.fill(
                cx,
                start,
                cx + 1,
                end,
                COLOR
        );
    }

    private static void drawHorizontalArm(
            GuiGraphicsExtractor graphics,
            int cx,
            int cy,
            boolean left
    ) {

        int start = left
                ? cx - CrosshairShapes.OUTER_RADIUS
                : cx + CrosshairShapes.INNER_RADIUS;

        int end = left
                ? cx - CrosshairShapes.INNER_RADIUS + 1
                : cx + CrosshairShapes.OUTER_RADIUS + 1;

        graphics.fill(
                start,
                cy,
                end,
                cy + 1,
                COLOR
        );
    }

    private static void drawDiagonal(
            GuiGraphicsExtractor graphics,
            int cx,
            int cy,
            int dx,
            int dy
    ) {

        for (int i = 0; i < CrosshairShapes.DIAGONAL_LENGTH; i++) {

            int x = cx + dx * (CrosshairShapes.INNER_RADIUS + i);
            int y = cy + dy * (CrosshairShapes.INNER_RADIUS + i);

            graphics.fill(
                    x,
                    y,
                    x + 1,
                    y + 1,
                    COLOR
            );
        }
    }
}