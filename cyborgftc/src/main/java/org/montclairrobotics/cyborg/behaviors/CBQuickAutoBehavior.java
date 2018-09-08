package org.montclairrobotics.cyborg.behaviors;

import org.montclairrobotics.cyborg.Cyborg;

/**
 * Created by rich on 9/24/2016.
 */

public class CBQuickAutoBehavior extends CBAutoBehavior {
    @Override
    public void init() {
        Cyborg.hardwareAdapter.robot.quickInit();
    }

    @Override
    public void update() {
        Cyborg.hardwareAdapter.robot.quickUpdate();
    }
}
