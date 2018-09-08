package org.montclairrobotics.cyborgftc.utils;

/**
 * Created by rich on 9/23/2016.
 */
public class CBEnums {

    /**
     * DriveMode:
     * {@link #Power}
     * {@link #Speed}
     * {@link #Conflict}
     */
    public enum CBDriveMode {
        /**
         * Power: -1 <= raw power <= 1
         */
        Power,
        /**
         * Speed: units/second (direction) degrees/second (rotation)
         */
        Speed,
        /**
         * Position: position in standard units
         */
        Position,
        /**
         * Conflict: indicates an error due to mixed speed controller modes
         */
        Conflict
    };

    /**
     * SpeedControllerScheme:
     * {@link #Basic}
     */
    public enum CBSpeedControllerScheme {
        /**
         * Basic: Simple controllers used without internal intelligence
         */
        Basic
    };

    public enum CBJoystickId {
        Undefined,
        Left,
        Right
    }

    public enum CBButtonId {
        A_Button,
        B_Button,
        X_Button,
        Y_Button,
        Guide_Button,
        Start_Button,
        Back_Buttton,
        Left_Stick_Button,
        Right_Stick_Button,
        Undefined,
    }

    public enum CBPOVId {
        POV,
        Undefined,
    }

    public enum CBAxisId {
        Left_X,
        Left_Y,
        Right_X,
        Right_Y,
        Left_Trigger,
        Right_Trigger,
        Undefined,
    }

    public CBEnums() {
    }

}
