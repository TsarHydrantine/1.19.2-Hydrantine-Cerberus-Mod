package com.hydrantine;

import com.hydrantine.behavior.TsPose;

import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.world.entity.Pose;
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
