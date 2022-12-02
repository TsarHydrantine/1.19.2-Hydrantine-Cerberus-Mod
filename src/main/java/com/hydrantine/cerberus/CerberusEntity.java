package com.hydrantine.cerberus;

import com.google.common.collect.ImmutableList;
import com.hydrantine.behavior.TsPose;
import com.mojang.serialization.Dynamic;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.warden.Emerging;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;

public class CerberusEntity extends Animal {

	// Sensor and Memory Types are for Brain Function
	protected static final ImmutableList<SensorType<? extends Sensor<? super CerberusEntity>>> SENSOR_TYPES = ImmutableList
			.of(SensorType.NEAREST_LIVING_ENTITIES, SensorType.HURT_BY, SensorType.IS_IN_WATER);
	protected static final ImmutableList<MemoryModuleType<?>> MEMORY_TYPES = ImmutableList.of(
			MemoryModuleType.LOOK_TARGET, MemoryModuleType.NEAREST_LIVING_ENTITIES,
			MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES, MemoryModuleType.WALK_TARGET,
			MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE, MemoryModuleType.PATH, MemoryModuleType.ATTACK_TARGET,
			MemoryModuleType.TEMPTING_PLAYER, MemoryModuleType.TEMPTATION_COOLDOWN_TICKS, MemoryModuleType.IS_TEMPTED,
			MemoryModuleType.HURT_BY, MemoryModuleType.HURT_BY_ENTITY, MemoryModuleType.NEAREST_ATTACKABLE,
			MemoryModuleType.IS_IN_WATER, MemoryModuleType.IS_PANICKING);

	//Store Data
	public static final EntityDataSerializer<TsPose> CUSTOM_POSE = EntityDataSerializer.simpleEnum(TsPose.class);
	protected static final EntityDataAccessor<TsPose> CUSTOM_DATA_POSE = SynchedEntityData.defineId(Entity.class, CUSTOM_POSE);
	protected final SynchedEntityData customEntityData;
	
	// Animation States
	public final AnimationState waggingAnimationState = new AnimationState();
	public final AnimationState shakingAnimationState = new AnimationState();
	public final AnimationState walkAnimationState = new AnimationState();

	public CerberusEntity(EntityType<? extends Animal> type, Level level) {
		super(type, level);
		this.customEntityData = new SynchedEntityData(this);
		this.customEntityData.define(CUSTOM_DATA_POSE, TsPose.IDLE);
	}

	// AI
	@Override
	protected Brain.Provider<CerberusEntity> brainProvider() {
		return Brain.provider(MEMORY_TYPES, SENSOR_TYPES);
	}

	@Override
	protected Brain<?> makeBrain(Dynamic<?> p_218494_) {
		return CerberusAI.makeBrain(this.brainProvider().makeBrain(p_218494_));
	}
	
	@Override
	public Brain<CerberusEntity> getBrain() {
		return (Brain<CerberusEntity>) super.getBrain();
	}

	@Override
	protected void customServerAiStep() {
		this.level.getProfiler().push("frogBrain");
		this.getBrain().tick((ServerLevel) this.level, this);
		this.level.getProfiler().pop();
		this.level.getProfiler().push("frogActivityUpdate");
		CerberusAI.updateActivity(this);
		this.level.getProfiler().pop();
		super.customServerAiStep();
	}

	private boolean isMovingOnLand() {
		return this.onGround && this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D && !this.isInWaterOrBubble();
	}

	public void onSyncedDataUpdated(EntityDataAccessor<?> p_218498_) {
		if (DATA_POSE.equals(p_218498_)) {
			TsPose pose = this.getCustomPose();
			if (pose == TsPose.SHAKING) {
				this.shakingAnimationState.start(this.tickCount);
			} else {
				this.shakingAnimationState.stop();
			}
		}

		super.onSyncedDataUpdated(p_218498_);
	}
	
	//Pose
	public void setPose(TsPose tspose) {
		this.customEntityData.set(CUSTOM_DATA_POSE, tspose);
	}

	public TsPose getCustomPose() {
		return this.customEntityData.get(CUSTOM_DATA_POSE);
	}

	public boolean hasPose(TsPose tspose) {
		return this.getCustomPose() == tspose;
	}
	//Pose
	
	@Override
	public void tick() {
		if (this.level.isClientSide()) {
			if (this.isMovingOnLand()) {
				this.walkAnimationState.startIfStopped(this.tickCount);
			} else {
				this.walkAnimationState.stop();
			}
		}
		super.tick();
	}
	//AI

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.3F).add(Attributes.MAX_HEALTH, 8.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
		return null;
	}
}
