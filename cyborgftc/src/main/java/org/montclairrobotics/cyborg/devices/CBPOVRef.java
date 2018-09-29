package org.montclairrobotics.cyborg.devices;

import org.montclairrobotics.cyborg.core.utils.CBEnums;

public class CBPOVRef {
	public CBEnums.CBJoystickId stickID;
	public CBEnums.CBPOVId index;
	
	public CBPOVRef() {
		stickID  = CBEnums.CBJoystickId.Undefined;
		index = CBEnums.CBPOVId.Undefined;
	}
	
	public CBPOVRef(CBEnums.CBJoystickId stickID, CBEnums.CBPOVId index) {
		this.stickID = stickID;
		this.index = index;
	}
	
	public boolean isDefined() {
		return stickID!= CBEnums.CBJoystickId.Undefined && index!= CBEnums.CBPOVId.Undefined;
	}
	
	public static CBPOVRef undefined() {
		return new CBPOVRef(CBEnums.CBJoystickId.Undefined, CBEnums.CBPOVId.Undefined);
	}
}
