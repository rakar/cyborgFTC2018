package org.firstinspires.ftc.teamcode.ct;

import org.montclairrobotics.cyborg.Cyborg;
import org.montclairrobotics.cyborg.devices.CBDevice;
import org.montclairrobotics.cyborg.devices.CBDeviceControl;

public class CTTraceDevice implements CBDevice {
    private String id;

    public CTTraceDevice(String id) {
        this.id=id;
    }

    // Neat pattern for returning custom functionality
    @Override
    public CBDeviceControl getDeviceControl() {
        return deviceControl;
    }

    CBDeviceControl deviceControl = new CBDeviceControl() {
        @Override
        public void init() {
            Cyborg.hardwareAdapter.robot.logMessage("CTTraceDevice: init - "+id);
        }

        @Override
        public void senseUpdate() {
            Cyborg.hardwareAdapter.robot.logMessage("CTTraceDevice: senseUpdate - "+id);
        }

        @Override
        public void controlUpdate() {
            Cyborg.hardwareAdapter.robot.logMessage("CTTraceDevice: controlUpdate - "+id);
        }
    };
}
