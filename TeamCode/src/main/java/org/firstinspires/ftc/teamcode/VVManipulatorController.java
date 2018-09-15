package org.firstinspires.ftc.teamcode;

import org.montclairrobotics.cyborg.Cyborg;
import org.montclairrobotics.cyborg.controllers.CBRobotController;
import org.montclairrobotics.cyborg.devices.CBDeviceID;
import org.montclairrobotics.cyborg.devices.CBServo;

/**
 * Created by rich on 9/24/2016.
 */

public class VVManipulatorController extends CBRobotController {
    CBServo servo;
    VVCustomControlData ccd;

    public VVManipulatorController(Cyborg robot) {
        super(robot);
        ccd = (VVCustomControlData)Cyborg.customControlData;
    }

    public VVManipulatorController setTrigServer(CBDeviceID deviceId) {
        servo = Cyborg.hardwareAdapter.getServo(deviceId);
        return this;
    }

    @Override
    public void update() {
        servo.setPosition(ccd.servoPos);
    }

    @Override
    public void configHardware() {

    }
}
