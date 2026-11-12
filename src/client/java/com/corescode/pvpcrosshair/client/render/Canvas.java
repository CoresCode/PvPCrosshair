package com.corescode.pvpcrosshair.client.render;

/**
 * Minimal drawing surface used by {@link CrosshairRenderer}.
 * Each Minecraft version supplies its own implementation, so the
 * renderer itself stays identical across versions.
 */
public interface Canvas {

    int guiWidth();

    int guiHeight();

    void fill(int x1, int y1, int x2, int y2, int color);
}
