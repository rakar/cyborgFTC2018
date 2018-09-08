package org.montclairrobotics.cyborgftc.behaviors;

import org.montclairrobotics.cyborgftc.Cyborg;
import org.montclairrobotics.cyborgftc.data.CBStdDriveControlData;
import org.montclairrobotics.cyborgftc.data.CBStdDriveRequestData;
import org.montclairrobotics.cyborgftc.utils.*;

//
// Requires:
// DriveRequestData => CBStdDriveRequestData
// DriveControlData => CBStdDriveControlData
//

public class CBStdDriveBehavior extends CBBehavior {
	CBEdgeTrigger gyroLockState;
	CBErrorCorrection gyroLockTracker=null;

	CBStdDriveRequestData drd;
	CBStdDriveControlData dcd;

	public CBStdDriveBehavior(Cyborg robot) {
		super(robot);
		drd = (CBStdDriveRequestData)Cyborg.driveRequestData;
		dcd = (CBStdDriveControlData)Cyborg.driveControlData;
		gyroLockState = new CBEdgeTrigger();
	}

	public CBStdDriveBehavior setGyroLockTracker(CBErrorCorrection pid) {
		this.gyroLockTracker = pid;
		return this;
	}

	@Override
	public void init() {

	}

	@Override
	public void update() {
		//super.update();

		dcd.active = drd.active;
		if(dcd.active) {
			dcd.direction.copy(drd.direction);
			dcd.rotation = drd.rotation;

			gyroLockState.update(drd.gyroLock);
			if(gyroLockTracker!=null) {
				if(gyroLockState.getRisingEdge()) gyroLockTracker.setTarget(drd.gyroLockSource);
				if(gyroLockState.getState()) dcd.rotation = gyroLockTracker.update(drd.gyroLockSource);
			}

			//
			// Turn off request.active to indicate that command was handled. 
			// This will prevent re-processing a given request. For example
			// Autonomous may only issue drive requests periodically.
			//  
			drd.active = false;
		}
	}
}
