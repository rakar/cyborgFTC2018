package org.firstinspires.ftc.teamcode.icds;

import org.montclairrobotics.cyborg.Cyborg;
import org.montclairrobotics.cyborg.core.assemblies.CBDriveModule;
import org.montclairrobotics.cyborg.core.assemblies.CBServoArray;
import org.montclairrobotics.cyborg.core.assemblies.CBSimpleSpeedControllerArray;
import org.montclairrobotics.cyborg.core.behaviors.CBStdDriveBehavior;
import org.montclairrobotics.cyborg.core.controllers.CBDifferentialDriveController;
import org.montclairrobotics.cyborg.core.controllers.CBMecanumDriveController;
import org.montclairrobotics.cyborg.core.utils.CB2DVector;
import org.montclairrobotics.cyborg.core.utils.CBEnums;
import org.montclairrobotics.cyborg.devices.CBAxis;
import org.montclairrobotics.cyborg.devices.CBCoreMotorSpeedController;
import org.montclairrobotics.cyborg.devices.CBDeviceID;
import org.montclairrobotics.cyborg.devices.CBRevMotorSpeedController;
import org.montclairrobotics.cyborg.devices.CBServo;

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
            axisForward, axisStrafe, axisRotate,
            jawTrigger, servoLeft, servoRight;

    public void cyborgInit() {

        telemetry.addLine("Configure Hardware Adapter");

        //
        // ICDSRobot Hardware
        //
        telemetry.addLine("adding Motor Controllers");

        boolean useRev = true;
        if (useRev) {
            driveMotorFL = hardwareAdapter.add(new CBRevMotorSpeedController("m2")
                    .setInverted(false)
            );
            driveMotorFR = hardwareAdapter.add(new CBRevMotorSpeedController("m3")
                    .setInverted(false)
            );
            driveMotorBL = hardwareAdapter.add(new CBRevMotorSpeedController("m1")
                    .setInverted(false)
            );
            driveMotorBR = hardwareAdapter.add(new CBRevMotorSpeedController("m0")
                    .setInverted(false)
            );
        } else {
            driveMotorFL = hardwareAdapter.add(new CBCoreMotorSpeedController("leftfront")
                    .setInverted(false)
            );
            driveMotorFR = hardwareAdapter.add(new CBCoreMotorSpeedController("rightfront")
                    .setInverted(false)
            );
            driveMotorBL = hardwareAdapter.add(new CBCoreMotorSpeedController("leftback")
                    .setInverted(false)
            );
            driveMotorBR = hardwareAdapter.add(new CBCoreMotorSpeedController("rightback")
                    .setInverted(false)
            );
        }

        servoLeft = hardwareAdapter.add(new CBServo("servo1"));
        servoRight = hardwareAdapter.add(new CBServo("servo2").setReversed(true));

        //
        // Driver's Station Controls
        //
        telemetry.addLine("adding Driver's Station Controls");
        axisForward = hardwareAdapter.add(new CBAxis(driveStickId, CBEnums.CBAxisId.Right_Y).setDeadzone(0.1));
        axisStrafe = hardwareAdapter.add(new CBAxis(driveStickId, CBEnums.CBAxisId.Right_X).setDeadzone(0.1));
        axisRotate = hardwareAdapter.add(new CBAxis(driveStickId, CBEnums.CBAxisId.Left_X).setDeadzone(0.0));
        jawTrigger = hardwareAdapter.add(new CBAxis(driveStickId,CBEnums.CBAxisId.Right_Trigger));



        //
        // Input Sensor Mapper Initialization
        //

        //
        // Output Controller Initialization
        //
        telemetry.addLine("adding Output Controllers");
        boolean useMecanum = true;
        if (useMecanum) {
            this.addRobotController(
                    new CBMecanumDriveController(this, controlData.drivetrain)
                            .addDriveModule(
                                    new CBDriveModule(new CB2DVector(-7, 7), 180)
                                            .addSpeedControllerArray(
                                                    new CBSimpleSpeedControllerArray()
                                                            .addSpeedController(driveMotorFL)
                                            )
                            )
                            .addDriveModule(
                                    new CBDriveModule(new CB2DVector(7, 7), 0)
                                            .addSpeedControllerArray(
                                                    new CBSimpleSpeedControllerArray()
                                                            .addSpeedController(driveMotorFR)
                                            )
                            )
                            .addDriveModule(
                                    new CBDriveModule(new CB2DVector(-7, -7), 180)
                                            .addSpeedControllerArray(
                                                    new CBSimpleSpeedControllerArray()
                                                            .addSpeedController(driveMotorBL)
                                            )
                            )
                            .addDriveModule(
                                    new CBDriveModule(new CB2DVector(7, -7), 0)
                                            .addSpeedControllerArray(
                                                    new CBSimpleSpeedControllerArray()
                                                            .addSpeedController(driveMotorBR)
                                            )
                            )
            );
        } else {
            this.addRobotController(
                    new CBDifferentialDriveController(this, controlData.drivetrain)
                            .addLeftDriveModule(
                                    new CBDriveModule(new CB2DVector(-7,0), 180)
                                            .addSpeedControllerArray(
                                                    new CBSimpleSpeedControllerArray()
                                                        .addSpeedController(driveMotorFL)
                                                        .addSpeedController(driveMotorBL)
                                            )
                                    )
                            .addRightDriveModule(
                                    new CBDriveModule(new CB2DVector(7,0), 0)
                                            .addSpeedControllerArray(
                                                    new CBSimpleSpeedControllerArray()
                                                            .addSpeedController(driveMotorFR)
                                                            .addSpeedController(driveMotorBR)
                                            )
                            )
            );
        }

        this.addRobotController(
                new ICDSManipulatorController(this)
                        .setJawServoArray(
                                new CBServoArray()
                                        .addServo(servoLeft)
                                        .addServo(servoRight)
                        )
        );

        //
        // Behavior Processors
        //
        telemetry.addLine("adding Behavior Processors");
        this.addBehavior(
                new CBStdDriveBehavior(this, requestData.drivetrain, controlData.drivetrain)
        );
        this.addBehavior(
                new ICDSManipulatorBehavior(this)
        );

        telemetry.addLine("init done.");
        //telemetry.update();
    }
}
