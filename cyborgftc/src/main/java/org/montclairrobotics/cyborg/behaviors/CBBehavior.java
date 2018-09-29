package org.montclairrobotics.cyborg.behaviors;

import org.montclairrobotics.cyborg.Cyborg;
import org.montclairrobotics.cyborg.utils.CBModule;

public abstract class CBBehavior extends CBModule {

	public CBBehavior(Cyborg robot) {
		super(robot);
	}

	public abstract void init();

	public abstract void update();
}
