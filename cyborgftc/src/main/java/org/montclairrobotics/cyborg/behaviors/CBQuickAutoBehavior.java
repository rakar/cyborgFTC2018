package org.montclairrobotics.cyborg.behaviors;

import org.montclairrobotics.cyborg.Cyborg;
import org.montclairrobotics.cyborg.core.behaviors.CBAutonomous;

/**
 * Created by rich on 9/24/2016.
 */

public class CBQuickAutoBehavior extends CBAutonomous {
    public CBQuickAutoBehavior(Cyborg robot) {
        super(robot);
    }

    @Override
    public void init() {
        Cyborg.hardwareAdapter.robot.quickInit();
    }

    @Override
    public void update() {
        Cyborg.hardwareAdapter.robot.quickUpdate();
    }
}
