package org.firstinspires.ftc.teamcode;

import org.montclairrobotics.cyborgftc.Cyborg;
import org.montclairrobotics.cyborgftc.behaviors.CBBehavior;

/**
 * Created by rich on 9/24/2016.
 */

public class VVManipulatorBehavior extends CBBehavior {
    VVCustomRequestData crd;
    VVCustomControlData ccd;

    public VVManipulatorBehavior(Cyborg robot) {
        super(robot);
        crd = (VVCustomRequestData)Cyborg.customRequestData;
        ccd = (VVCustomControlData)Cyborg.customControlData;
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {
        ccd.serverPos = Math.abs(crd.trigger);
        robot.telemetry.addData("behaviorTrigger:", ccd.serverPos);
    }
}
