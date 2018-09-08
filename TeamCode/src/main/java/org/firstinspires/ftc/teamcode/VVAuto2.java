package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.montclairrobotics.cyborgftc.behaviors.CBQuickAutoBehavior;

/**
 * Created by rich on 9/24/2016.
 */
@Autonomous(name="VVAuto2", group="cyborg")
public class VVAuto2 extends VVRobot {
    @Override
    public void opModeInit() {
        opModeName="VVAuto2";
        teleOp = false;
        addAutonomous(new CBQuickAutoBehavior());
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
