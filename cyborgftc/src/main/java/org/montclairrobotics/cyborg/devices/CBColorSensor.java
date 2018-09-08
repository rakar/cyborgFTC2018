package org.montclairrobotics.cyborg.devices;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.I2cAddr;

import org.montclairrobotics.cyborg.Cyborg;

/**
 * Created by rich on 10/1/2016.
 */

public class CBColorSensor implements CBDevice {
    String name;
    ColorSensor colorSensor;

    public CBColorSensor(String name) {
        this.name = name;
        this.colorSensor = Cyborg.hardwareAdapter.robot.hardwareMap.colorSensor.get(name);
    }

    public int alpha() {
        return colorSensor.alpha();
    }

    public int red() {
        return colorSensor.red();
    }

    public int blue() {
        return colorSensor.blue();
    }

    public int green() {
        return colorSensor.green();
    }

    public int argb() {
        return colorSensor.argb();
    }

    public CBColorSensor enableLed(boolean enable) {
        colorSensor.enableLed(enable);
        return this;
    }

    public I2cAddr getI2cAddress() {
        return colorSensor.getI2cAddress();
    }

    public CBColorSensor setI2cAddress(I2cAddr address) {
        colorSensor.setI2cAddress(address);
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

    public void resetDeviceConfigurationForOpMode() {
        colorSensor.resetDeviceConfigurationForOpMode();
    }

    public String getConnectionInfo() {
        return colorSensor.getConnectionInfo();
    }

    public String getDeviceName() {
        return colorSensor.getDeviceName();
    }

    public HardwareDevice.Manufacturer getManufacturer() {
        return colorSensor.getManufacturer();
    }

    public int getVersion() {
        return colorSensor.getVersion();
    }


}
