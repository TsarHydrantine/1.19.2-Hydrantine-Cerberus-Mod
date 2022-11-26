package com.hydrantine.sided;

import com.hydrantine.TsEntities;
import com.hydrantine.TsMain;
import com.hydrantine.cerberus.CerberusModel;
import com.hydrantine.cerberus.CerberusRenderer;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.EntityRenderersEvent.RegisterRenderers;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TsMain.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSide {
	
	@SubscribeEvent
	public static void entityRenders(RegisterRenderers event) {
		event.registerEntityRenderer(TsEntities.CERBERUS.get(), CerberusRenderer::new);
	}
	
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(CerberusModel.LAYER_LOCATION, CerberusModel::createBodyLayer);
	}
	
}
