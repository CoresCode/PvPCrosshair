package com.corescode.pvpcrosshair.client;

import com.corescode.pvpcrosshair.client.config.ConfigManager;
import com.corescode.pvpcrosshair.client.event.HudRenderEvents;
import net.fabricmc.api.ClientModInitializer;

public final class PvPCrosshairClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {

		ConfigManager.register();

		HudRenderEvents.register();
	}
}