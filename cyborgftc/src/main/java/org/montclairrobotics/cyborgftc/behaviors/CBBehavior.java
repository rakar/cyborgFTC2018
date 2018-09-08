package org.montclairrobotics.cyborgftc.behaviors;

import org.montclairrobotics.cyborgftc.Cyborg;
import org.montclairrobotics.cyborgftc.utils.CBModule;

public abstract class CBBehavior extends CBModule {

	public CBBehavior(Cyborg robot) {
		super(robot);
	}

	public abstract void init();
	public abstract void update();

}
