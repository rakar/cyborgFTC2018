package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by rich on 9/24/2016.
 */
@Autonomous(name = "Auto1", group="cyborg")
public class VVAuto1 extends VVRobot {

    public void opModeInit() {
        opModeName = "Auto1";
        teleOp = false;
        addAutonomous(new VVAutoBehavior1());
    }
}
