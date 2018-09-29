package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.ct.CTRobot;
import org.montclairrobotics.cyborg.behaviors.CBQuickAutoBehavior;

@Autonomous(name = "Auto2", group="cyborg")
public class CTAuto2 extends CTRobot {
    @Override
    public void cyborgInit() {
        super.cyborgInit();
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
}
