package org.firstinspires.ftc.teamcode;

import org.montclairrobotics.cyborgftc.Cyborg;
import org.montclairrobotics.cyborgftc.controllers.CBRobotController;
import org.montclairrobotics.cyborgftc.devices.CBDeviceId;
import org.montclairrobotics.cyborgftc.devices.CBServo;

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

    public VVManipulatorController setTrigServer(CBDeviceId deviceId) {
        servo = Cyborg.hardwareAdapter.getServo(deviceId);
        return this;
    }

    @Override
    public void update() {
        servo.setPosition(ccd.serverPos);
    }

    @Override
    public void configHardware() {

    }
}
