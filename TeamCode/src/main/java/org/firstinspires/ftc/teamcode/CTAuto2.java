package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.ct.CTRobot;
import org.montclairrobotics.cyborg.behaviors.CBQuickAutoBehavior;

@Autonomous(name = "Auto2", group="cyborg")
public class CTAuto2 extends CTRobot {
    @Override
    public void opModeInit() {
        opModeName = "Auto2";
        teleOp = false;
        addAutonomous(new CBQuickAutoBehavior(this));
    }

    @Override
    public void quickInit() {

        logMessage("Auto Quick Init");
    }

    @Override
    public void quickUpdate() {
        logMessage("Quick Update");
    }

    @Override
    public void cyborgTestInit() {

    }

    @Override
    public void cyborgTestPeriodic() {

    }

    @Override
    public void cyborgTeleopInit() {

    }
}
