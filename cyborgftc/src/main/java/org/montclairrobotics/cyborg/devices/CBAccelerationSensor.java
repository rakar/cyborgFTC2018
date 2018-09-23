package org.montclairrobotics.cyborg.devices;

import com.qualcomm.robotcore.hardware.AccelerationSensor;
import com.qualcomm.robotcore.hardware.HardwareDevice;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.montclairrobotics.cyborg.Cyborg;

/**
 * Created by rich on 9/30/2016.
 */

public class CBAccelerationSensor implements CBDevice {
    String name;
    AccelerationSensor accelerationSensor;
    Acceleration acceleration;
    boolean accelerationUpdated;

    public CBAccelerationSensor(String name) {
        this.name = name;
        this.accelerationSensor = Cyborg.hardwareAdapter.robot.hardwareMap.accelerationSensor.get(name);
        accelerationUpdated = false;
    }

    public Acceleration getAcceleration() {
        if(!accelerationUpdated) {
            acceleration = accelerationSensor.getAcceleration();
            accelerationUpdated = true;
        }
        return acceleration;
    }

    public String getStatus() {
        return accelerationSensor.status();
    }

    public void resetDeviceConfigurationForOpMode() {
        accelerationSensor.resetDeviceConfigurationForOpMode();
    }

    public String getConnectionInfo() {
        return accelerationSensor.getConnectionInfo();
    }

    public String getDeviceName() {
        return accelerationSensor.getDeviceName();
    }

    public HardwareDevice.Manufacturer getManufacturer() {
        return accelerationSensor.getManufacturer();
    }

    public int getVersion() {
        return accelerationSensor.getVersion();
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
}
