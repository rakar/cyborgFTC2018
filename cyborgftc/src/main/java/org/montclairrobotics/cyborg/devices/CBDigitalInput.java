package org.montclairrobotics.cyborg.devices;

import com.qualcomm.robotcore.hardware.DigitalChannel;

import org.montclairrobotics.cyborg.core.utils.CBEdgeTrigger;

public class CBDigitalInput extends CBEdgeTrigger implements CBDevice {
    CBDigitalChannel channel;

    public CBDigitalInput(String name) {
        channel = new CBDigitalChannel(name);
        channel.setMode(DigitalChannel.Mode.INPUT);
    }

    public boolean get() {
        return getState();
    }

    @Override
    public CBDeviceControl getDeviceControl() {
        return deviceControl;
    }

    private void update() {
        super.update(channel.getState());
    }

    CBDeviceControl deviceControl = new CBDeviceControl() {

        @Override
        public void init() {

        }

        @Override
        public void senseUpdate() {
            update();
        }

        @Override
        public void controlUpdate() {

        }
    };
}
