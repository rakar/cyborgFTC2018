package org.montclairrobotics.cyborgftc.devices;

import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;

import org.montclairrobotics.cyborgftc.Cyborg;

/**
 * Created by rich on 10/1/2016.
 */

public class CBUltrasonicSensor implements CBDevice {
    String name;
    UltrasonicSensor ultrasonicSensor;

    public CBUltrasonicSensor(String name) {
        this.name = name;
        this.ultrasonicSensor = Cyborg.hardwareAdapter.robot.hardwareMap.ultrasonicSensor.get(name);
    }

    public double getUltrasonicLevel() {
        return ultrasonicSensor.getUltrasonicLevel();
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
        return ultrasonicSensor.status();
    }

    public void resetDeviceConfigurationForOpMode() {
        ultrasonicSensor.resetDeviceConfigurationForOpMode();
    }

    public String getConnectionInfo() {
        return ultrasonicSensor.getConnectionInfo();
    }

    public String getDeviceName() {
        return ultrasonicSensor.getDeviceName();
    }

    public HardwareDevice.Manufacturer getManufacturer() {
        return ultrasonicSensor.getManufacturer();
    }

    public int getVersion() {
        return ultrasonicSensor.getVersion();
    }

}
