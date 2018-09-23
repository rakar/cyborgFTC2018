package org.montclairrobotics.cyborg.devices;

import com.qualcomm.robotcore.hardware.TouchSensor;

import org.montclairrobotics.cyborg.Cyborg;
import org.montclairrobotics.cyborg.utils.CBEdgeTrigger;

/**
 * Created by rich on 9/25/2016.
 *
 * The primary implementation of TouchSensor is as a digital button with all of the
 * standard button edge trigger events.
 * Some touch sensors can have an analog value, so getRawValue() is implemented
 * to read analog values.
 */

public class CBTouchSensor extends CBEdgeTrigger implements CBDevice {
    String name;
    TouchSensor touchSensor;
    double value;

    public CBTouchSensor(String name) {
        this.name = name;
        this.touchSensor = Cyborg.hardwareAdapter.robot.hardwareMap.touchSensor.get(name);
        value = 0;
    }

    public double getRawValue() {
        return  value;
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
            value = touchSensor.getValue();
            update(touchSensor.isPressed());
        }

        @Override
        public void controlUpdate() {

        }
    };
}
