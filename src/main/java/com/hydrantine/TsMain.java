package com.hydrantine;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("tscerberus")
public class TsMain {
	
	public TsMain() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		TsEntities.ENTITY_TYPES.register(bus);
	}
	
}
