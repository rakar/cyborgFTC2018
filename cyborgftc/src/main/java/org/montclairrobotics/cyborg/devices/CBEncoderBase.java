package org.montclairrobotics.cyborg.devices;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.montclairrobotics.cyborg.Cyborg;
import org.montclairrobotics.cyborg.core.utils.CBSource;

public abstract class CBEncoderBase implements CBSource,CBDevice {

    private DcMotor mc;
    protected String name;
    protected String subsystem;

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

    /**
     * A description for the type of output value to provide to a PIDController.
     */
    public enum PIDSourceType {
        kDisplacement,
        kRate
    }
    enum EncodingType {
        /**
         * Count only the rising edge.
         */
        k1X(0),
        /**
         * Count both the rising and falling edge.
         */
        k2X(1),
        /**
         * Count rising and falling on both channels.
         */
        k4X(2);

        @SuppressWarnings("MemberName")
        public final int value;

        EncodingType(int value) {
            this.value = value;
        }
    }


    protected void baseReset(){
        mc.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        mc.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    protected int baseGetRaw() {
        return mc.getCurrentPosition();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setName(String subsystem, String name) {
        setSubsystem(subsystem);
        setName(name);
    }

    public String getSubsystem() {
        return subsystem;
    }

    public void setSubsystem(String subsystem) {
        this.subsystem = subsystem;
    }
}
