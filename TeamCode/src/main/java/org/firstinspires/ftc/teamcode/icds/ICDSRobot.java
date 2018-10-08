package org.firstinspires.ftc.teamcode.icds;

import org.montclairrobotics.cyborg.Cyborg;
import org.montclairrobotics.cyborg.core.assemblies.CBDriveModule;
import org.montclairrobotics.cyborg.core.assemblies.CBVictorArrayController;
import org.montclairrobotics.cyborg.core.behaviors.CBStdDriveBehavior;
import org.montclairrobotics.cyborg.core.controllers.CBMecanumDriveController;
import org.montclairrobotics.cyborg.core.utils.CB2DVector;
import org.montclairrobotics.cyborg.core.utils.CBEnums;
import org.montclairrobotics.cyborg.devices.CBAxis;
import org.montclairrobotics.cyborg.devices.CBCoreMotorSpeedController;
import org.montclairrobotics.cyborg.devices.CBDeviceID;

/**
 * This is the main robot definition class.
 * This class exists so that all of the opmodes
 * (teleop and autonomous) can use a common
 * robot configuration. Since the robot is
 * the same, this will likely be the same for
 * all opmodes.
 */
public abstract class ICDSRobot extends Cyborg {

    final static CBEnums.CBJoystickId driveStickId = CBEnums.CBJoystickId.Left;
    final static CBEnums.CBJoystickId operStickId = CBEnums.CBJoystickId.Right;

    //
    // Data Initialization
    //
    public ICDSRequestData requestData = new ICDSRequestData();
    public ICDSControlData controlData = new ICDSControlData();
    //public CBLogicData logicData = new CBLogicData();

    //
    // List Custom Hardware Devices...
    // This should include all of the active devices
    // These are public static so that they can be accessed
    // by truly custom mappers. Generic mappers should
    // use setters so that inputs are not fixed.
    //
    public static CBDeviceID
            driveMotorFL, driveMotorBL,
            driveMotorFR, driveMotorBR,
            axisForward, axisStrafe, axisRotate;

    @Override
    public void cyborgInit() {

        telemetry.addLine("Configure Hardware Adapter");

        //
        // ICDSRobot Hardware
        //
        telemetry.addLine("adding Motor Controllers");
        driveMotorFL = hardwareAdapter.add(new CBCoreMotorSpeedController("left_driveF"));
        driveMotorFR = hardwareAdapter.add(new CBCoreMotorSpeedController("right_driveF")
                .setInverted(true)
        );
        driveMotorBL = hardwareAdapter.add(new CBCoreMotorSpeedController("left_driveR"));
        driveMotorBR = hardwareAdapter.add(new CBCoreMotorSpeedController("right_driveR")
                .setInverted(true)
        );

        //
        // Driver's Station Controls
        //
        telemetry.addLine("adding Driver's Station Controls");
        axisForward = hardwareAdapter.add(new CBAxis(driveStickId, CBEnums.CBAxisId.Right_X).setDeadzone(0.1));
        axisStrafe = hardwareAdapter.add(new CBAxis(driveStickId, CBEnums.CBAxisId.Right_Y).setDeadzone(0.1));
        axisRotate = hardwareAdapter.add(new CBAxis(driveStickId, CBEnums.CBAxisId.Left_Y).setDeadzone(0.0));

        //
        // Input Sensor Mapper Initialization
        //

        //
        // Output Controller Initialization
        //
        telemetry.addLine("adding Output Controllers");
        this.addRobotController(
                new CBMecanumDriveController(this, controlData.drivetrain)
                        .addDriveModule(
                                new CBDriveModule(
                                        new CB2DVector(-7, 7), 0)
                                        .addSpeedControllerArray(
                                                new CBVictorArrayController()
                                                        .addSpeedController(driveMotorFL)
                                        )
                        )
                        .addDriveModule(
                                new CBDriveModule(
                                        new CB2DVector(7, 7), 0)
                                        .addSpeedControllerArray(
                                                new CBVictorArrayController()
                                                        .addSpeedController(driveMotorFR)
                                        )
                        )
                        .addDriveModule(
                                new CBDriveModule(
                                        new CB2DVector(-7, -7), 0)
                                        .addSpeedControllerArray(
                                                new CBVictorArrayController()
                                                        .addSpeedController(driveMotorBL)
                                        )
                        )
                        .addDriveModule(
                                new CBDriveModule(
                                        new CB2DVector(-7, -7), 0)
                                        .addSpeedControllerArray(
                                                new CBVictorArrayController()
                                                        .addSpeedController(driveMotorBR)
                                        )
                        )
        );


        //
        // Behavior Processors
        //
        telemetry.addLine("adding Behavior Processors");
        this.addBehavior(
                new CBStdDriveBehavior(this, requestData.drivetrain, controlData.drivetrain)
        );

        telemetry.addLine("init done.");
        telemetry.update();
    }
}
