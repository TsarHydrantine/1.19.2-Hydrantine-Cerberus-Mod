package com.hydrantine.sided;

import com.hydrantine.TsEntities;
import com.hydrantine.Ref;
import com.hydrantine.cerberus.CerberusEntity;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Ref.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonSide {

	@SubscribeEvent
	public static void entityAttribues(EntityAttributeCreationEvent event) {
		event.put(TsEntities.CERBERUS.get(), CerberusEntity.createAttributes().build());
	}
	
}
