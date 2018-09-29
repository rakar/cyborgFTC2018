package org.firstinspires.ftc.teamcode.ct;

import org.montclairrobotics.cyborg.Cyborg;
import org.montclairrobotics.cyborg.behaviors.CBAutonomous;

public class CTTraceAutonomous extends CBAutonomous {
    private String id;

    public CTTraceAutonomous(Cyborg robot, String id) {
        super(robot);
        this.id = id;
    }

    @Override
    public void init() {
        robot.logMessage("CTTraceAutonomous: init - "+id);
    }

    @Override
    public void update() {
        robot.logMessage("CTTraceAutonomous: update - "+id);
    }
}
