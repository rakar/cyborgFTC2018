package org.firstinspires.ftc.teamcode.ct;

import org.montclairrobotics.cyborg.Cyborg;
import org.montclairrobotics.cyborg.mappers.CBSensorMapper;

public class CTTraceSensorMapper extends CBSensorMapper {
    private String id;

    public CTTraceSensorMapper(Cyborg robot, String id) {
        super(robot);
        this.id=id;
    }

    @Override
    public void init() {
        robot.logMessage("CTTraceSensorMapper: init - "+id);
    }

    @Override
    public void update() {
        robot.logMessage("CTTraceSensorMapper: update - "+id);
    }
}
