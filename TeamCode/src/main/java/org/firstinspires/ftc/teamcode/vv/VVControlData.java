package org.firstinspires.ftc.teamcode.vv;

import org.montclairrobotics.cyborg.data.CBControlData;
import org.montclairrobotics.cyborg.data.CBDifferentialDriveControlData;

/**
 * Created by rich on 9/24/2016.
 */

public class VVControlData extends CBControlData {
    public CBDifferentialDriveControlData drivetrain = new CBDifferentialDriveControlData();
    public double servoPos =0;
}
