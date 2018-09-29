package org.firstinspires.ftc.teamcode.ct;

import org.montclairrobotics.cyborg.Cyborg;
import org.montclairrobotics.cyborg.behaviors.CBBehavior;

public class CTTraceBehavior extends CBBehavior {
    private String id;

    public CTTraceBehavior(Cyborg robot, String id) {
        super(robot);
        this.id = id;
    }

    @Override
    public void init() {
        robot.logMessage("CTTraceBehavior: init - "+id);
    }

    @Override
    public void update() {
        robot.logMessage("CTTraceBehavior: update - "+id);
    }
}
