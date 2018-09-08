package org.firstinspires.ftc.teamcode;

import org.montclairrobotics.cyborgftc.Cyborg;
import org.montclairrobotics.cyborgftc.devices.CBAxis;
import org.montclairrobotics.cyborgftc.devices.CBDeviceId;
import org.montclairrobotics.cyborgftc.mappers.CBTeleOpMapper;

/**
 * Created by rich on 9/24/2016.
 */

public class VVTeleOpMapper extends CBTeleOpMapper {
    CBAxis triggerAxis;
    VVCustomRequestData crd;

    public VVTeleOpMapper(Cyborg robot) {
        super(robot);
        crd = (VVCustomRequestData)Cyborg.customRequestData;
    }

    public VVTeleOpMapper setTriggerAxis(CBDeviceId trigAxis) {
        triggerAxis = Cyborg.hardwareAdapter.getAxis(trigAxis);
        return this;
    }

    @Override
    public void update() {
        crd.trigger = triggerAxis.getRaw();
        robot.telemetry.addData("toMap", crd.trigger);
    }
}
