package org.montclairrobotics.cyborgftc.utils;

import java.util.Date;

/**
 * Created by rich on 9/23/2016.
 */
public class CBRunStatistics {

    public int totalCycles;
    public long totalTime;
    public long   firstUpdate, thisUpdate;
    public double averageCycles;

    public CBRunStatistics() {

    }

    public void teleopPeriodicUpdate() {
        totalCycles++;
        thisUpdate = new Date().getTime();
        totalTime =  (thisUpdate-firstUpdate);
        averageCycles = 1000.0*totalCycles/(totalTime+1);
    }

    public void teleopInitUpdate() {
        firstUpdate = new Date().getTime();
        totalCycles = 0;
    }

}
