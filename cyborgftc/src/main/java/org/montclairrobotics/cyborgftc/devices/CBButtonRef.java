package org.montclairrobotics.cyborgftc.devices;

import org.montclairrobotics.cyborgftc.utils.CBEnums;

// TODO: Split CBPOVRef into separate classes for Axis, POV, Button (Enums too).

public class CBButtonRef {
	public CBEnums.CBJoystickId stickId;
	public CBEnums.CBButtonId index;

	public CBButtonRef() {
		stickId = CBEnums.CBJoystickId.Undefined;
		index = CBEnums.CBButtonId.Undefined;
	}

	public CBButtonRef(CBEnums.CBJoystickId stickId, CBEnums.CBButtonId index) {
		this.stickId = stickId;
		this.index = index;
	}
	
	public boolean isDefined() {
		return stickId != CBEnums.CBJoystickId.Undefined && index!= CBEnums.CBButtonId.Undefined;
	}
	
	public static CBButtonRef undefined() {
		return new CBButtonRef(CBEnums.CBJoystickId.Undefined, CBEnums.CBButtonId.Undefined);
	}
}
