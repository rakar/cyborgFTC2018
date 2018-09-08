package org.montclairrobotics.cyborgftc;

import java.util.ArrayList;

import org.montclairrobotics.cyborgftc.devices.CBAccelerationSensor;
import org.montclairrobotics.cyborgftc.devices.CBAnalogInput;
import org.montclairrobotics.cyborgftc.devices.CBAnalogOutput;
import org.montclairrobotics.cyborgftc.devices.CBAxis;
import org.montclairrobotics.cyborgftc.devices.CBButton;
import org.montclairrobotics.cyborgftc.devices.CBColorSensor;
import org.montclairrobotics.cyborgftc.devices.CBCompassSensor;
import org.montclairrobotics.cyborgftc.devices.CBCoreMotorSpeedController;
import org.montclairrobotics.cyborgftc.devices.CBDevice;
import org.montclairrobotics.cyborgftc.devices.CBDeviceId;
import org.montclairrobotics.cyborgftc.devices.CBDigitalChannel;
import org.montclairrobotics.cyborgftc.devices.CBGyroSensor;
import org.montclairrobotics.cyborgftc.devices.CBIrSeekerSensor;
import org.montclairrobotics.cyborgftc.devices.CBJoystick;
import org.montclairrobotics.cyborgftc.devices.CBLed;
import org.montclairrobotics.cyborgftc.devices.CBLightSensor;
import org.montclairrobotics.cyborgftc.devices.CBOpticalDistanceSensor;
import org.montclairrobotics.cyborgftc.devices.CBPWMOutput;
import org.montclairrobotics.cyborgftc.devices.CBPov;
import org.montclairrobotics.cyborgftc.devices.CBServo;
import org.montclairrobotics.cyborgftc.devices.CBSpeedController;
import org.montclairrobotics.cyborgftc.devices.CBTouchSensor;
import org.montclairrobotics.cyborgftc.utils.CBEnums;
import org.montclairrobotics.cyborgftc.utils.CBModule;


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

    public CBDeviceId add(CBDevice device) {
        CBDeviceId id = new CBDeviceId();
        id.ordinal = devices.size();
        devices.add(device);
        device.configure();
        return id;
    }

    public CBDevice getDevice(CBDeviceId id) {
        if(id==null) return null;
        return devices.get(id.ordinal);
    }

    public CBAccelerationSensor getAccelerationSensor(CBDeviceId id) {
        return (CBAccelerationSensor)getDevice(id);
    }
    public CBAnalogInput getAnalogInput(CBDeviceId id) {
        return (CBAnalogInput)getDevice(id);
    }

    public CBAnalogOutput getAnalogOutput(CBDeviceId id) {
        return (CBAnalogOutput)getDevice(id);
    }

    public CBAxis getAxis(CBDeviceId id) {
        return (CBAxis)getDevice(id);
    }

    public CBButton getButton(CBDeviceId id) {
        return (CBButton)getDevice(id);
    }

    public CBColorSensor getColorSensor(CBDeviceId id) {
        return (CBColorSensor)getDevice(id);
    }

    public CBCompassSensor getCompasSensor(CBDeviceId id) {
        return (CBCompassSensor)getDevice(id);
    }

    public CBCoreMotorSpeedController getCoreMotorController(CBDeviceId id) {
        return (CBCoreMotorSpeedController)getDevice(id);
    }

    public CBDigitalChannel getDigitalChannel(CBDeviceId id) {
        return (CBDigitalChannel)getDevice(id);
    }

    public CBGyroSensor getGyroSensor(CBDeviceId id) {
        return (CBGyroSensor)getDevice(id);
    }

    public CBIrSeekerSensor getIrSeekerSensor(CBDeviceId id) {
        return (CBIrSeekerSensor)getDevice(id);
    }

    public CBLed getLed(CBDeviceId id) {
        return (CBLed)getDevice(id);
    }

    public CBLightSensor getLightSensor(CBDeviceId id) {
        return (CBLightSensor)getDevice(id);
    }

    public CBOpticalDistanceSensor getOpticalDistanceSensor(CBDeviceId id) {
        return (CBOpticalDistanceSensor)getDevice(id);
    }

    public CBPov getPOV(CBDeviceId id) {
        return (CBPov)getDevice(id);
    }

    public CBPWMOutput getPWMOutput(CBDeviceId id) {
        return (CBPWMOutput)getDevice(id);
    }

    public CBServo getServo(CBDeviceId id) {
        return (CBServo) getDevice(id);
    }

    public CBSpeedController getSpeedController(CBDeviceId id) {
        return (CBSpeedController)getDevice(id);
    }

    public CBTouchSensor getTouchSensor(CBDeviceId id) {
        return (CBTouchSensor)getDevice(id);
    }
}