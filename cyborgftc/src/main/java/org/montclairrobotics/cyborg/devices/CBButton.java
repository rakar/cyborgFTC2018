package org.montclairrobotics.cyborg.devices;

import org.montclairrobotics.cyborg.Cyborg;
import org.montclairrobotics.cyborg.utils.CBEdgeTrigger;
import org.montclairrobotics.cyborg.utils.CBEnums;

public class CBButton extends CBEdgeTrigger implements CBDevice {

	private CBButtonRef buttonRef;
	private CBJoystick joystick;

	public CBButton(CBButtonRef button) {
		this(button.stickId,button.index);
	}

	public CBButton(CBEnums.CBJoystickId stickID, CBEnums.CBButtonId index) {
		super();
		buttonRef = new CBButtonRef(stickID, index);
		joystick = Cyborg.hardwareAdapter.getJoystick(buttonRef.stickId);
	}

	public static CBButton getDefaulted(CBButton button) {
		return (button!=null)?button:new CBButton(CBButtonRef.undefined());
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
