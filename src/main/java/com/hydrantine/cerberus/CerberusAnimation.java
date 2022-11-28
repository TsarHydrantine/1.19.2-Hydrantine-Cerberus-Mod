package com.hydrantine.cerberus;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class CerberusAnimation {

	static float initial = 0.0f;
	static float preparation = 2.5f;
	static float swing = 10.0f;
	static float wag = -25.0f;

	public static final AnimationDefinition WAG = AnimationDefinition.Builder.withLength(0.56f).looping()
			.addAnimation("tail", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(0f, initial, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.16f, KeyframeAnimations.degreeVec(0f, -wag, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.44f, KeyframeAnimations.degreeVec(0f, wag, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.56f, KeyframeAnimations.degreeVec(0f, initial, 0f), AnimationChannel.Interpolations.LINEAR)))
			.build();
	
	public static final AnimationDefinition SHAKE = AnimationDefinition.Builder.withLength(1.08f)
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, initial), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.12f, KeyframeAnimations.degreeVec(0f, 0f, -preparation), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.44f, KeyframeAnimations.degreeVec(0f, 0f, swing), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.56f, KeyframeAnimations.degreeVec(0f, 0f, -swing), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.68f, KeyframeAnimations.degreeVec(0f, 0f, swing), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.8f, KeyframeAnimations.degreeVec(0f, 0f, -swing), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.92f, KeyframeAnimations.degreeVec(0f, 0f, initial), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("head2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.04f, KeyframeAnimations.degreeVec(0f, 0f, initial), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.16f, KeyframeAnimations.degreeVec(0f, 0f, -preparation), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.48f, KeyframeAnimations.degreeVec(0f, 0f, swing), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.6f, KeyframeAnimations.degreeVec(0f, 0f, -swing), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.72f, KeyframeAnimations.degreeVec(0f, 0f, swing), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.84f, KeyframeAnimations.degreeVec(0f, 0f, -swing), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.96f, KeyframeAnimations.degreeVec(0f, 0f, initial), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.04f, KeyframeAnimations.degreeVec(0f, 0f, initial), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.16f, KeyframeAnimations.degreeVec(0f, 0f, -preparation), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.48f, KeyframeAnimations.degreeVec(0f, 0f, swing), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.6f, KeyframeAnimations.degreeVec(0f, 0f, -swing), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.72f, KeyframeAnimations.degreeVec(0f, 0f, swing), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.84f, KeyframeAnimations.degreeVec(0f, 0f, -swing), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.96f, KeyframeAnimations.degreeVec(0f, 0f, initial), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("upperBody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, initial), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.12f, KeyframeAnimations.degreeVec(0f, 0f, -preparation), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.44f, KeyframeAnimations.degreeVec(0f, 0f, swing), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.56f, KeyframeAnimations.degreeVec(0f, 0f, -swing), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.68f, KeyframeAnimations.degreeVec(0f, 0f, swing), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.8f, KeyframeAnimations.degreeVec(0f, 0f, -swing), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.92f, KeyframeAnimations.degreeVec(0f, 0f, initial), AnimationChannel.Interpolations.LINEAR)))
			.build();
	
	//Frog FrogModel FrogAnimation
}
