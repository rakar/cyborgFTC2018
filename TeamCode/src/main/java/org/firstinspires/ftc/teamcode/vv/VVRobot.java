package org.firstinspires.ftc.teamcode.vv;

import org.montclairrobotics.cyborg.Cyborg;
import org.montclairrobotics.cyborg.core.assemblies.CBDriveModule;
import org.montclairrobotics.cyborg.core.assemblies.CBSimpleSpeedControllerArray;
import org.montclairrobotics.cyborg.core.behaviors.CBTankDriveBehavior;
import org.montclairrobotics.cyborg.core.controllers.CBDifferentialDriveController;
import org.montclairrobotics.cyborg.core.data.CBLogicData;
import org.montclairrobotics.cyborg.devices.CBAxis;
import org.montclairrobotics.cyborg.devices.CBCoreMotorSpeedController;
import org.montclairrobotics.cyborg.devices.CBDeviceID;
import org.montclairrobotics.cyborg.devices.CBServo;
import org.montclairrobotics.cyborg.core.mappers.CBTankDriveMapper;
import org.montclairrobotics.cyborg.core.utils.CB2DVector;
import org.montclairrobotics.cyborg.core.utils.CBEnums;
import org.montclairrobotics.cyborg.core.utils.CBEnums.CBDriveMode;

/**
 * 
 * This is the main robot definition class.
 * This class exists so that all of the opmodes
 * (teleop and autonomous) can use a common
 * robot configuration. Since the robot is
 * the same, this will likely be the same for
 * all opmodes.
 * 
 */
public abstract class VVRobot extends Cyborg {
	
	final static CBEnums.CBJoystickId driveStickId = CBEnums.CBJoystickId.Left;
	final static CBEnums.CBJoystickId operStickId = CBEnums.CBJoystickId.Right;

	//
	// Data Initialization
	//
	public VVRequestData requestData = new VVRequestData();
	public VVControlData controlData = new VVControlData();
	public CBLogicData logicData = new CBLogicData();

	//
	// List Custom Hardware Devices...
	// This should include all of the active devices
	// These are public static so that they can be accessed
	// by truly custom mappers. Generic mappers should
	// use setters so that inputs are not fixed.
	//
	public static CBDeviceID
		//TODO: Create Device variables
		driveMotorLeft1,driveMotorLeft2,
		driveMotorRight1,driveMotorRight2,
		forwardAxis,
		forward2Axis,
		triggerAxis,
		triggerServo
		;

	@Override
	public void cyborgInit() {

		telemetry.addLine("Configure Hardware Adapter");
		// Configure Hardware Adapter
		//Cyborg.hardwareAdapter =
		//		new CBHardwareAdapter(this)
		//		.setJoystickCount(2);
		//CBHardwareAdapter ha = Cyborg.hardwareAdapter;

		// VVRobot Hardware
		telemetry.addLine("adding Motor Controllers");
		driveMotorLeft1		= hardwareAdapter.add(new CBCoreMotorSpeedController("left_driveF"));
		driveMotorRight1	= hardwareAdapter.add(new CBCoreMotorSpeedController("right_driveF"));
		driveMotorLeft2		= hardwareAdapter.add(new CBCoreMotorSpeedController("left_driveR"));
		driveMotorRight2	= hardwareAdapter.add(new CBCoreMotorSpeedController("right_driveR"));
		triggerServo        = hardwareAdapter.add(new CBServo("arm_servo").setRange(0,1));

		// Driver's Station Controls
		telemetry.addLine("adding Driver's Station Controls");
		forwardAxis 	= hardwareAdapter.add(new CBAxis(driveStickId, CBEnums.CBAxisId.Left_Y).setDeadzone(0.1));
		forward2Axis 	= hardwareAdapter.add(new CBAxis(driveStickId, CBEnums.CBAxisId.Right_Y).setDeadzone(0.1));
		triggerAxis     = hardwareAdapter.add(new CBAxis(operStickId, CBEnums.CBAxisId.Right_Y).setDeadzone(0.0));

		//
		// Input Mapper Initialization
		//
        // Tank Drive Stick Input Example...
        telemetry.addLine("adding TeleOpMapper");
        this.addTeleOpMapper(
                new CBTankDriveMapper(this, requestData.drivetrain, forwardAxis, forward2Axis)
                        .setDeadZone(0.1)
        );
        // Use teleOp mappers for operator mapping
        this.addTeleOpMapper(
                new VVTeleOpMapper(this)
                        .setTriggerAxis(triggerAxis)
        );

        //
		// Output Controller Initialization
		//
		telemetry.addLine("adding Output Controllers");
		this.addRobotController(
				new CBDifferentialDriveController(this, controlData.drivetrain)
				.addDriveModule(
						new CBDriveModule(new CB2DVector(-3,0), 0)
						.addSpeedControllerArray(
								new CBSimpleSpeedControllerArray()
								.setDriveMode(CBDriveMode.Power)
								.addSpeedController(driveMotorLeft1)
								.addSpeedController(driveMotorLeft2)
								)
						)
				.addDriveModule(
						new CBDriveModule(new CB2DVector( 3,0), 180)
						.addSpeedControllerArray(
								new CBSimpleSpeedControllerArray()
								.setDriveMode(CBDriveMode.Power)
								.addSpeedController(driveMotorRight1)
								.addSpeedController(driveMotorRight2)
								)
						)
				);
				
		this.addRobotController(
				new VVManipulatorController(this)
				.setTrigServer(triggerServo)
				);

		
		//
		// Behavior Processors
		//
		telemetry.addLine("adding Behavior Processors");
		this.addBehavior(
				new CBTankDriveBehavior(this,
					requestData.drivetrain,
					controlData.drivetrain
				)
		);
		this.addBehavior(new VVManipulatorBehavior(this));


		// Either do this in each Autonomous class that inherits from this  class
		// or add them all here based on the opModeName variable.
//		this.addAutonomous(
//				new SHAutonomous(this)
//				.setFireTarget(160, 10, 200, 20)
//				);



		telemetry.addLine("init done.");
		telemetry.update();
	}
}
