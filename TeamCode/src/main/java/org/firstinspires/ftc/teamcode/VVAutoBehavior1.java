package org.firstinspires.ftc.teamcode;

import org.montclairrobotics.cyborg.behaviors.CBAutoBehavior;
import org.montclairrobotics.cyborg.Cyborg;

/**
 * Created by rich on 9/24/2016.
 */

public class VVAutoBehavior1 extends CBAutoBehavior {
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
