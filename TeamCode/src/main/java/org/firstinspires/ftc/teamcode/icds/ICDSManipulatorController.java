package org.firstinspires.ftc.teamcode.icds;

import org.montclairrobotics.cyborg.Cyborg;
import org.montclairrobotics.cyborg.core.assemblies.CBServoArray;
import org.montclairrobotics.cyborg.core.controllers.CBRobotController;

public class ICDSManipulatorController extends CBRobotController {
    ICDSRobot me;
    CBServoArray jawServoArray;

    public ICDSManipulatorController(Cyborg robot) {
        super(robot);
        me = (ICDSRobot)robot;
    }

    public ICDSManipulatorController setJawServoArray(CBServoArray servoArray) {
        jawServoArray = servoArray;
        return this;
    }

    @Override
    public void update() {
        if(jawServoArray!=null) jawServoArray.update(me.controlData.jawPosition);
    }
}
