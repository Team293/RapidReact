package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Feeder;

public class BallControl extends CommandBase {

    Feeder m_feeder;
    XboxController m_controller;

    public BallControl(Feeder feeder) {
        m_feeder = feeder;
        m_controller = null;
        addRequirements(m_feeder);
    }

    public BallControl(Feeder feeder, XboxController controller) {
        m_feeder = feeder;
        m_controller = controller;
        addRequirements(m_feeder);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        // Assume both motors will be on!
        boolean triggerMotorOn = true;
        boolean beltMotorOn = true;
        // Assume rumble will be off
        double rumblePercent = 0.0;

        if (true == m_feeder.isTriggerSensorBallPresent()) {
            // A ball is in the trigger position
            // Stop the trigger motor to hold it in place!
            triggerMotorOn = false;
            rumblePercent = 0.3;
            if (true == m_feeder.isBeltSensorBallPresent()) {
                // A ball is in the belt position
                // Stop the belt motor to hold it in place!
                beltMotorOn = false;
                rumblePercent = 0.7;
            }  
        } 


        // Rumble
        setRumble(rumblePercent);

        // Enable / disable motors
        if (true == triggerMotorOn) {
            m_feeder.setTriggerMotor(0.17);
        } else {
            m_feeder.setTriggerMotor(0);
        }
        if (true == beltMotorOn) {
            m_feeder.setBeltMotor(0.70);
        } else {
            m_feeder.setBeltMotor(0);
        }
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        setRumble(0);
    }

    private void setRumble(double value) {
        if (m_controller != null) {
            m_controller.setRumble(RumbleType.kLeftRumble, value);
            m_controller.setRumble(RumbleType.kRightRumble, value);
        }
    }
}

