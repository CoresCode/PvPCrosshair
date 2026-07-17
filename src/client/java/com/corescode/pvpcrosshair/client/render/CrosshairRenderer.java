package com.corescode.pvpcrosshair.client.render;

import com.corescode.pvpcrosshair.client.color.ColorResolver;
import com.corescode.pvpcrosshair.client.detection.TargetDetector;
import com.corescode.pvpcrosshair.client.detection.TargetState;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphicsExtractor;

public final class CrosshairRenderer {

    private CrosshairRenderer() {
    }

    public static void extractRenderState(
            GuiGraphicsExtractor graphics,
            DeltaTracker deltaTracker
    ) {

        int cx = graphics.guiWidth() / 2;
        int cy = graphics.guiHeight() / 2;

        TargetState state = TargetDetector.getState();
        int color = ColorResolver.getColor(state);

        // TODO: Replace with config value later
        CrosshairStyle style = CrosshairStyle.STAR;

        switch (state) {

            case IDLE -> drawIdle(graphics, cx, cy, color);

            case TARGET -> {

                switch (style) {

                    case VANILLA -> drawVanilla(graphics, cx, cy, color);

                    case STAR -> drawStar(graphics, cx, cy, color);

                    case CHEVRON -> drawChevron(graphics, cx, cy, color);

                    case CORNER -> drawCorner(graphics, cx, cy, color);
                }
            }

            case SHIELD -> {

                switch (style) {

                    case VANILLA -> drawVanilla(graphics, cx, cy, color);

                    case STAR -> drawStar(graphics, cx, cy, color);

                    case CHEVRON -> drawChevron(graphics, cx, cy, color);

                    case CORNER -> drawCorner(graphics, cx, cy, color);
                }
            }
        }
    }

    /*
     * ============================
     * Crosshair Styles
     * ============================
     */

    private static void drawStar(
            GuiGraphicsExtractor graphics,
            int cx,
            int cy,
            int color
    ) {

        drawVerticalArm(graphics, cx, cy, true, color);
        drawVerticalArm(graphics, cx, cy, false, color);

        drawHorizontalArm(graphics, cx, cy, true, color);
        drawHorizontalArm(graphics, cx, cy, false, color);

        drawDiagonal(graphics, cx, cy, -1, -1, color);
        drawDiagonal(graphics, cx, cy, 1, -1, color);
        drawDiagonal(graphics, cx, cy, -1, 1, color);
        drawDiagonal(graphics, cx, cy, 1, 1, color);
    }

    private static void drawVanilla(
            GuiGraphicsExtractor graphics,
            int cx,
            int cy,
            int color
    ) {

        drawVerticalArm(graphics, cx, cy, true, color);
        drawVerticalArm(graphics, cx, cy, false, color);

        drawHorizontalArm(graphics, cx, cy, true, color);
        drawHorizontalArm(graphics, cx, cy, false, color);
    }

    private static void drawChevron(
            GuiGraphicsExtractor graphics,
            int cx,
            int cy,
            int color
    ) {

        drawDiagonalSegment(graphics, cx - 2, cy - 1, -1, -1, color);
        drawDiagonalSegment(graphics, cx - 2, cy + 1, -1, 1, color);

        drawDiagonalSegment(graphics, cx + 2, cy - 1, 1, -1, color);
        drawDiagonalSegment(graphics, cx + 2, cy + 1, 1, 1, color);
    }

    private static void drawIdle(
            GuiGraphicsExtractor graphics,
            int cx,
            int cy,
            int color
    ) {

        graphics.fill(cx, cy - 2, cx + 1, cy, color);
        graphics.fill(cx, cy + 1, cx + 1, cy + 3, color);

        graphics.fill(cx - 2, cy, cx, cy + 1, color);
        graphics.fill(cx + 1, cy, cx + 3, cy + 1, color);
    }

    private static void drawCorner(
            GuiGraphicsExtractor graphics,
            int cx,
            int cy,
            int color
    ) {

        // TODO
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
            boolean top,
            int color
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
                color
        );
    }

    private static void drawHorizontalArm(
            GuiGraphicsExtractor graphics,
            int cx,
            int cy,
            boolean left,
            int color
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
                color
        );
    }

    private static void drawDiagonal(
            GuiGraphicsExtractor graphics,
            int cx,
            int cy,
            int dx,
            int dy,
            int color
    ) {

        for (int i = 0; i < CrosshairShapes.DIAGONAL_LENGTH; i++) {

            int x = cx + dx * (CrosshairShapes.INNER_RADIUS + i);
            int y = cy + dy * (CrosshairShapes.INNER_RADIUS + i);

            graphics.fill(
                    x,
                    y,
                    x + 1,
                    y + 1,
                    color
            );
        }
    }

    private static void drawDiagonalSegment(
            GuiGraphicsExtractor graphics,
            int startX,
            int startY,
            int dx,
            int dy,
            int color
    ) {

        for (int i = 0; i < 3; i++) {

            graphics.fill(
                    startX + dx * i,
                    startY + dy * i,
                    startX + dx * i + 1,
                    startY + dy * i + 1,
                    color
            );
        }
    }
}