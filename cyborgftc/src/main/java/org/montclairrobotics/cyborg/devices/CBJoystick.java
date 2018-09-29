package org.montclairrobotics.cyborg.devices;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.montclairrobotics.cyborg.core.utils.CBEnums;

/**
 * Created by rich on 9/23/2016.
 */
// TODO: Check Trigger inputs, they don't seem to be working. Maybe not Analog? XBox Mode.
public class CBJoystick {
    Gamepad joystick;

    public CBJoystick(Gamepad gamepad) {
        joystick = gamepad;
    }

    public float getRawAxis(CBEnums.CBAxisId axis) {
        switch(axis) {
            case Left_X:
                return joystick.left_stick_x;
            case Left_Y:
                return joystick.left_stick_y;
            case Left_Trigger:
                return joystick.left_trigger;
            case Right_X:
                return joystick.right_stick_x;
            case Right_Y:
                return joystick.right_stick_y;
            case Right_Trigger:
                return joystick.right_trigger;
            case Undefined:
            default:
                return 1;
        }
    }

    public int getRawPOV(CBEnums.CBPOVId axis) {
        switch (axis) {
            case POV:
                if(!joystick.dpad_down && !joystick.dpad_left && !joystick.dpad_right &&  joystick.dpad_up) return    0;
                if(!joystick.dpad_down && !joystick.dpad_left &&  joystick.dpad_right &&  joystick.dpad_up) return   45;
                if(!joystick.dpad_down && !joystick.dpad_left &&  joystick.dpad_right && !joystick.dpad_up) return   90;
                if( joystick.dpad_down && !joystick.dpad_left &&  joystick.dpad_right && !joystick.dpad_up) return  135;
                if( joystick.dpad_down && !joystick.dpad_left && !joystick.dpad_right && !joystick.dpad_up) return  180;
                if( joystick.dpad_down &&  joystick.dpad_left && !joystick.dpad_right && !joystick.dpad_up) return -135;
                if(!joystick.dpad_down &&  joystick.dpad_left && !joystick.dpad_right && !joystick.dpad_up) return  -90;
                if(!joystick.dpad_down &&  joystick.dpad_left && !joystick.dpad_right &&  joystick.dpad_up) return  -45;
                return -1;
            case Undefined:
            default:
                return 0;
        }
    }

    public boolean getRawButton(CBEnums.CBButtonId axis) {
        switch (axis) {
            case A_Button:
                return joystick.a;
            case B_Button:
                return joystick.b;
            case  X_Button:
                return joystick.x;
            case Y_Button:
                return joystick.y;
            case Guide_Button:
                return joystick.guide;
            case Start_Button:
                return joystick.start;
            case Back_Buttton:
                return joystick.back;
            case Left_Stick_Button:
                return joystick.left_stick_button;
            case Right_Stick_Button:
                return joystick.right_stick_button;
            case Undefined:
            default:
                return false;
        }
    }
}
