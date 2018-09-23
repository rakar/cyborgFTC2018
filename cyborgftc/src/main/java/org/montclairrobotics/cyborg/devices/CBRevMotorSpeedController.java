package org.montclairrobotics.cyborg.devices;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.PIDCoefficients;

import org.montclairrobotics.cyborg.Cyborg;

public class CBRevMotorSpeedController implements CBSpeedController {
    DcMotorEx mc;
    String mcName;

    public CBRevMotorSpeedController(String name) {
        this.mcName = name;
        this.mc = (DcMotorEx)Cyborg.hardwareAdapter.robot.hardwareMap.dcMotor.get(name);
        this.mc.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    @Override
    public CBRevMotorSpeedController pidWrite(double output) {
        return this;
    }

    public CBRevMotorSpeedController setPIDCoeficients(PIDCoefficients pidCoefficients) {
        mc.setPIDCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, pidCoefficients);
        return this;
    }

    public PIDCoefficients getPIDCoeficients() {
        return mc.getPIDCoefficients(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public double get() {
        mc.getPower();
        return 0;
    }

    @Override
    public CBRevMotorSpeedController set(double speed) {
        mc.setPower(speed);
        Cyborg.hardwareAdapter.robot.telemetry.addData("cmcPower",speed);
        return this;
    }

    @Override
    public CBRevMotorSpeedController setInverted(boolean isInverted) {
        mc.setDirection(isInverted?DcMotorSimple.Direction.REVERSE: DcMotorSimple.Direction.FORWARD);
        return this;
    }

    @Override
    public boolean getInverted() {
        return mc.getDirection()== DcMotorSimple.Direction.REVERSE;
    }

    @Override
    public CBRevMotorSpeedController disable() {
        //mc.
        return this;
    }

    @Override
    public CBRevMotorSpeedController stopMotor() {
        mc.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        return this;
    }

    @Override
    public CBDeviceControl getDeviceControl() {
        return deviceControl;
    }

    CBDeviceControl deviceControl = new CBDeviceControl() {
        @Override
        public void init() {

        }

        @Override
        public void senseUpdate() {

        }

        @Override
        public void controlUpdate() {

        }
    };
}
