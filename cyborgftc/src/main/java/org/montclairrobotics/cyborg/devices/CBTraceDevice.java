package org.montclairrobotics.cyborg.devices;

import org.montclairrobotics.cyborg.Cyborg;

public class CBTraceDevice implements CBDevice {
    private String id;

    public CBTraceDevice(String id) {
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
            Cyborg.hardwareAdapter.robot.logMessage("CBTraceDevice: init - "+id);
        }

        @Override
        public void senseUpdate() {
            Cyborg.hardwareAdapter.robot.logMessage("CBTraceDevice: senseUpdate - "+id);
        }

        @Override
        public void controlUpdate() {
            Cyborg.hardwareAdapter.robot.logMessage("CBTraceDevice: controlUpdate - "+id);
        }
    };
}
