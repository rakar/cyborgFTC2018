package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.ct.CTRobot;
import org.firstinspires.ftc.teamcode.ct.CTTraceAutonomous;

@Autonomous(name = "Auto1", group="cyborg")
public class CTAuto1 extends CTRobot {
    @Override
    public void opModeInit() {
        opModeName = "Auto1";
        teleOp = false;
        addAutonomous(new CTTraceAutonomous(this, "auto1"));
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
