package com.hydrantine.behavior;

import com.hydrantine.Ref;

import net.minecraft.world.entity.schedule.Activity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TsActivity {

	public static final DeferredRegister<Activity> ACTIVITIES = DeferredRegister.create(ForgeRegistries.ACTIVITIES, Ref.MODID);
	
	public static final RegistryObject<Activity> SHAKE = ACTIVITIES.register("shake", () -> new Activity("shake"));
	
	public static void register(IEventBus eventBus) {
		ACTIVITIES.register(eventBus);
	}
}
