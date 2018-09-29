package org.firstinspires.ftc.teamcode.vv;

import org.montclairrobotics.cyborg.Cyborg;
import org.montclairrobotics.cyborg.devices.CBAxis;
import org.montclairrobotics.cyborg.devices.CBDeviceID;
import org.montclairrobotics.cyborg.core.mappers.CBTeleOpMapper;

/**
 * Created by rich on 9/24/2016.
 */

public class VVTeleOpMapper extends CBTeleOpMapper {
    CBAxis triggerAxis;
    VVRequestData crd;

    public VVTeleOpMapper(VVRobot robot) {
        super(robot);
        crd = robot.requestData;
    }

    public VVTeleOpMapper setTriggerAxis(CBDeviceID trigAxis) {
        triggerAxis = Cyborg.hardwareAdapter.getAxis(trigAxis);
        return this;
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {
        crd.trigger = triggerAxis.getRaw();
        robot.telemetry.addData("toMap", crd.trigger);
    }
}
