package com.hydrantine;

public class Ref {

	public static final String MODID = "tscerberus";
	
	public static float lerp(float initial, float target, int duration, float timeElapsed) {
		return initial + (timeElapsed/duration) * (target - initial);
	}
	
	//Wolf WolfModel WolfRenderer
}
