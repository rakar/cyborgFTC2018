package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.vv.VVAutoBehavior1;
import org.firstinspires.ftc.teamcode.vv.VVRobot;

/**
 * Created by rich on 9/24/2016.
 */
@Autonomous(name = "Auto1", group="cyborg")
@Disabled
public class VVAuto1 extends VVRobot {

    public void autonomousInit() {
        opModeName = "Auto1";
        teleOp = false;
        addAutonomous(new VVAutoBehavior1(this));
    }
}
