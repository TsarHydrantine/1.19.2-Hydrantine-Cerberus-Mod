package com.hydrantine;

import com.hydrantine.cerberus.CerberusEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TsEntities {
	
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Ref.MODID);
	
	public static final RegistryObject<EntityType<CerberusEntity>> CERBERUS = ENTITY_TYPES.register("cerberus", () -> EntityType.Builder.of(CerberusEntity::new, MobCategory.CREATURE).sized(1.2f, 1.2f).build(new ResourceLocation(Ref.MODID, "cerberus").toString()));

}
