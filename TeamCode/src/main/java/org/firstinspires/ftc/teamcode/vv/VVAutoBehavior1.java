package org.firstinspires.ftc.teamcode.vv;

import org.montclairrobotics.cyborg.Cyborg;
import org.montclairrobotics.cyborg.behaviors.CBAutonomous;

/**
 * Created by rich on 9/24/2016.
 */

public class VVAutoBehavior1 extends CBAutonomous {
    public VVAutoBehavior1(Cyborg robot) {
        super(robot);
    }

    @Override
    public void init() {
        Cyborg.hardwareAdapter.robot.telemetry.addLine("auto init");
        Cyborg.hardwareAdapter.robot.telemetry.update();
    }

    @Override
    public void update() {
        Cyborg.hardwareAdapter.robot.telemetry.addLine("auto update");
        Cyborg.hardwareAdapter.robot.telemetry.update();
    }
}
