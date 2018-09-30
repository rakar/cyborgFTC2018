package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.ct.CTRobot;
import org.montclairrobotics.cyborg.behaviors.CBQuickAutoBehavior;
import org.montclairrobotics.cyborg.core.utils.CBStateMachine;

@Autonomous(name = "Auto2", group="cyborg")
public class CTAuto2 extends CTRobot {
    @Override
    public void opModeInit() {
        addAutonomous(new CBQuickAutoBehavior(this));
        qSM = new qStateMachine(qStates.START);
    }

    private enum qStates {START, DOSTUFF, IDLE};

    private class qStateMachine extends CBStateMachine<qStates> {

        protected qStateMachine(qStates start) {
            super(start);
        }

        @Override
        protected void calcNextState() {
            logMessage("Auto Quick SMCalcNextState");
            switch(currentState) {
                case START:
                    nextState = qStates.DOSTUFF;
                    break;
                case DOSTUFF:
                    nextState = qStates.IDLE;
                    break;
                case IDLE:
                    nextState = qStates.DOSTUFF;
                    break;
            }
        }

        @Override
        protected void doTransition() {
            logMessage("Auto Quick SMDoTransition");
        }

        @Override
        protected void doCurrentState() {
            logMessage("Auto Quick SMDoCurrentState");
        }
    }

    private qStateMachine qSM;

    @Override
    public void quickInit() {

        logMessage("Auto Quick Init");
        qSM.setState(qStates.START);
    }

    @Override
    public void quickUpdate() {
        logMessage("Quick Update");
        qSM.update();
    }
}
