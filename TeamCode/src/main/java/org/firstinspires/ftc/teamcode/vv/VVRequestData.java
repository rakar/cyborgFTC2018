package org.firstinspires.ftc.teamcode.vv;

import org.montclairrobotics.cyborg.core.data.CBRequestData;
import org.montclairrobotics.cyborg.core.data.CBTankDriveRequestData;

/**
 * Created by rich on 9/24/2016.
 */

public class VVRequestData extends CBRequestData {
    public CBTankDriveRequestData drivetrain = new CBTankDriveRequestData();
    public double trigger=0;
}
