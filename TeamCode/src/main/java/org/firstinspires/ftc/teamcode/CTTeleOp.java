package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.ct.CTRobot;
import org.montclairrobotics.cyborg.core.mappers.CBTraceTeleOpMapper;
import org.montclairrobotics.cyborg.mappers.CBArcadeDriveMapper;


@TeleOp(name="Cyborg Test", group="cyborg")
public class CTTeleOp extends CTRobot {

    @Override
    public void opModeInit() {
       logMessage("adding TeleOpMapper",false);
        this.addTeleOpMapper(
                new CBTraceTeleOpMapper(this,"teleop")
        );
        this.addTeleOpMapper(
                new CBArcadeDriveMapper(this, requestData.drivetrain )
                        .setAxes(forwardAxis,strafeAxis,rotateAxis)
                        .setAxisScales(1.0, 1.0, 1.0)
                        .setDebug(true)
        );
        logMessage("added TeleOpMapper",false);
    }
}
