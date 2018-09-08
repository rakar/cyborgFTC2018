package org.montclairrobotics.cyborg.devices;

import org.montclairrobotics.cyborg.utils.CBEnums;

public class CBAxisRef {
	public CBEnums.CBJoystickId stickID;
	public CBEnums.CBAxisId index;

	public CBAxisRef() {
		stickID  = CBEnums.CBJoystickId.Undefined;
		index = CBEnums.CBAxisId.Undefined;
	}

	public CBAxisRef(CBEnums.CBJoystickId stickID, CBEnums.CBAxisId index) {
		this.stickID = stickID;
		this.index = index;
	}
	
	public boolean isDefined() {
		return stickID!= CBEnums.CBJoystickId.Undefined;
	}
	
	public static CBAxisRef undefined() {
		return new CBAxisRef(CBEnums.CBJoystickId.Undefined, CBEnums.CBAxisId.Undefined);
	}
}
