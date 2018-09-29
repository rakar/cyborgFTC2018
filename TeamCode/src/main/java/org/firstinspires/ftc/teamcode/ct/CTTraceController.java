package org.firstinspires.ftc.teamcode.ct;

import org.montclairrobotics.cyborg.Cyborg;
import org.montclairrobotics.cyborg.controllers.CBRobotController;

public class CTTraceController extends CBRobotController {
    String id;

    public CTTraceController(Cyborg robot, String id) {
        super(robot);
        this.id=id;
    }

    @Override
    public void init() {
        robot.logMessage("CTTraceController: init - "+id);
    }

    @Override
    public void update() {
        robot.logMessage("CTTraceController: update - "+id);

    }
}
