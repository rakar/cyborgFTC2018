package org.montclairrobotics.cyborgftc.devices;

import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

import org.montclairrobotics.cyborgftc.Cyborg;

/**
 * Created by rich on 10/1/2016.
 */

public class CBOpticalDistanceSensor implements CBDevice {
    String name;
    OpticalDistanceSensor opticalDistanceSensor;

    public CBOpticalDistanceSensor(String name) {
        this.name = name;
        this.opticalDistanceSensor = Cyborg.hardwareAdapter.robot.hardwareMap.opticalDistanceSensor.get(name);
    }

    @Override
    public void configure() {

    }

    @Override
    public void senseUpdate() {

    }

    @Override
    public void controlUpdate() {

    }

    double getRawLightDetected() {
        return opticalDistanceSensor.getRawLightDetected();
    }

    double getRawLightDetectedMax() {
        return opticalDistanceSensor.getRawLightDetectedMax();
    }

    double getLightDetected() {
        return opticalDistanceSensor.getLightDetected();
    }

    String status() {
        return opticalDistanceSensor.status();
    }

    void enableLed(boolean enable) {
        opticalDistanceSensor.enableLed(enable);
    }

    public void resetDeviceConfigurationForOpMode(){
        opticalDistanceSensor.resetDeviceConfigurationForOpMode();
    }

    public String getConnectionInfo() {
        return opticalDistanceSensor.getConnectionInfo();
    }

    public String getDeviceName() {
        return opticalDistanceSensor.getDeviceName();
    }

    public HardwareDevice.Manufacturer getManufacturer() {
        return opticalDistanceSensor.getManufacturer();
    }

    public int getVersion() {
        return opticalDistanceSensor.getVersion();
    }

}
