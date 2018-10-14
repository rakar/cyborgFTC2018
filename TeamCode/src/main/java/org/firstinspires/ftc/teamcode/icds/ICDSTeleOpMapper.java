package org.firstinspires.ftc.teamcode.icds;

import org.montclairrobotics.cyborg.Cyborg;
import org.montclairrobotics.cyborg.core.mappers.CBTeleOpMapper;
import org.montclairrobotics.cyborg.devices.CBAxis;

public class ICDSTeleOpMapper extends CBTeleOpMapper {

    ICDSRobot me;
    CBAxis jawAxis;

    public ICDSTeleOpMapper(Cyborg robot) {
        super(robot);
        me = (ICDSRobot) robot;
    }

    @Override
    public void init() {
        jawAxis = Cyborg.hardwareAdapter.getAxis(me.jawTrigger);
    }

    @Override
    public void update() {
        me.requestData.jawPosition = jawAxis.get();
        //Cyborg.hardwareAdapter.robot.logMessage("ICDSTeleOpMapper Update");
    }
}
