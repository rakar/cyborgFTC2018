/**
 * 
 */
package org.montclairrobotics.cyborgftc.controllers;

import org.montclairrobotics.cyborgftc.Cyborg;
import org.montclairrobotics.cyborgftc.utils.CBModule;

public abstract class CBRobotController extends CBModule {

	public CBRobotController(Cyborg robot) {
		super(robot);
	}

	public abstract void update();
	
	public abstract void configHardware();

}
