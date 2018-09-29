package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.ct.CTRobot;
import org.montclairrobotics.cyborg.behaviors.CBTraceAutonomous;

@Autonomous(name = "Auto1", group="cyborg")
public class CTAuto1 extends CTRobot {
    @Override
    public void opModeInit() {
        addAutonomous(new CBTraceAutonomous(this, "auto1"));
    }
}
