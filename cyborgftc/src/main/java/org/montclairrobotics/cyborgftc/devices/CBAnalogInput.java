package org.montclairrobotics.cyborgftc.devices;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.HardwareDevice;

import org.montclairrobotics.cyborgftc.Cyborg;

/**
 * Created by rich on 9/25/2016.
 */

public class CBAnalogInput implements CBDevice {
    String name;
    AnalogInput analogInput;
    boolean voltageUpdated;
    double voltage;
    boolean maxVoltageUpdated;
    double maxVoltage;


    public CBAnalogInput(String name) {
        this.name = name;
        this.analogInput = Cyborg.hardwareAdapter.robot.hardwareMap.analogInput.get(name);
        voltageUpdated = false;
    }

    public double getVoltage() {
        if (!voltageUpdated) {
            voltage = analogInput.getVoltage();
        }
        return voltage;
    }

    public double getMaxVoltage() {
        if (!maxVoltageUpdated) {
            maxVoltage = analogInput.getMaxVoltage();
        }
        return maxVoltage;
    }

    public CBAnalogInput close() {
        analogInput.close();
        return  this;
    }

    public CBAnalogInput resetDeviceConfigurationForOpMode() {
        analogInput.resetDeviceConfigurationForOpMode();
        return  this;
    }

    public String getConnectionInfo() {
        return analogInput.getConnectionInfo();
    }

    public String getDeviceName() {
        return analogInput.getDeviceName();
    }

    public HardwareDevice.Manufacturer getManufacturer() {
        return analogInput.getManufacturer();
    }

    public int getVersion() {
        return analogInput.getVersion();
    }




    @Override
    public void configure() {

    }

    @Override
    public void senseUpdate() {
        voltageUpdated = false;
        maxVoltageUpdated = false;
    }

    @Override
    public void controlUpdate() {

    }
}
