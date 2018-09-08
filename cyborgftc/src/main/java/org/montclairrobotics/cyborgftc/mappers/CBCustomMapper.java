package org.montclairrobotics.cyborgftc.mappers;

import org.montclairrobotics.cyborgftc.Cyborg;
import org.montclairrobotics.cyborgftc.utils.CBModule;

public abstract class CBCustomMapper extends CBModule {

	public CBCustomMapper(Cyborg robot) {
		super(robot);
		// TODO Auto-generated constructor stub
	}

	public abstract void update();

}
