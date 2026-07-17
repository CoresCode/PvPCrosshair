package com.corescode.pvpcrosshair.client.detection;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Items;

public final class TargetDetector {

    private static final Minecraft MC = Minecraft.getInstance();

    private TargetDetector() {
    }

    public static TargetState getState() {

        if (MC.player == null || MC.level == null) {

            return TargetState.IDLE;
        }

        Entity entity = MC.crosshairPickEntity;

        if (!(entity instanceof LivingEntity livingEntity)) {
            return TargetState.IDLE;
        }

        if (!livingEntity.isAlive()) {
            return TargetState.IDLE;
        }

        if (
                livingEntity.isUsingItem()
                        && livingEntity.getUseItem().is(Items.SHIELD)
        ) {
            TargetState state = TargetState.SHIELD;
            System.out.println(state);
            return state;


        }
        TargetState state = TargetState.TARGET;
        System.out.println(state);
        return state;

    }
}