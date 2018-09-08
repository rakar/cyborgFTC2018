package org.montclairrobotics.cyborgftc.devices;

import com.qualcomm.robotcore.hardware.HardwareDevice;

import org.montclairrobotics.cyborgftc.Cyborg;
import org.montclairrobotics.cyborgftc.utils.CBEnums;

public class CBAxis extends CBAxisRef implements CBDevice {
	double value;
	double deadzone;
	double smoothing;
	double lastValue;
	double scale=1.0;
	CBJoystick joystick;

	public CBAxis(CBEnums.CBJoystickId stickID, CBEnums.CBAxisId index) {
		super(stickID, index);
		joystick = Cyborg.hardwareAdapter.getJoystick(stickID);
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

	@Override
	public void configure() {
	}

	@Override
	public void senseUpdate() {
		if(this.isDefined()) {
			value = joystick.getRawAxis(index);
		} else {
			value = 0;
		}
	}

	@Override
	public void controlUpdate() {
	}

	public double get() {
		double res = scale * value;
		if(smoothing!=0) {
			res = lastValue + (res - lastValue)*smoothing;
		}
		if(Math.abs(res)<deadzone) res = 0.0;
		lastValue = value;
		return res;
	}
	
	public double getRaw() {
		Cyborg.hardwareAdapter.robot.telemetry.addData("axis",value);
		return value;
	}

}
