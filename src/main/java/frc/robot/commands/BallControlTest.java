package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Feeder;

public class BallControlTest extends CommandBase {

    Feeder m_feeder;

    public BallControlTest(Feeder feeder) {
        m_feeder = feeder;
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

        // Enable / disable motors
        m_feeder.enableTriggerMotor(triggerMotorOn);
        m_feeder.enableBeltMotor(beltMotorOn);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        m_feeder.enableTriggerMotor(false);
        m_feeder.enableBeltMotor(false);
    }
}
