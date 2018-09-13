package org.montclairrobotics.cyborg.devices;

import com.qualcomm.robotcore.hardware.DigitalChannel;

import org.montclairrobotics.cyborg.utils.CBEdgeTrigger;

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
    public void configure() {

    }

    @Override
    public void senseUpdate() {
        super.update(channel.getState());
    }

    @Override
    public void controlUpdate() {

    }
}
