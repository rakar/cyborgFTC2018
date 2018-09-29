package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.vv.VVRobot;
import org.montclairrobotics.cyborg.core.behaviors.CBQuickAutoBehavior;

/**
 * Created by rich on 9/24/2016.
 */
@Autonomous(name="VVAuto2", group="cyborg")
@Disabled
public class VVAuto2 extends VVRobot {
    @Override
    public void opModeInit() {
        addAutonomous(new CBQuickAutoBehavior(this));
    }

    // If you use CBQuickAutoBehavior as at least one of your
    // Autonomous Behaviors, you can add quickInit() and quickUpdate()
    // functionality here.
    @Override
    public void quickInit() {

        logMessage("Quick Init");
    }

    @Override
    public void quickUpdate() {
        logMessage("Quick Update");
    }
}
