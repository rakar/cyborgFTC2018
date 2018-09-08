package org.montclairrobotics.cyborgftc.assemblies;

import java.util.ArrayList;

import org.montclairrobotics.cyborgftc.Cyborg;
import org.montclairrobotics.cyborgftc.devices.CBDeviceId;
import org.montclairrobotics.cyborgftc.devices.CBSpeedController;
import org.montclairrobotics.cyborgftc.utils.CBErrorCorrection;
import org.montclairrobotics.cyborgftc.utils.CBEnums.CBDriveMode;
//import org.montclairrobotics.cyborgftc.utils.CBEnums.CBEncoderScheme;

public abstract class CBSpeedControllerArrayController {
	protected ArrayList<CBSpeedController> speedControllers = new ArrayList<>();
	
//	protected CBEncoder encoder = null;
	protected CBErrorCorrection errorCorrection = null;
//	protected CBEncoderScheme encoderScheme = CBEncoderScheme.None;
	
	protected CBDriveMode driveMode = CBDriveMode.Power;

	protected boolean reversed=false;
	protected int direction=1;

	public CBSpeedControllerArrayController setErrorCorrection(CBErrorCorrection errorCorrection){
		this.errorCorrection = errorCorrection;
		return this;
	};

	public CBSpeedControllerArrayController setDriveMode(CBDriveMode driveMode) {
		this.driveMode = driveMode;
		return this;
	}
	
	public CBSpeedControllerArrayController setReversed(boolean reversed) {
		this.reversed = reversed;
		this.direction = reversed?-1:1;
		return this;
	}
	
	/* (non-Javadoc)
	 * @see org.montclairrobotics.cyborg.devices.CBSpeedControllerArrayController#addSpeedController(org.montclairrobotics.cyborg.devices.CBSpeedController)
	 */
	public CBSpeedControllerArrayController addSpeedController(CBDeviceId controllerId) {
		speedControllers.add(Cyborg.hardwareAdapter.getSpeedController(controllerId));
		return this;
	}


	public abstract CBSpeedControllerArrayController update(double target);

	/* (non-Javadoc)
	 * @see org.montclairrobotics.cyborg.devices.CBSpeedControllerArrayController#getReversed()
	 */
	public boolean getReversed() {
		return reversed;
	}
	

//	public CBSpeedControllerArrayController setEncoder(CBDeviceId encoderId) {
//		this.encoder = Cyborg.hardwareAdapter.getEncoder(encoderId);
//		return this;
//	}
	
//	public CBSpeedControllerArrayController setEncoderScheme(CBEncoderScheme encoderScheme) {
//		this.encoderScheme = encoderScheme;
//		return this;
//	}

	public CBDriveMode getDriveMode() {
		return driveMode;
	}

	public abstract double get();

}