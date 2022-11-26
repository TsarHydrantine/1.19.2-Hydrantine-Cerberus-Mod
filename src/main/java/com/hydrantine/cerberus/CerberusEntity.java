package com.hydrantine.cerberus;

import com.hydrantine.TsEntities;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.level.Level;

public class CerberusEntity extends Wolf {

	public CerberusEntity(EntityType<? extends Wolf> type, Level level) {
		super(type, level);
	}
	
	public static AttributeSupplier.Builder createAttributes() {
		   return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.3F).add(Attributes.MAX_HEALTH, 8.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
	}

	@Override
	public Wolf getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
		return TsEntities.CERBERUS.get().create(level);
	}
}
