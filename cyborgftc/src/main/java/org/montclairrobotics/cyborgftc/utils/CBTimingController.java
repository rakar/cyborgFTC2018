package org.montclairrobotics.cyborgftc.utils;

import org.montclairrobotics.cyborgftc.Cyborg;

/**
 * Created by rich on 9/23/2016.
 */
public class CBTimingController {
    private int timingMode;
    private int timingDelay;
    private int timingCount;

    public CBTimingController() {
        timingMode = 0;
        timingDelay = 0;
        timingCount = 0;
    }

    public CBTimingController setTiming(int mode, int delay) {
        timingMode = mode;
        timingDelay = delay;
        timingCount = delay;
        return this;
    }

    public boolean update() {
        boolean res = false;
        if((Cyborg.gameMode & timingMode)!=0 ) {
            timingCount--;
            if(timingCount<=0) {
                res = true;
                timingCount = timingDelay;
            }
        }
        return res;
    }
}
