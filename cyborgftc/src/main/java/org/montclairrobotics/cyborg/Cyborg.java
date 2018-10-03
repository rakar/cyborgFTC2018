package org.montclairrobotics.cyborg;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.montclairrobotics.cyborg.core.behaviors.CBAutonomous;
import org.montclairrobotics.cyborg.core.behaviors.CBBehavior;
import org.montclairrobotics.cyborg.core.behaviors.CBRule;
import org.montclairrobotics.cyborg.core.controllers.CBRobotController;
import org.montclairrobotics.cyborg.devices.CBHardwareAdapter;
import org.montclairrobotics.cyborg.core.mappers.CBSensorMapper;
import org.montclairrobotics.cyborg.core.mappers.CBTeleOpMapper;
import org.montclairrobotics.cyborg.core.utils.CBGameMode;
import org.montclairrobotics.cyborg.core.utils.CBRunStatistics;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**
 * Created by rich on 9/23/2016.
 */
public abstract class Cyborg extends OpMode {

    public static CBHardwareAdapter hardwareAdapter;

    // Mapper/Controller Queues
    // Mapper Queues hold lists of mappers that convert raw input state information into meaningful status info
    private ArrayList<CBTeleOpMapper> teleOpMappers; // = new ArrayList<CBTeleOpMapper>();
    private ArrayList<CBSensorMapper> sensorMappers; // = new ArrayList<CBSensorMapper>();
    // Controller Queues hold lists of controllers that convert high-level requests into low-level raw control output data
    private ArrayList<CBRobotController> robotControllers; // = new ArrayList<CBRobotController>();

    // Logic Layer
    private ArrayList<CBRule> rules; // = new ArrayList<>();
    private ArrayList<CBBehavior> behaviors; // = new ArrayList<>();
    private ArrayList<CBAutonomous> autonomice; // = new ArrayList<>();

    public static int gameMode; //=0;
    public static String opModeName; //="";
    public static boolean teleOp; // = false;

    private boolean debug; // = false;

    //public NetworkTable table;

    public CBRunStatistics runStatistics; // = new CBRunStatistics();

    // General Configuration
    /**
     * Conversion from default angle unit to radians.
     */
    public static double angleToRadiansConversion = Math.PI/180.0;

    public Cyborg addTeleOpMapper(CBTeleOpMapper mapper) {
        teleOpMappers.add(mapper);
        return this;
    }

    public Cyborg addSensorMapper(CBSensorMapper mapper) {
        sensorMappers.add(mapper);
        return this;
    }

    public Cyborg addRobotController(CBRobotController controller) {
        robotControllers.add(controller);
        return this;
    }

    public Cyborg addRule(CBRule rule) {
        rules.add(rule);
        return this;
    }

    public Cyborg addBehavior(CBBehavior behavior) {
        behaviors.add(behavior);
        return this;
    }

    public Cyborg addAutonomous(CBAutonomous autonomous) {
        this.autonomice.add(autonomous);
        return this;
    }

    public void quickInit(){

    }

    public void quickUpdate() {

    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public final void init() {
        logMessage("Cyborg: init");
        gameMode = CBGameMode.robotInit;
        hardwareAdapter = new CBHardwareAdapter(this);

        // make for sure that we reset everything
        teleOpMappers = new ArrayList<CBTeleOpMapper>();
        sensorMappers = new ArrayList<CBSensorMapper>();
        robotControllers = new ArrayList<CBRobotController>();

        rules = new ArrayList<>();
        behaviors = new ArrayList<>();
        autonomice = new ArrayList<>();

        opModeName="";
        teleOp = false;
        debug = false;
        runStatistics = new CBRunStatistics();

        // determine type and name of opMode
        for(Annotation a: this.getClass().getAnnotations()){
            if(a.annotationType()==TeleOp.class) {
                opModeName = ((TeleOp)a).name();
                teleOp = true;
            }
            if(a.annotationType()==Autonomous.class) {
                opModeName = ((Autonomous)a).name();
                teleOp = false;
            }
        }

        cyborgInit();
        opModeInit();

        hardwareAdapter.init();

        // Init Input Mappers
        for (CBSensorMapper m : this.sensorMappers) m.init();

        if(teleOp){
            for (CBTeleOpMapper m : this.teleOpMappers) m.init();
        } else {
            for (CBAutonomous m : this.autonomice) m.init();
        }

        // Init Rule and Behavior Processors
        for(CBRule m:this.rules) m.init();
        for(CBBehavior m:this.behaviors) m.init();

        for(CBRobotController m:this.robotControllers) m.init();

        logMessage("Cyborg: init complete",true);
    }

    public abstract void cyborgInit();
    public abstract void opModeInit();

    @Override
    public final void start() {
        logMessage("Cyborg: start");
        if(teleOp) {
            gameMode = CBGameMode.teleopInit;
            runStatistics.teleopInitUpdate();
        } else {
            gameMode = CBGameMode.autonomousInit;
            for(CBAutonomous auto:this.autonomice) auto.init();
        }
        logMessage("Cyborg: start complete",false);
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public final void loop() {
        logMessage("Cyborg: loop");

        if (teleOp) {
            gameMode = CBGameMode.teleopPeriodic;
            runStatistics.teleopPeriodicUpdate();

            // Update input interfaces
            hardwareAdapter.senseUpdate();

            // Update Input Mappers
            for (CBTeleOpMapper m : this.teleOpMappers) m.update();
            for (CBSensorMapper m : this.sensorMappers) m.update();

        } else {
            gameMode = CBGameMode.autonomousPeriodic;

            // Update input interfaces
            hardwareAdapter.senseUpdate();

            // Update Input Mappers
            for(CBSensorMapper m:this.sensorMappers) m.update();

            // Autonomous Control
            for(CBAutonomous auto:this.autonomice) auto.update();

        }

        // Let the robot do it's thing...
        robotControl();
        logMessage("Cyborg: loop complete",true);
    }


    // This code is common to both TeleOp and Autonomous
    private void robotControl() {
        // Update Rule and Behavior Processors
        for(CBRule m:this.rules) m.update();
        for(CBBehavior m:this.behaviors) m.update();

        // Update Output Controllers
        for(CBRobotController m:this.robotControllers) m.update();

        // Update output interfaces
        hardwareAdapter.controlUpdate();
    }

    /**
     * This function is called periodically during disabled
     */
    @Override
    public final void init_loop() {
        gameMode = CBGameMode.disabledPeriodic;

        // Update input interfaces
        //hardwareAdapter.senseUpdate();

        // Update Input Mappers
        //for(CBGeneralMapper m:this.generalMappers) m.update();

    }

    // utility functions
    public void logMessage(String msg) {
        logMessage(msg,false);
    }

    public void logMessage(String msg, boolean immediate) {
        telemetry.addLine(msg);
        if(immediate) telemetry.update();
    }

    public void putStringArray(String title, String[] msgs) {
        telemetry.addLine(title);
        for(String s:msgs) telemetry.addLine(s);
    }
}
