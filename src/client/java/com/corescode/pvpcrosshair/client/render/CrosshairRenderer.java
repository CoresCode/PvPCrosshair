package com.corescode.pvpcrosshair.client.render;

import com.corescode.pvpcrosshair.client.color.ColorResolver;
import com.corescode.pvpcrosshair.client.config.ConfigManager;
import com.corescode.pvpcrosshair.client.detection.TargetDetector;
import com.corescode.pvpcrosshair.client.detection.TargetState;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.HitResult.Type;
import org.jspecify.annotations.Nullable;

public final class CrosshairRenderer {

    private static final Minecraft MC = Minecraft.getInstance();

    private CrosshairRenderer() {
    }

    public static void render(Canvas graphics) {

        if (!shouldRender()) {
            return;
        }


        int cx = graphics.guiWidth() / 2;
        int cy = graphics.guiHeight() / 2;

        TargetState state = TargetDetector.getState();
        int color = ColorResolver.getColor(state);

        CrosshairStyle style = ConfigManager.style();

        switch (state) {

            case IDLE -> {

                drawIdleVanilla(graphics, cx, cy, color);
            }

            case TARGET -> {

                switch (style) {

                    case VANILLA -> {

                        drawVanilla(graphics, cx, cy, color);
                    }

                    case STAR -> {

                        drawVanilla(graphics, cx, cy, color);

                        drawDiagonals(graphics, cx, cy, color);
                    }

                    case CORNER -> {

                        drawVanilla(graphics, cx, cy, color);

                        drawCorner(graphics, cx, cy, color);
                    }

                    case CHEVRON -> {

                        drawChevron(graphics, cx, cy, color);
                    }
                }
            }

            case SHIELD -> {

                switch (style) {

                    case VANILLA -> {

                        drawVanilla(graphics, cx, cy, color);
                    }

                    case STAR -> {

                        drawVanilla(graphics, cx, cy, color);

                        drawDiagonals(graphics, cx, cy, color);
                    }

                    case CORNER -> {

                        drawVanilla(graphics, cx, cy, color);

                        drawCorner(graphics, cx, cy, color);
                    }

                    case CHEVRON -> {

                        drawChevron(graphics, cx, cy, color);
                    }
                }
            }
        }
    }

    private static boolean shouldRender() {

        if (MC.player == null) {
            return false;
        }

        if (!MC.options.getCameraType().isFirstPerson()) {
            return false;
        }

        if (MC.gameMode == null) {
            return false;
        }

        if (MC.gameMode.getPlayerMode() == GameType.SPECTATOR) {
            return canRenderCrosshairForSpectator(MC.hitResult);
        }


        return true;
    }

    /*
     * ============================
     * Crosshair Styles
     * ============================
     */


    private static void drawVanilla(
            Canvas graphics,
            int cx,
            int cy,
            int color
    ) {

        drawScaledVerticalArm(graphics, cx, cy, true, color);
        drawScaledVerticalArm(graphics, cx, cy, false, color);

        drawScaledHorizontalArm(graphics, cx, cy, true, color);
        drawScaledHorizontalArm(graphics, cx, cy, false, color);
    }

    private static void drawIdleVanilla(
            Canvas graphics,
            int cx,
            int cy,
            int color
    ) {

        drawIdleVerticalArm(graphics, cx, cy, true, color);
        drawIdleVerticalArm(graphics, cx, cy, false, color);

        drawIdleHorizontalArm(graphics, cx, cy, true, color);
        drawIdleHorizontalArm(graphics, cx, cy, false, color);
    }

    private static void drawDiagonals(
            Canvas graphics,
            int cx,
            int cy,
            int color
    ) {

        drawDiagonal(graphics, cx, cy, -1, -1, color);
        drawDiagonal(graphics, cx, cy, 1, -1, color);
        drawDiagonal(graphics, cx, cy, -1, 1, color);
        drawDiagonal(graphics, cx, cy, 1, 1, color);
    }

    private static void drawChevron(
            Canvas graphics,
            int cx,
            int cy,
            int color
    ) {

        drawDiagonalSegment(graphics, cx - 2, cy - 1, -1, -1, color);
        drawDiagonalSegment(graphics, cx - 2, cy + 1, -1, 1, color);

        drawDiagonalSegment(graphics, cx + 2, cy - 1, 1, -1, color);
        drawDiagonalSegment(graphics, cx + 2, cy + 1, 1, 1, color);
    }


