package org.montclairrobotics.cyborg.devices;

public abstract class CBSpeedController implements CBDevice {
	String name,subsystem;
	protected CBSpeedControllerFaultCriteria faultCriteria;


	public abstract CBSpeedController pidWrite(double output);

	public abstract double get();

	//CBSpeedController set(double speed, byte syncGroup);

	public abstract CBSpeedController set(double speed);

	public abstract CBSpeedController setInverted(boolean isInverted);

	public abstract boolean getInverted();

	public abstract CBSpeedController disable();

	public abstract CBSpeedController stopMotor();

	public double getActualCurrent() {
		throw new RuntimeException("Current monitoring not available in FTC.");
	}

	public CBSpeedControllerFault getSpeedControllerFault() {
		throw new RuntimeException("Current monitoring not available in FTC.");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName(String subsystem, String name) {
		setSubsystem(subsystem);
		setName(name);
	}

	public String getSubsystem() {
		return subsystem;
	}

	public void setSubsystem(String subsystem) {
		this.subsystem = subsystem;
	}

	public CBSpeedController setDeviceName(String name) {
		setName(name);
		return this;
	}

	public CBSpeedController setDeviceName(String subsystem, String name) {
		setName(subsystem, name);
		return this;
	}
}