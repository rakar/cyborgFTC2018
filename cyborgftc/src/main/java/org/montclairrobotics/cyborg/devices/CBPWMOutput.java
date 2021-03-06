package org.montclairrobotics.cyborg.devices;

import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.PWMOutput;

import org.montclairrobotics.cyborg.Cyborg;

/**
 * Created by rich on 10/1/2016.
 */

public class CBPWMOutput implements CBDevice {
    String name;
    PWMOutput pwmOutput;

    public CBPWMOutput(String name) {
        this.name = name;
        pwmOutput = Cyborg.hardwareAdapter.robot.hardwareMap.pwmOutput.get(name);
    }

    double getPulseWidthOutputTime() {
        return pwmOutput.getPulseWidthOutputTime();
    }

    double getPulseWidthPeriod() {
        return pwmOutput.getPulseWidthPeriod();
    }

    CBPWMOutput setPulseWidthOutputTime(int usDuration) {
        pwmOutput.setPulseWidthOutputTime(usDuration);
        return this;
    }

    CBPWMOutput setPulseWidthPeriod(int usFrame) {
        pwmOutput.setPulseWidthPeriod(usFrame);
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
        pwmOutput.resetDeviceConfigurationForOpMode();
    }

    public String getConnectionInfo() {
        return pwmOutput.getConnectionInfo();
    }

    public String getDeviceName() {
        return pwmOutput.getDeviceName();
    }

    public HardwareDevice.Manufacturer getManufacturer() {
        return pwmOutput.getManufacturer();
    }

    public int getVersion() {
        return pwmOutput.getVersion();
    }

}
