package org.montclairrobotics.cyborgftc.data;

import org.montclairrobotics.cyborgftc.utils.*;

public class CBStdDriveControlData extends CBDriveControlData {

	public CB2DVector direction = new CB2DVector();	
	public double rotation;
	public boolean steerOnly; 
	public CB2DVector orbitOffset = new CB2DVector(); 
	public boolean orbitMode;

}
