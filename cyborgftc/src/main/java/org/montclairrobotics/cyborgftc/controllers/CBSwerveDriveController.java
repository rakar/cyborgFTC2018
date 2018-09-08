package org.montclairrobotics.cyborgftc.controllers;

import org.montclairrobotics.cyborgftc.Cyborg;
import org.montclairrobotics.cyborgftc.assemblies.CBDriveModule;
import org.montclairrobotics.cyborgftc.assemblies.CBSwerveDriveModule;
import org.montclairrobotics.cyborgftc.data.CBStdDriveControlData;
import org.montclairrobotics.cyborgftc.utils.CB2DVector;

public class CBSwerveDriveController extends CBDriveController {

	public CBSwerveDriveController(Cyborg robot) {
		super(robot);
	}

	@Override
	public void update() {
		if(Cyborg.driveControlData.active) {
			if(Cyborg.driveControlData instanceof CBStdDriveControlData) {
				
				CBStdDriveControlData dcd = (CBStdDriveControlData)Cyborg.driveControlData;
				for(CBDriveModule dm:driveModules) {
					updateModule(
							(CBSwerveDriveModule)dm, dcd.direction, dcd.rotation,
							dcd.orbitOffset, dcd.orbitMode, dcd.steerOnly
							);
				}				

			} else {
				
				System.out.println("Error: Invalid DriveControlStatus for DifferentialDriveController");
				
			}
		}
	}

	protected void updateModule(CBSwerveDriveModule module, CB2DVector direction, double rotation,
			CB2DVector orbitOffset, boolean orbitMode, boolean steerOnly) {
		
		// Calculate the effective offset
		// based on the offset from standard center
		// and the orbit offset
		CB2DVector effectiveOffset = new CB2DVector(module.getPosition()); 
		if (orbitMode) {
			effectiveOffset = effectiveOffset.sub(orbitOffset); 
		}
		
		// Calculate the target position for this module,
		// in other words calculate the position this module should be at by the next cycle
		// Rotate the module position by the rotation amount
		// Translate component
		// Calculate the net change from the original effective location
		CB2DVector Diff = effectiveOffset
				.scaledRotate(rotation, controlPeriod)
				.scaledTranslate(direction, controlPeriod)
				.sub(effectiveOffset);

		// Given the desired net change in module position calculate the angle and speed
		// the wheel should use to go there.
		double angle = Diff.getAngleDeg();
		double speed = 0.0;
		if(!steerOnly) {
			speed = Diff.getMag();
		}

		module.update(angle, speed);
	}
	
	public CBSwerveDriveController addDriveModule(CBDriveModule driveModule) {
		return (CBSwerveDriveController)super.addDriveModule(driveModule);
	}

	@Override
	public CBSwerveDriveController setControlPeriod(double controlPeriod) {
		return (CBSwerveDriveController)super.setControlPeriod(controlPeriod);
	}
}
