package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.vv.VVRobot;
import org.montclairrobotics.cyborg.behaviors.CBQuickAutoBehavior;

/**
 * Created by rich on 9/24/2016.
 */
@Autonomous(name="VVAuto2", group="cyborg")
@Disabled
public class VVAuto2 extends VVRobot {
    @Override
    public void autonomousInit() {
        opModeName="VVAuto2";
        teleOp = false;
        addAutonomous(new CBQuickAutoBehavior(this));
    }

    // If you use CBQuickAutoBehavior as at least one of your
    // Autonomous Behaviors, you can add quickInit() and quickUpdate()
    // functionality here.

    @Override
    public void quickInit() {

        telemetry.addLine("Quick Init");
        telemetry.update();
    }

    @Override
    public void quickUpdate() {
        telemetry.addLine("Quick Update");
        telemetry.update();
    }
}
