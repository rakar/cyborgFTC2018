package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.icds.ICDSRobot;
import org.montclairrobotics.cyborg.core.mappers.CBArcadeDriveMapper;

@TeleOp(name="ICDSTeleOp", group="cyborg")
public class ICDSTeleOp extends ICDSRobot {
    @Override
    public void opModeInit() {
        logMessage("adding TeleOpMapper",false);
        this.addTeleOpMapper(
                new CBArcadeDriveMapper(this, requestData.drivetrain)
                        .setAxes(axisForward, axisStrafe, axisRotate)
        );
        logMessage("added TeleOpMapper",false);
    }
}
