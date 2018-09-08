package org.montclairrobotics.cyborgftc.controllers;

import org.montclairrobotics.cyborgftc.Cyborg;
import org.montclairrobotics.cyborgftc.assemblies.CBDriveModule;
import org.montclairrobotics.cyborgftc.data.CBDifferentialDriveControlData;
import org.montclairrobotics.cyborgftc.data.CBStdDriveControlData;
import org.montclairrobotics.cyborgftc.utils.CB2DVector;

//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CBDifferentialDriveController extends CBDriveController {

	
	public CBDifferentialDriveController(Cyborg robot) {
		super(robot);
	}
	
	@Override
	public void update() {
		robot.telemetry.addLine("Drive Controller");
		if(Cyborg.driveControlData.active || true) {
			if(Cyborg.driveControlData instanceof CBDifferentialDriveControlData) {

				CBDifferentialDriveControlData status = (CBDifferentialDriveControlData)Cyborg.driveControlData;
				driveModules.get(0).update(status.leftPower);
				driveModules.get(1).update(status.rightPower);
				//robot.telemetry.addData("leftPower",status.leftPower);
				//robot.telemetry.addData("rightPower", status.rightPower);
			} else if(Cyborg.driveControlData instanceof CBStdDriveControlData) {
				
				CBStdDriveControlData dcd = (CBStdDriveControlData)Cyborg.driveControlData;
				for(CBDriveModule dm:driveModules) {
					double power = calculate(dm, dcd.direction, dcd.rotation);
					dm.update(power);
					//robot.telemetry.addData("DMPower",power);
				}				

			} else {
				
				System.out.println("Error: Invalid DriveControlData for DifferentialDriveController");
				
			}
		}
		robot.telemetry.update();
	}
	
	protected double calculate(CBDriveModule module, CB2DVector direction, double rotation) {
		double res = 0;

		switch (driveMode) {
		case Power:
		{
			CB2DVector diff = new CB2DVector(0,direction.getY()+Math.signum(module.getPosition().getX())*rotation);
			res = module.getOrientationVector().dot(diff);
		}
			break;
		case Speed:
		{
			CB2DVector pos = module.getPosition();
			CB2DVector targetPosition = 
					pos.rotate(rotation) 
					 .translate(direction); 
			CB2DVector diff = targetPosition.sub(pos);
			res = module.getOrientationVector().dot(diff);
			//SmartDashboard.putNumber("speed::", res);
			//robot.telemetry.addData("speed::", res);
		}
			break;
		case Conflict:
		default:
			break;
		}
				
		return res;
	}
	
	public CBDifferentialDriveController addDriveModule(CBDriveModule driveModule) {
		return (CBDifferentialDriveController)super.addDriveModule(driveModule);
	}

	@Override
	public CBDifferentialDriveController setControlPeriod(double controlPeriod) {
		return (CBDifferentialDriveController)super.setControlPeriod(controlPeriod);
	}
}
