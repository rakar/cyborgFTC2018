package org.montclairrobotics.cyborgftc.utils;

/**
 * Created by rich on 9/23/2016.
 */
public class CBGameMode {
    public final static int robotInit = 1;
    public final static int disabledInit = 2;
    public final static int disabledPeriodic = 4;
    public final static int autonomousInit = 8;
    public final static int autonomousPeriodic = 16;
    public final static int teleopInit = 32;
    public final static int teleopPeriodic = 64;
    public final static int testInit = 128;
    public final static int testPeriodic = 256;

    public final static int preGame = robotInit+disabledInit+disabledPeriodic+autonomousInit;
    public final static int anyInit = robotInit+disabledInit+autonomousInit+teleopInit+testInit;
    public final static int anyPeriodic = disabledPeriodic+autonomousPeriodic+teleopPeriodic+testPeriodic;

}
