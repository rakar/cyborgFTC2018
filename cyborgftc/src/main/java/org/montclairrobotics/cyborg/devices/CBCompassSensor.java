package org.montclairrobotics.cyborg.devices;

import com.qualcomm.robotcore.hardware.CompassSensor;
import com.qualcomm.robotcore.hardware.HardwareDevice;

import org.montclairrobotics.cyborg.Cyborg;

/**
 * Created by rich on 10/1/2016.
 */

public class CBCompassSensor implements CBDevice {
    String name;
    CompassSensor compassSensor;

    public CBCompassSensor(String name) {
        this.name = name;
        this.compassSensor = Cyborg.hardwareAdapter.robot.hardwareMap.compassSensor.get(name);
    }

    public boolean calibrationFailed() {
        return compassSensor.calibrationFailed();
    }

    public double getDirection() {
        return compassSensor.getDirection();
    }

    public CBCompassSensor setMode(CompassSensor.CompassMode mode) {
        compassSensor.setMode(mode);
        return this;
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

    public String getStatus() {
        return compassSensor.status();
    }

    public void resetDeviceConfigurationForOpMode() {
        compassSensor.resetDeviceConfigurationForOpMode();
    }

    public String getConnectionInfo() {
        return compassSensor.getConnectionInfo();
    }

    public String getDeviceName() {
        return compassSensor.getDeviceName();
    }

    public HardwareDevice.Manufacturer getManufacturer() {
        return compassSensor.getManufacturer();
    }

    public int getVersion() {
        return compassSensor.getVersion();
    }

}
