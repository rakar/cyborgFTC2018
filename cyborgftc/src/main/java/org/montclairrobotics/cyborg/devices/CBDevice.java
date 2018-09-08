package org.montclairrobotics.cyborg.devices;

//import com.qualcomm.robotcore.hardware.HardwareDevice;

public interface CBDevice {
	
	public void configure();
	public void senseUpdate();
	public void controlUpdate();

}
