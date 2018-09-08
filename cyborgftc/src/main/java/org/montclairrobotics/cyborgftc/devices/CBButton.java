package org.montclairrobotics.cyborgftc.devices;

import com.qualcomm.robotcore.hardware.HardwareDevice;

import org.montclairrobotics.cyborgftc.Cyborg;
import org.montclairrobotics.cyborgftc.utils.CBEdgeTrigger;
import org.montclairrobotics.cyborgftc.utils.CBEnums;

public class CBButton extends CBEdgeTrigger implements CBDevice {

	private CBButtonRef buttonRef;
	private CBJoystick joystick;

	public CBButton(CBEnums.CBJoystickId stickID, CBEnums.CBButtonId index) {
		super();
		buttonRef = new CBButtonRef(stickID, index);
		joystick = Cyborg.hardwareAdapter.getJoystick(buttonRef.stickId);
	}

	public boolean isDefined() {
		return buttonRef.isDefined();
	}

	@Override
	public void configure() {
	}

	@Override
	public void senseUpdate() {
		update(joystick.getRawButton(buttonRef.index));
	}

	@Override
	public void controlUpdate() {
	}

}
