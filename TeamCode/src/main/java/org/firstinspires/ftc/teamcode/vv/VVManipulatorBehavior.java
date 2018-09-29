package org.firstinspires.ftc.teamcode.vv;

import org.montclairrobotics.cyborg.core.behaviors.CBBehavior;

/**
 * Created by rich on 9/24/2016.
 */

public class VVManipulatorBehavior extends CBBehavior {
    VVRequestData crd;
    VVControlData ccd;

    public VVManipulatorBehavior(VVRobot robot) {
        super(robot);
        crd = robot.requestData;
        ccd = robot.controlData;
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {
        ccd.servoPos = Math.abs(crd.trigger);
        robot.telemetry.addData("behaviorTrigger:", ccd.servoPos);
    }
}
