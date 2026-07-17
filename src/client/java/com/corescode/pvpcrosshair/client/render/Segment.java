package com.corescode.pvpcrosshair.client.render;

public record Segment(
        float x1,
        float y1,
        float x2,
        float y2
) {

    public boolean horizontal() {
        return y1 == y2;
    }

    public boolean vertical() {
        return x1 == x2;
    }

    public boolean diagonal() {
        return !horizontal() && !vertical();
    }
}