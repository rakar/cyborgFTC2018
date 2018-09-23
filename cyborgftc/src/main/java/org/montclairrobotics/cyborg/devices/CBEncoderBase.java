package org.montclairrobotics.cyborg.devices;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.montclairrobotics.cyborg.Cyborg;
import org.montclairrobotics.cyborg.utils.CBSource;

public abstract class CBEncoderBase implements CBSource,CBDevice {

    private DcMotor mc;

    public CBEncoderBase(String name, boolean reversed, double distancePerPulse) {
        mc = Cyborg.hardwareAdapter.robot.hardwareMap.dcMotor.get(name); //   new CBSrxEncoder(Cyborg.hardwareAdapter.getTalonSRX(talonSrx), encoderType, false, distancePerPulse);
    }

    /*
    @Deprecated
    public CBEncoderBase(int aChannel, int bChannel, CounterBase.EncodingType encodingType, boolean reversed, double distancePerPulse) {
        throw new RuntimeException("Encoder constructor invalid in FTC.");
    }

    @Deprecated
    public CBEncoderBase(DigitalSource aSource, DigitalSource bSource, CounterBase.EncodingType encodingType, boolean reversed, double distancePerPulse) {
        throw new RuntimeException("Encoder constructor invalid in FTC.");
    }

    @Deprecated
    public CBEncoderBase(CBDeviceID talonSrx, FeedbackDevice encoderType, boolean reversed, double distancePerPulse) {
        throw new RuntimeException("Encoder constructor invalid in FTC.");
    }
    */

    protected void baseReset(){
        mc.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        mc.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    protected int baseGetRaw() {
        return mc.getCurrentPosition();
    }
}
