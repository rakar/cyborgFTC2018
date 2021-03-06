package org.montclairrobotics.cyborg.devices;

import org.montclairrobotics.cyborg.Cyborg;
import org.montclairrobotics.cyborg.core.utils.CBEdgeTrigger;
import org.montclairrobotics.cyborg.core.utils.CBEnums;

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
	public CBDeviceControl getDeviceControl() {
		return deviceControl;
	}

	CBDeviceControl deviceControl = new CBDeviceControl() {

		@Override
		public void init() {
		}

		@Override
		public void senseUpdate() {
			update(joystick.getRawButton(buttonRef.index));
		}

		@Override
		public void controlUpdate() {
		}
	};
}
