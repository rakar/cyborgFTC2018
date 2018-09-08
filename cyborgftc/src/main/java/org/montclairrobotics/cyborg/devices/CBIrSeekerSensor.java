package org.montclairrobotics.cyborg.devices;

import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.IrSeekerSensor;

import org.montclairrobotics.cyborg.Cyborg;

/**
 * Created by rich on 10/1/2016.
 */

public class CBIrSeekerSensor implements CBDevice {
    String name;
    IrSeekerSensor irSeekerSensor;

    public CBIrSeekerSensor(String name) {
        this.name = name;
        this.irSeekerSensor = Cyborg.hardwareAdapter.robot.hardwareMap.irSeekerSensor.get(name);
    }

    public double getAngle() {
        return irSeekerSensor.getAngle();
    }

    public I2cAddr getI2cAddress() {
        return irSeekerSensor.getI2cAddress();
    }

    public IrSeekerSensor.Mode getMode() {
        return irSeekerSensor.getMode();
    }

    public double getSignalDetectedThreshold() {
        return irSeekerSensor.getSignalDetectedThreshold();
    }

    public double getStrength() {
        return irSeekerSensor.getStrength();
    }

    public CBIrSeekerSensor setI2cAddress(I2cAddr address) {
        irSeekerSensor.setI2cAddress(address);
        return this;
    }

    public CBIrSeekerSensor setMode(IrSeekerSensor.Mode mode) {
        irSeekerSensor.setMode(mode);
        return this;
    }

    public CBIrSeekerSensor setSignalDetectedThreshold(double threshold) {
        irSeekerSensor.setSignalDetectedThreshold(threshold);
        return this;
    }

    public boolean signalDetected() {
        return irSeekerSensor.signalDetected();
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

    public void resetDeviceConfigurationForOpMode() {
        irSeekerSensor.resetDeviceConfigurationForOpMode();
    }

    public String getConnectionInfo() {
        return irSeekerSensor.getConnectionInfo();
    }

    public String getDeviceName() {
        return irSeekerSensor.getDeviceName();
    }

    public HardwareDevice.Manufacturer getManufacturer() {
        return irSeekerSensor.getManufacturer();
    }

    public int getVersion() {
        return irSeekerSensor.getVersion();
    }

}
