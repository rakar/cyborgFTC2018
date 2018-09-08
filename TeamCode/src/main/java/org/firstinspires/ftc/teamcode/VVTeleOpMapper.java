package org.firstinspires.ftc.teamcode;

import org.montclairrobotics.cyborg.Cyborg;
import org.montclairrobotics.cyborg.devices.CBAxis;
import org.montclairrobotics.cyborg.devices.CBDeviceID;
import org.montclairrobotics.cyborg.mappers.CBTeleOpMapper;

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

    public VVTeleOpMapper setTriggerAxis(CBDeviceID trigAxis) {
        triggerAxis = Cyborg.hardwareAdapter.getAxis(trigAxis);
        return this;
    }

    @Override
    public void update() {
        crd.trigger = triggerAxis.getRaw();
        robot.telemetry.addData("toMap", crd.trigger);
    }
}
