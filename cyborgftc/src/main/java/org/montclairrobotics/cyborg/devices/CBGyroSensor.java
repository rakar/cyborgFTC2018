package org.montclairrobotics.cyborg.devices;

import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.HardwareDevice;

import org.montclairrobotics.cyborg.Cyborg;

/**
 * Created by rich on 10/1/2016.
 */

public class CBGyroSensor implements CBDevice {
    String name;
    GyroSensor gyroSensor;

    public CBGyroSensor(String name) {
        this.name = name;
        this.gyroSensor = Cyborg.hardwareAdapter.robot.hardwareMap.gyroSensor.get(name);
    }

    public CBGyroSensor calibrate() {
        gyroSensor.calibrate();
        return this;
    }

    public int getHeading() {
        return gyroSensor.getHeading();
    }

    public double getRotationFraction() {
        return gyroSensor.getRotationFraction();
    }

    public boolean isCalibrating() {
        return gyroSensor.isCalibrating();
    }

    public int rawX() {
        return gyroSensor.rawX();
    }

    public int rawY() {
        return gyroSensor.rawX();
    }

    public int rawZ() {
        return gyroSensor.rawX();
    }

    public CBGyroSensor resetZAxisIntegrator() {
        gyroSensor.resetZAxisIntegrator();
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
        return gyroSensor.status();
    }

    public void resetDeviceConfigurationForOpMode() {
        gyroSensor.resetDeviceConfigurationForOpMode();
    }

    public String getConnectionInfo() {
        return gyroSensor.getConnectionInfo();
    }

    public String getDeviceName() {
        return gyroSensor.getDeviceName();
    }

    public HardwareDevice.Manufacturer getManufacturer() {
        return gyroSensor.getManufacturer();
    }

    public int getVersion() {
        return gyroSensor.getVersion();
    }

}
