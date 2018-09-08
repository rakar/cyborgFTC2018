package org.montclairrobotics.cyborgftc.devices;

import com.qualcomm.robotcore.hardware.AnalogOutput;
import com.qualcomm.robotcore.hardware.HardwareDevice;

import org.montclairrobotics.cyborgftc.Cyborg;

/**
 * Created by rich on 9/25/2016.
 */

public class CBAnalogOutput implements CBDevice {
    String name;
    AnalogOutput analogOutput;
    double value;

    public CBAnalogOutput(String name) {
        this.name = name;
        this.analogOutput = Cyborg.hardwareAdapter.robot.hardwareMap.analogOutput.get(name);
    }

    public CBAnalogOutput setAnalogOutputMode(byte mode) {
        analogOutput.setAnalogOutputMode(mode);
        return this;
    }

    public CBAnalogOutput setAnalogOutputFrequency(int freq) {
        analogOutput.setAnalogOutputFrequency(freq);
        return this;
    }

    public CBAnalogOutput setAnalogOutputMode(int voltage) {
        analogOutput.setAnalogOutputVoltage(voltage);
        return this;
    }

    public CBAnalogOutput close() {
        analogOutput.close();
        return  this;
    }

    public CBAnalogOutput resetDeviceConfigurationForOpMode() {
        analogOutput.resetDeviceConfigurationForOpMode();
        return  this;
    }

    public String getConnectionInfo() {
        return analogOutput.getConnectionInfo();
    }

    public String getDeviceName() {
        return analogOutput.getDeviceName();
    }

    public HardwareDevice.Manufacturer getManufacturer() {
        return analogOutput.getManufacturer();
    }

    public int getVersion() {
        return analogOutput.getVersion();
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
}
