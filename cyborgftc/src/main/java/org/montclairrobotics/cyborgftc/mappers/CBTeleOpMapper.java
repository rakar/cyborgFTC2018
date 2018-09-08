package org.montclairrobotics.cyborgftc.mappers;

import org.montclairrobotics.cyborgftc.Cyborg;
import org.montclairrobotics.cyborgftc.utils.CBModule;

public abstract class CBTeleOpMapper extends CBModule {

	public CBTeleOpMapper(Cyborg robot) {
		super(robot);
	}

	public abstract void update();
}
