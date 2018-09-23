package org.montclairrobotics.cyborg.devices;

import com.qualcomm.robotcore.hardware.Servo;

import org.montclairrobotics.cyborg.Cyborg;

/**
 * Created by rich on 9/24/2016.
 */

public class CBServo implements CBDevice {
    String name;
    Servo servo;

    public CBServo(String name) {
        this.name = name;
        this.servo = Cyborg.hardwareAdapter.robot.hardwareMap.servo.get(name);
    }

    public CBServo setRange(double min, double max) {
        servo.scaleRange(min,max);
        return this;
    }

    public CBServo setReversed(boolean reversed) {
        servo.setDirection(reversed? Servo.Direction.REVERSE: Servo.Direction.FORWARD);
        return this;
    }

    public CBServo setPosition(double position) {
        servo.setPosition(position);
        return  this;
    }

    public boolean isReversed() {
        return servo.getDirection()==Servo.Direction.REVERSE;
    }
    public double getPosition() {
        return servo.getPosition();
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
