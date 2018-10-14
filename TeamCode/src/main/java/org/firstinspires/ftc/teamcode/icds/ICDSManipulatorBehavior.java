package org.firstinspires.ftc.teamcode.icds;

import org.montclairrobotics.cyborg.Cyborg;
import org.montclairrobotics.cyborg.core.behaviors.CBBehavior;

public class ICDSManipulatorBehavior extends CBBehavior {
    ICDSRobot me;

    public ICDSManipulatorBehavior(Cyborg robot) {
        super(robot);
        me = (ICDSRobot)robot;
    }

    @Override
    public void update() {
        //Cyborg.hardwareAdapter.robot.logMessage("ICDSManipulatorBehavior Update");
        me.controlData.jawPosition = me.requestData.jawPosition;
    }
}