    private static void drawCorner(
            Canvas graphics,
            int cx,
            int cy,
            int color
    ) {

        // =========================
        // Top Left
        // =========================
        pixel(graphics, cx - 4, cy - 4, color);
        pixel(graphics, cx - 3, cy - 4, color);
        pixel(graphics, cx - 4, cy - 3, color);

        // =========================
        // Top Right
        // =========================
        pixel(graphics, cx + 3, cy - 4, color);
        pixel(graphics, cx + 4, cy - 4, color);
        pixel(graphics, cx + 4, cy - 3, color);

        // =========================
        // Bottom Left
        // =========================
        pixel(graphics, cx - 4, cy + 3, color);
        pixel(graphics, cx - 4, cy + 4, color);
        pixel(graphics, cx - 3, cy + 4, color);

        // =========================
        // Bottom Right
        // =========================
        pixel(graphics, cx + 4, cy + 3, color);
        pixel(graphics, cx + 3, cy + 4, color);
        pixel(graphics, cx + 4, cy + 4, color);
    }
    /*
     * ============================
     * Arm Rendering
     * ============================
     */

    private static void pixel(
            Canvas graphics,
            int x,
            int y,
            int color
    ) {

        graphics.fill(
                x,
                y,
                x + 1,
                y + 1,
                color
        );
    }

    private static void drawScaledVerticalArm(
            Canvas graphics,
            int cx,
            int cy,
            boolean top,
            int color
    ) {

        int start = top
                ? cy - CrosshairShapes.outerRadius()
                : cy + CrosshairShapes.innerRadius();

        int end = top
                ? cy - CrosshairShapes.innerRadius() + 1
                : cy + CrosshairShapes.outerRadius() + 1;

        graphics.fill(
                cx,
                start,
                cx + 1,
                end,
                color
        );
    }

    private static void drawScaledHorizontalArm(
            Canvas graphics,
            int cx,
            int cy,
            boolean left,
            int color
    ) {

        int start = left
                ? cx - CrosshairShapes.outerRadius()
                : cx + CrosshairShapes.innerRadius();

        int end = left
                ? cx - CrosshairShapes.innerRadius() + 1
                : cx + CrosshairShapes.outerRadius() + 1;

        graphics.fill(
                start,
                cy,
                end,
                cy + 1,
                color
        );
    }

    private static void drawIdleVerticalArm(
            Canvas graphics,
            int cx,
            int cy,
            boolean top,
            int color
    ) {

        int start = top
                ? cy - 5
                : cy + 2;

        int end = top
                ? cy - 1
                : cy + 6;

        graphics.fill(
                cx,
                start,
                cx + 1,
                end,
                color
        );
    }

    private static void drawIdleHorizontalArm(
            Canvas graphics,
            int cx,
            int cy,
            boolean left,
            int color
    ) {

        int start = left
                ? cx - 5
                : cx + 2;

        int end = left
                ? cx - 1
                : cx + 6;

        graphics.fill(
                start,
                cy,
                end,
                cy + 1,
                color
        );
    }

    private static void drawDiagonal(
            Canvas graphics,
            int cx,
            int cy,
            int dx,
            int dy,
            int color
    ) {

        for (int i = 0; i < CrosshairShapes.diagonalLength(); i++) {

            int x = cx + dx * (CrosshairShapes.innerRadius() + i);
            int y = cy + dy * (CrosshairShapes.innerRadius() + i);

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
            Canvas graphics,
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

    private static boolean canRenderCrosshairForSpectator(@Nullable HitResult hitResult) {

        if (hitResult == null) {
            return false;
        }

        if (hitResult.getType() == Type.ENTITY) {
            return ((EntityHitResult) hitResult).getEntity() instanceof MenuProvider;
        }

        if (hitResult.getType() == Type.BLOCK) {

            BlockPos pos = ((BlockHitResult) hitResult).getBlockPos();

            Level level = MC.level;

            return level != null
                    && level.getBlockState(pos).getMenuProvider(level, pos) != null;
        }

        return false;
    }
}