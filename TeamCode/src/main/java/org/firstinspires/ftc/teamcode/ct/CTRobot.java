package org.firstinspires.ftc.teamcode.ct;

import org.montclairrobotics.cyborg.Cyborg;
import org.montclairrobotics.cyborg.devices.CBAxis;
import org.montclairrobotics.cyborg.devices.CBDeviceID;
import org.montclairrobotics.cyborg.utils.CBEnums;

public abstract class CTRobot extends Cyborg {
    final static CBEnums.CBJoystickId driveStickId = CBEnums.CBJoystickId.Left;
    final static CBEnums.CBJoystickId operStickId = CBEnums.CBJoystickId.Right;

    public CTRequestData requestData = new CTRequestData();
    public CTControlData controlData = new CTControlData();

    public static CBDeviceID
            forwardAxis,
            strafeAxis,
            rotateAxis,
            trace
    ;

    public void cyborgInit() {

        logMessage("CTRobot: init begin");
        // move inside cyborg itself.
        //Cyborg.hardwareAdapter = new CBHardwareAdapter(this);

        // Driver's Station Controls
        logMessage("adding Driver's Station Controls");
        forwardAxis = hardwareAdapter.add(new CBAxis(driveStickId, CBEnums.CBAxisId.Right_Y).setDeadzone(0.1));
        strafeAxis  = hardwareAdapter.add(new CBAxis(driveStickId, CBEnums.CBAxisId.Right_X).setDeadzone(0.1));
        rotateAxis  = hardwareAdapter.add(new CBAxis(driveStickId, CBEnums.CBAxisId.Left_X).setDeadzone(0.1));
        trace = hardwareAdapter.add(new CTTraceDevice("normal"));

        logMessage("adding SensorMappers");
        this.addSensorMapper(
                new CTTraceSensorMapper(this, "sensor")
        );
        logMessage("added SensorMappers");

        logMessage("adding Behaviors");
        this.addBehavior(
                new CTTraceBehavior(this,"normal")
        );
        logMessage("added Behaviors");

        logMessage("adding Controllers");
        this.addRobotController(
                new CTTraceController(this,"normal")
        );
        logMessage("added Controllers");

        logMessage("CTRobot: init complete");
    }
}
