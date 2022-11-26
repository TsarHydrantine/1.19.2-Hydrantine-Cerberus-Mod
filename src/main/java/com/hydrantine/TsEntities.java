package com.hydrantine;

import com.hydrantine.cerberus.CerberusEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TsEntities {
	
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TsMain.MODID);
	
	public static final RegistryObject<EntityType<CerberusEntity>> CERBERUS = ENTITY_TYPES.register("cerberus", () -> EntityType.Builder.of(CerberusEntity::new, MobCategory.CREATURE).sized(1.0f, 1.0f).build(new ResourceLocation(TsMain.MODID, "cerberus").toString()));

}
