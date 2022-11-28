package com.hydrantine.cerberus;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Pair;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.behavior.AnimalPanic;
import net.minecraft.world.entity.ai.behavior.DoNothing;
import net.minecraft.world.entity.ai.behavior.LookAtTargetSink;
import net.minecraft.world.entity.ai.behavior.MoveToTargetSink;
import net.minecraft.world.entity.ai.behavior.RunIf;
import net.minecraft.world.entity.ai.behavior.RunOne;
import net.minecraft.world.entity.ai.behavior.RunSometimes;
import net.minecraft.world.entity.ai.behavior.SetEntityLookTarget;
import net.minecraft.world.entity.ai.behavior.SetWalkTargetFromLookTarget;
import net.minecraft.world.entity.ai.behavior.StartAttacking;
import net.minecraft.world.entity.ai.behavior.TryFindLand;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.schedule.Activity;

public class CerberusAI {

	protected static Brain<?> makeBrain(Brain<CerberusEntity> brain) {
		initCoreActivity(brain);
		initIdleActivity(brain);
		initShakeActivity(brain);
		brain.setCoreActivities(ImmutableSet.of(Activity.CORE));
		brain.setDefaultActivity(Activity.IDLE);
		brain.useDefaultActivity();
		return brain;
	}

	//General Traits
	private static void initCoreActivity(Brain<CerberusEntity> brain) {
		brain.addActivity(Activity.CORE, 0, 
				ImmutableList.of(new AnimalPanic(2.0F), new LookAtTargetSink(45, 90), new MoveToTargetSink()));
	}

	private static void initIdleActivity(Brain<CerberusEntity> brain) {
		brain.addActivityWithConditions(Activity.IDLE, 
			ImmutableList.of(Pair.of(0, new RunSometimes<CerberusEntity>(new SetEntityLookTarget(EntityType.PLAYER, 6.0F), UniformInt.of(30, 60))),
							 Pair.of(2, new StartAttacking<>(CerberusAI::canAttack, (entity) -> {
								 return entity.getBrain().getMemory(MemoryModuleType.NEAREST_ATTACKABLE);
							 })),
							 Pair.of(3, new TryFindLand(6, 1.0F)),
							 Pair.of(4, new RunOne<>(ImmutableMap.of(MemoryModuleType.WALK_TARGET, MemoryStatus.VALUE_ABSENT), ImmutableList.of(
									 Pair.of(new SetWalkTargetFromLookTarget(1.0F, 3), 1), 
									 Pair.of(new RunIf<>(Entity::isOnGround, new DoNothing(5, 20)), 2))))), 
			ImmutableSet.of(Pair.of(MemoryModuleType.IS_IN_WATER, MemoryStatus.VALUE_ABSENT)));	
	}

	private static boolean canAttack(CerberusEntity dog) {
		return true;
	}
	//General Traits
	
	//Cerberus Traits
	private static void initShakeActivity(Brain<CerberusEntity> dogbrain) {
		dogbrain.addActivity(Activity.EMERGE, ImmutableList.of());
	}
	//Cerberus Traits

	public static void updateActivity(CerberusEntity dog) {
		dog.getBrain().setActiveActivityToFirstValid(ImmutableList.of(Activity.EMERGE, Activity.SWIM, Activity.IDLE));
	}
}
