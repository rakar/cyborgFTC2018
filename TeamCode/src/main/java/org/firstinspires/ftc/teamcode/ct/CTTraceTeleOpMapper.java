package org.firstinspires.ftc.teamcode.ct;

import org.montclairrobotics.cyborg.Cyborg;
import org.montclairrobotics.cyborg.mappers.CBTeleOpMapper;

public class CTTraceTeleOpMapper extends CBTeleOpMapper {
    private String id;

    public CTTraceTeleOpMapper(Cyborg robot, String id) {
        super(robot);
        this.id=id;
    }

    @Override
    public void init() {
        robot.logMessage("CTTraceTeleOpMapper: init - "+id);
    }

    @Override
    public void update() {
        robot.logMessage("CTTraceTeleOpMapper: update - "+id);
    }
}
