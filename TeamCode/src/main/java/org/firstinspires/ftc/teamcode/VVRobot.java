package org.firstinspires.ftc.teamcode;

import org.montclairrobotics.cyborg.Cyborg;
import org.montclairrobotics.cyborg.behaviors.CBTankDriveBehavior;
import org.montclairrobotics.cyborg.utils.CB2DVector;
import org.montclairrobotics.cyborg.utils.CBEnums;
import org.montclairrobotics.cyborg.assemblies.CBDriveModule;
import org.montclairrobotics.cyborg.assemblies.CBVictorArrayController;
import org.montclairrobotics.cyborg.controllers.CBDifferentialDriveController;
import org.montclairrobotics.cyborg.data.CBDifferentialDriveControlData;
import org.montclairrobotics.cyborg.data.CBLogicData;
import org.montclairrobotics.cyborg.data.CBTankDriveRequestData;
import org.montclairrobotics.cyborg.devices.CBAxis;
import org.montclairrobotics.cyborg.devices.CBCoreMotorSpeedController;
import org.montclairrobotics.cyborg.devices.CBDeviceID;
import org.montclairrobotics.cyborg.devices.CBHardwareAdapter;
import org.montclairrobotics.cyborg.devices.CBServo;
import org.montclairrobotics.cyborg.mappers.CBTankDriveMapper;
import org.montclairrobotics.cyborg.utils.CBEnums.CBDriveMode;

/**
 * 
 * This is the main robot definition class.
 * 
 */
public abstract class VVRobot extends Cyborg {
	
	final static CBEnums.CBJoystickId driveStickId = CBEnums.CBJoystickId.Left;
	final static CBEnums.CBJoystickId operStickId = CBEnums.CBJoystickId.Right;
	
	//
	// List Custom Hardware Devices...
	// This should include all of the active devices
	//
	private class SHDevices {
		private CBDeviceID
			//TODO: Create Device variables
			driveMotorLeft1,
			driveMotorRight1,
			forwardAxis,
			forward2Axis,
			triggerAxis,
			triggerServo
			;
	}
	private SHDevices devices = new SHDevices();

	@Override
	public void cyborgInit() {

		//
		// Data Initialization
		//
		// Initialize data stores
		// The drive and general data stores are separated 
		// because the drive stores will most likely be 
		// pre-built and the custom ones will handle 
		// robot specific data requirements. 
		// 
		// TODO: Instantiate data stores
		driveRequestData 	= new CBTankDriveRequestData();
		driveControlData	= new CBDifferentialDriveControlData();
		customRequestData	= new VVCustomRequestData();
		customControlData	= new VVCustomControlData();
		logicData 			= new CBLogicData();

		telemetry.addLine("Configure Hardware Adapter");
		// Configure Hardware Adapter
		Cyborg.hardwareAdapter = 
				new CBHardwareAdapter(this)
				.setJoystickCount(2);
		CBHardwareAdapter ha = Cyborg.hardwareAdapter;

		// VVRobot Hardware
		telemetry.addLine("adding Motor Controllers");
		devices.driveMotorLeft1		= ha.add(new CBCoreMotorSpeedController("left_drive"));
		devices.driveMotorRight1	= ha.add(new CBCoreMotorSpeedController("right_drive"));
		devices.triggerServo        = ha.add(new CBServo("arm_servo").setRange(0,1));

		// Driver's Station Controls
		telemetry.addLine("adding Driver's Station Controls");
		devices.forwardAxis 	= ha.add(new CBAxis(driveStickId, CBEnums.CBAxisId.Left_Y).setDeadzone(0.1));
		devices.forward2Axis 	= ha.add(new CBAxis(driveStickId, CBEnums.CBAxisId.Right_Y).setDeadzone(0.1));
		devices.triggerAxis     = ha.add(new CBAxis(operStickId, CBEnums.CBAxisId.Right_Y).setDeadzone(0.0));

		//
		// Input Mapper Initialization
		//
		
		// Tank Drive Stick Input Example...
		telemetry.addLine("adding TeleOpMapper");
		this.addTeleOpMapper(
				new CBTankDriveMapper(this, devices.forwardAxis, devices.forward2Axis)
				.setDeadZone(0.1)
				);

		// Use teleOp mappers for operator mapping
		this.addTeleOpMapper(
				new VVTeleOpMapper(this)
				.setTriggerAxis(devices.triggerAxis)
				);
		
		// Use custom mappers for sensor/full-time mapping
//		this.addCustomMapper(
//				new SHSensorMapper(this)
//				.setAutoChooser(devices.autoSelect)
//				.setContourRpt(devices.visionPipeline)
//				.setGyroLockSource(devices.navx)
//				.setDriveEncoders(devices.driveEncoderLeft, devices.driveEncoderRight)
//				);

		
		//
		// Output Controller Initialization
		//
		telemetry.addLine("adding Output Controllers");
		this.addRobotController(
				new CBDifferentialDriveController(this)
				.addDriveModule(
						new CBDriveModule(new CB2DVector(-3,0), 0)
						.addSpeedControllerArray(
								new CBVictorArrayController()
								.setDriveMode(CBDriveMode.Power)
								.addSpeedController(devices.driveMotorLeft1)
								)
						)
				.addDriveModule(
						new CBDriveModule(new CB2DVector( 3,0), 180)
						.addSpeedControllerArray(
								new CBVictorArrayController()
								.setDriveMode(CBDriveMode.Power)
								.addSpeedController(devices.driveMotorRight1)
								)
						)
				);
				
		this.addRobotController(
				new VVManipulatorController(this)
				.setTrigServer(devices.triggerServo)
				);

		
		//
		// Behavior Processors
		//
		telemetry.addLine("adding Behavior Processors");
		this.addBehavior(new CBTankDriveBehavior(this));
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

	public abstract void opModeInit();

	@Override
	public void cyborgTeleopInit() {

	}

	@Override
	public void cyborgTestInit() {
		
	}

	@Override
	public void cyborgTestPeriodic() {
		
	}
}
