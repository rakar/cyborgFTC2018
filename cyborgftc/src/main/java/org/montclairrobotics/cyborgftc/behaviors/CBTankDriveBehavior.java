package org.montclairrobotics.cyborgftc.behaviors;

import org.montclairrobotics.cyborgftc.Cyborg;
import org.montclairrobotics.cyborgftc.data.CBDifferentialDriveControlData;
import org.montclairrobotics.cyborgftc.data.CBTankDriveRequestData;

//
// Requires:
// DriveRequestData => CBTankDriveRequestData
// DriveControlData => CBDifferentialDriveControlData
//

public class CBTankDriveBehavior extends CBBehavior {
	CBTankDriveRequestData drd;
	CBDifferentialDriveControlData dcd;


	public CBTankDriveBehavior(Cyborg robot) {
		super(robot);
		drd = (CBTankDriveRequestData)Cyborg.driveRequestData;
		dcd = (CBDifferentialDriveControlData)Cyborg.driveControlData;
	}

	@Override
	public void init() {

	}

	@Override
	public void update() {
		//
		// super.update();
		
		// Copy simple Tank drive command info
		dcd.leftPower = drd.leftPower;
		dcd.rightPower = drd.rightPower;
		dcd.active = drd.active;
		
		//
		// Turn off request.active to indicate that command was handled. 
		// This will prevent re-processing a given request. For example
		// Autonomous may only issue drive requests periodically.
		//  
		drd.active = false;
	}
}
