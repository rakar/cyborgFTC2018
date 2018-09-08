package org.montclairrobotics.cyborgftc.mappers;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.montclairrobotics.cyborgftc.Cyborg;
import org.montclairrobotics.cyborgftc.data.CBStdDriveRequestData;
import org.montclairrobotics.cyborgftc.data.CBTankDriveRequestData;
import org.montclairrobotics.cyborgftc.devices.CBAxis;
import org.montclairrobotics.cyborgftc.devices.CBButton;
import org.montclairrobotics.cyborgftc.devices.CBDeviceId;

public class CBTankDriveMapper extends CBTeleOpMapper {
	private CBAxis left;
	private CBAxis right;
	private double deadzone = 0.0;
	private CBButton gyroLock=null;
	

	public CBTankDriveMapper(Cyborg robot, CBDeviceId leftDeviceID, CBDeviceId rightDeviceID) {
		super(robot);
		this.left = Cyborg.hardwareAdapter.getAxis(leftDeviceID);
		this.right = Cyborg.hardwareAdapter.getAxis(rightDeviceID);
	}
	
	public CBTankDriveMapper setDeadZone(double deadzone) {
		this.deadzone = deadzone;
		return this;
	}
	
	public CBTankDriveMapper setGyroLockButton(CBDeviceId buttonID) {
		this.gyroLock = Cyborg.hardwareAdapter.getButton(buttonID);
		return this;
	}

	@Override
	public void update() {
		double leftStick  = 0; // y-axis of first stick
		double rightStick = 0; // y-axis of second stick;
		
		if(left!=null && left.isDefined()) leftStick = -left.get();
		if(right!=null && right.isDefined()) rightStick = right.get();
		robot.telemetry.addData("left:",leftStick);
		robot.telemetry.addData("right:", rightStick);
		
		// Implement dead zone
		if(Math.abs( leftStick)<deadzone)  leftStick=0.0;
		if(Math.abs(rightStick)<deadzone) rightStick=0.0;
		
		if(Cyborg.driveRequestData instanceof CBStdDriveRequestData) {
			
			CBStdDriveRequestData drd = (CBStdDriveRequestData)Cyborg.driveRequestData;
			double velocity = (leftStick+rightStick)/2.0;// Average stick value "forward"
			double rotation = leftStick - velocity;

			drd.active = true;
			drd.direction.setXY(0, velocity); 
			drd.rotation = rotation; 

			if(gyroLock!=null && gyroLock.isDefined()) {
				drd.gyroLock = gyroLock.getState();
			}
			
		} else if (Cyborg.driveRequestData instanceof CBTankDriveRequestData) {
			
			CBTankDriveRequestData drd = (CBTankDriveRequestData)Cyborg.driveRequestData;
			drd.leftPower = leftStick; 
			drd.rightPower = rightStick; 
			drd.active = true;
		
		} else {
			Cyborg.driveRequestData.active = false; // If we don't know what type of request it is shut down drive
		}
	}
}
