package org.montclairrobotics.cyborg.devices;

import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.LED;

import org.montclairrobotics.cyborg.Cyborg;

/**
 * Created by rich on 10/1/2016.
 */

public class CBLed implements CBDevice {
    String name;
    LED led;

    public CBLed(String name) {
        this.name = name;
        this.led = Cyborg.hardwareAdapter.robot.hardwareMap.led.get(name);
    }

    public CBLed enable(boolean enable) {
        led.enable(enable);
        return this;
    }

    @Override
    public CBDeviceControl getDeviceControl() {
        return deviceControl;
    }

    CBDeviceControl deviceControl = new CBDeviceControl() {
        @Override
        public void init() {

        }

        @Override
        public void senseUpdate() {

        }

        @Override
        public void controlUpdate() {

        }
    };
    public void resetDeviceConfigurationForOpMode() {
        led.resetDeviceConfigurationForOpMode();
    }

    public String getConnectionInfo() {
        return led.getConnectionInfo();
    }

    public String getDeviceName() {
        return led.getDeviceName();
    }

    public HardwareDevice.Manufacturer getManufacturer() {
        return led.getManufacturer();
    }

    public int getVersion() {
        return led.getVersion();
    }

}
