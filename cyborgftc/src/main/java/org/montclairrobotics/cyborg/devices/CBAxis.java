package org.montclairrobotics.cyborg.devices;

import org.montclairrobotics.cyborg.core.utils.CBEnums;

import static org.montclairrobotics.cyborg.Cyborg.hardwareAdapter;

public class CBAxis extends CBAxisRef implements CBDevice {
	double value;
	double deadzone;
	double smoothing;
	double lastValue;
	double scale=1.0;
	CBJoystick joystick;

	public CBAxis(CBAxisRef axis) {
		this(axis.stickID,axis.index);
	}

	public CBAxis(CBEnums.CBJoystickId stickID, CBEnums.CBAxisId index) {
		super(stickID, index);
		joystick = hardwareAdapter.getJoystick(stickID);
	}
	
	public CBAxis setDeadzone(double deadzone){
		this.deadzone = deadzone;
		return this;
	}

	public CBAxis setScale(double scale){
		this.scale = scale;
		return this;
	}

	public CBAxis setSmoothing(double smoothing){
		this.smoothing = smoothing;
		return this;
	}

	public static CBAxis getDefaulted(CBAxis axis) {
		return (axis != null) ? axis : new CBAxis(CBAxisRef.undefined());
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
			if (isDefined()) {
				value = joystick.getRawAxis(index);
			} else {
				value = 0;
			}
		}

		@Override
		public void controlUpdate() {
		}
	};

	public double get() {
		double res = scale * value;
		if (smoothing != 0) {
			res = lastValue + (res - lastValue) * smoothing;
		}
		if (Math.abs(res) < deadzone) res = 0.0;
		lastValue = value;
		return res;
	}

	public double getRaw() {
		hardwareAdapter.robot.telemetry.addData("axis",value);
		return value;
	}
}
