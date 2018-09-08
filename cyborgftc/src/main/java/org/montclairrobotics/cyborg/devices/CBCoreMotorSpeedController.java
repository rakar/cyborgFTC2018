package org.montclairrobotics.cyborg.devices;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.montclairrobotics.cyborg.Cyborg;

/**
 * Created by rich on 9/23/2016.
 */

// TODO: Implement All modes (not just Power).

public class CBCoreMotorSpeedController implements CBSpeedController {
    DcMotor mc;
    String mcName;

    public CBCoreMotorSpeedController(String name) {
        this.mcName = name;
        this.mc = Cyborg.hardwareAdapter.robot.hardwareMap.dcMotor.get(name);
        this.mc.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    @Override
    public CBCoreMotorSpeedController pidWrite(double output) {
        return this;
    }

    @Override
    public double get() {
        mc.getPower();
        return 0;
    }

    @Override
    public CBCoreMotorSpeedController set(double speed) {
        mc.setPower(speed);
        Cyborg.hardwareAdapter.robot.telemetry.addData("cmcPower",speed);
        return this;
    }

    @Override
    public CBCoreMotorSpeedController setInverted(boolean isInverted) {
        mc.setDirection(isInverted?DcMotorSimple.Direction.REVERSE: DcMotorSimple.Direction.FORWARD);
        return this;
    }

    @Override
    public boolean getInverted() {
        return mc.getDirection()==DcMotorSimple.Direction.REVERSE;
    }

    @Override
    public CBCoreMotorSpeedController disable() {
        //mc.
        return this;
    }

    @Override
    public CBCoreMotorSpeedController stopMotor() {
        mc.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        return this;
    }

    @Override
    public void senseUpdate() {

    }

    @Override
    public void controlUpdate() {

    }

    @Override
    public void configure() {

    }
}
