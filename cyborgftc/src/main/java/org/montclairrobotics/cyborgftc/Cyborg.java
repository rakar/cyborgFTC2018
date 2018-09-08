package org.montclairrobotics.cyborgftc;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import java.util.ArrayList;

import org.montclairrobotics.cyborgftc.behaviors.CBAutoBehavior;
import org.montclairrobotics.cyborgftc.behaviors.CBBehavior;
import org.montclairrobotics.cyborgftc.behaviors.CBRule;
import org.montclairrobotics.cyborgftc.controllers.CBRobotController;
import org.montclairrobotics.cyborgftc.data.CBCustomControlData;
import org.montclairrobotics.cyborgftc.data.CBCustomRequestData;
import org.montclairrobotics.cyborgftc.data.CBDriveControlData;
import org.montclairrobotics.cyborgftc.data.CBDriveRequestData;
import org.montclairrobotics.cyborgftc.data.CBLogicData;
import org.montclairrobotics.cyborgftc.devices.CBHardwareAdapter;
import org.montclairrobotics.cyborgftc.mappers.CBCustomMapper;
import org.montclairrobotics.cyborgftc.mappers.CBTeleOpMapper;
import org.montclairrobotics.cyborgftc.utils.CBGameMode;
import org.montclairrobotics.cyborgftc.utils.CBRunStatistics;

/**
 * Created by rich on 9/23/2016.
 */
public abstract class Cyborg extends OpMode {

    public static CBHardwareAdapter hardwareAdapter;

    // Data Stores
    // Data Stores represent high-level meaningful messages
    public static CBDriveRequestData driveRequestData;
    public static CBDriveControlData driveControlData;
    public static CBCustomRequestData customRequestData;
    public static CBCustomControlData customControlData;
    public static CBLogicData logicData;


    // Mapper/Controller Queues
    // Mapper Queues hold lists of mappers that convert raw input state information into meaningful status info
    private ArrayList<CBTeleOpMapper> teleOpMappers = new ArrayList<CBTeleOpMapper>();
    private ArrayList<CBCustomMapper> customMappers = new ArrayList<CBCustomMapper>();
    // Controller Queues hold lists of controllers that convert high-level requests into low-level raw control output data
    private ArrayList<CBRobotController> robotControllers = new ArrayList<CBRobotController>();

    // Logic Layer
    private ArrayList<CBRule> rules = new ArrayList<>();
    private ArrayList<CBBehavior> behaviors = new ArrayList<>();
    private ArrayList<CBAutoBehavior> autonomice = new ArrayList<>();

    public static int gameMode=0;
    public static String opModeName="";
    public static boolean teleOp = false;

    //public NetworkTable table;

    public CBRunStatistics runStatistics = new CBRunStatistics();

    // General Configuration
    /**
     * Conversion from default angle unit to radians.
     */
    public static double angleToRadiansConversion = Math.PI/180.0;

    public Cyborg addTeleOpMapper(CBTeleOpMapper mapper) {
        teleOpMappers.add(mapper);
        return this;
    }

    public Cyborg addCustomMapper(CBCustomMapper mapper) {
        customMappers.add(mapper);
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

    public Cyborg addAutonomous(CBAutoBehavior autonomous) {
        this.autonomice.add(autonomous);
        return this;
    }

    public void quickInit(){

    }

    public void quickUpdate() {

    }

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public final void init() {
        telemetry.addLine("init");
        telemetry.update();
        gameMode = CBGameMode.robotInit;

        cyborgInit();

    }


    public abstract void cyborgTestInit();
    public abstract void cyborgTestPeriodic();

    public abstract void cyborgInit();
    //public abstract void cyborgDisabledInit();
    //public abstract void cyborgDisabledPeriodic();
    public abstract void cyborgTeleopInit();


    /*
    @Override
    public final void autonomousInit() {
        gameMode = CBGameMode.autonomousInit;
        for(CBAutoBehavior auto:this.autonomice) auto.init();
    }

    @Override
    public final void autonomousPeriodic() {
        gameMode = CBGameMode.autonomousPeriodic;

        // Update input interfaces
        hardwareAdapter.senseUpdate();

        // Update Input Mappers
        for(CBCustomMapper m:this.customMappers) m.update();

        // Autonomous Control
        for(CBAutoBehavior auto:this.autonomice) auto.update();

        // Let the robot do it's thing...
        robotControl();
    }
    */


    @Override
    public final void start() {
        telemetry.addLine("start");
        telemetry.update();
        if(teleOp) {
            gameMode = CBGameMode.teleopInit;
            runStatistics.teleopInitUpdate();
        } else {
            gameMode = CBGameMode.autonomousInit;
            for(CBAutoBehavior auto:this.autonomice) auto.init();
        }
    }


    /**
     * This function is called periodically during operator control
     */
    @Override
    public final void loop() {

        if (teleOp) {
            gameMode = CBGameMode.teleopPeriodic;
            runStatistics.teleopPeriodicUpdate();

            // Update input interfaces
            hardwareAdapter.senseUpdate();

            // Update Input Mappers
            for (CBTeleOpMapper m : this.teleOpMappers) m.update();
            for (CBCustomMapper m : this.customMappers) m.update();

        } else {
            gameMode = CBGameMode.autonomousPeriodic;

            // Update input interfaces
            hardwareAdapter.senseUpdate();

            // Update Input Mappers
            for(CBCustomMapper m:this.customMappers) m.update();

            // Autonomous Control
            for(CBAutoBehavior auto:this.autonomice) auto.update();

        }

        // Let the robot do it's thing...
        robotControl();
    }


    /*
    @Override
    public final void testInit() {
        gameMode = CBGameMode.testInit;
        cyborgTestInit();
    }
    */

    /**
     * This function is called periodically during test mode
     */
    /*
    @Override
    public final void testPeriodic() {
        gameMode = CBGameMode.testPeriodic;
        cyborgTestPeriodic();
    }
    */

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
    /*
    @Override
    public final void disabledInit() {
        gameMode = CBGameMode.disabledInit;

        // Update input interfaces
        //hardwareAdapter.senseUpdate();

        // Update Input Mappers
        //for(CBGeneralMapper m:this.generalMappers) m.update();

    }
    */

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


}
