package org.montclairrobotics.cyborg.devices;

import java.util.ArrayList;

import org.montclairrobotics.cyborg.Cyborg;
import org.montclairrobotics.cyborg.utils.CBEnums;
import org.montclairrobotics.cyborg.utils.CBModule;


/**
 * Created by rich on 9/23/2016.
 */
public class CBHardwareAdapter extends CBModule {

    private int joystickCount = 0;
    private ArrayList<CBJoystick> joysticks = new ArrayList<>();
    private ArrayList<CBDevice> devices = new ArrayList<>();

    public CBHardwareAdapter(Cyborg robot) {
        super(robot);
    }

    @Override
    public void init() {

    }

    public void configure() {
        for(CBDevice d: devices) {
            d.configure();
        }
    }

    public void senseUpdate() {
        for(CBDevice d: devices) {
            d.senseUpdate();
        }
    }

    public void controlUpdate() {
        for(CBDevice d: devices) {
            d.controlUpdate();
        }
    }

    /*
     * Getters/Setters
     */
    public CBHardwareAdapter setJoystickCount(int count) {
        for(int i=joystickCount;i<count;i++) {
            switch (i) {
                case 0:
                    joysticks.add(new CBJoystick(robot.gamepad1));
                    break;
                case 1:
                    joysticks.add(new CBJoystick(robot.gamepad2));
                    break;
                default:
                    break;
            }
        }
        while(joysticks.size()>count) {
            joysticks.remove(count);
        }
        joystickCount=count;
        return this;
    }

    public int getJoystickCount() {
        return joystickCount;
    }

    public CBJoystick getJoystick(CBEnums.CBJoystickId index) {
        switch (index) {
            case Undefined:
                return null;
            case Left:
                return joysticks.get(0);
            case Right:
                return joysticks.get(1);
            default:
                return null;
        }
    }

    public CBDeviceID add(CBDevice device) {
        CBDeviceID id = new CBDeviceID();
        id.ordinal = devices.size();
        devices.add(device);
        device.configure();
        return id;
    }

    public CBDevice getDevice(CBDeviceID id) {
        if(id==null) return null;
        return devices.get(id.ordinal);
    }

    public CBAccelerationSensor getAccelerationSensor(CBDeviceID id) {
        return (CBAccelerationSensor)getDevice(id);
    }
    public CBAnalogInput getAnalogInput(CBDeviceID id) {
        return (CBAnalogInput)getDevice(id);
    }

    public CBAnalogOutput getAnalogOutput(CBDeviceID id) {
        return (CBAnalogOutput)getDevice(id);
    }

    public CBAxis getAxis(CBDeviceID id) {
        return (CBAxis)getDevice(id);
    }

    public CBButton getButton(CBDeviceID id) {
        return (CBButton)getDevice(id);
    }

    public CBColorSensor getColorSensor(CBDeviceID id) {
        return (CBColorSensor)getDevice(id);
    }

    public CBCompassSensor getCompasSensor(CBDeviceID id) {
        return (CBCompassSensor)getDevice(id);
    }

    public CBCoreMotorSpeedController getCoreMotorController(CBDeviceID id) {
        return (CBCoreMotorSpeedController)getDevice(id);
    }

    public CBDigitalChannel getDigitalChannel(CBDeviceID id) {
        return (CBDigitalChannel)getDevice(id);
    }

    public CBEncoder getEncoder(CBDeviceID id) {
        return (CBEncoder)getDevice(id);
    }

    public CBGyroSensor getGyroSensor(CBDeviceID id) {
        return (CBGyroSensor)getDevice(id);
    }

    public CBIrSeekerSensor getIrSeekerSensor(CBDeviceID id) {
        return (CBIrSeekerSensor)getDevice(id);
    }

    public CBLed getLed(CBDeviceID id) {
        return (CBLed)getDevice(id);
    }

    public CBLightSensor getLightSensor(CBDeviceID id) {
        return (CBLightSensor)getDevice(id);
    }

    public CBOpticalDistanceSensor getOpticalDistanceSensor(CBDeviceID id) {
        return (CBOpticalDistanceSensor)getDevice(id);
    }

    public CBPov getPOV(CBDeviceID id) {
        return (CBPov)getDevice(id);
    }

    public CBPWMOutput getPWMOutput(CBDeviceID id) {
        return (CBPWMOutput)getDevice(id);
    }

    public CBServo getServo(CBDeviceID id) {
        return (CBServo) getDevice(id);
    }

    public CBSpeedController getSpeedController(CBDeviceID id) {
        return (CBSpeedController)getDevice(id);
    }

    public CBTouchSensor getTouchSensor(CBDeviceID id) {
        return (CBTouchSensor)getDevice(id);
    }
}