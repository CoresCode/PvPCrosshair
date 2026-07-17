package com.corescode.pvpcrosshair.client;

import com.corescode.pvpcrosshair.client.event.HudRenderEvents;
import net.fabricmc.api.ClientModInitializer;
import com.corescode.pvpcrosshair.client.config.ConfigIO;

public final class PvPCrosshairClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {

		ConfigIO.load();

		HudRenderEvents.register();
	}
}