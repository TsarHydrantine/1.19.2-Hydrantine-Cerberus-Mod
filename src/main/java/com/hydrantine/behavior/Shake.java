package com.hydrantine.behavior;

import com.google.common.collect.ImmutableMap;
import com.hydrantine.cerberus.CerberusEntity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;

public class Shake<E extends CerberusEntity> extends Behavior<E> {

	//ANIMATION IS BASED ON POSE, LIKE EMERGING
	public Shake(int duration) {
		super(ImmutableMap.of(MemoryModuleType.IS_EMERGING, MemoryStatus.VALUE_PRESENT), duration);
	}

	protected void start(ServerLevel level, E entity, long longlong) {
		entity.setPose(Pose.EMERGING);
		entity.playSound(SoundEvents.WOLF_SHAKE, 5.0F, 1.0F);
	}

	protected void stop(ServerLevel level, E entity, long longlong) {
		if (entity.hasPose(Pose.EMERGING)) {
			entity.setPose(Pose.STANDING);
		}
	}
}
