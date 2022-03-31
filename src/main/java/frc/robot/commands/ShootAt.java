package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Launcher;
import frc.robot.subsystems.Targeting;
import frc.robot.subsystems.Feeder;

public class ShootAt extends CommandBase {

    Feeder m_feeder;
    Launcher m_launcher;
    double m_rpm;
    int m_delayCounts;

    public ShootAt(Feeder feeder, Launcher launcher, double rpm) {
        m_feeder = feeder;
        m_launcher = launcher;
        m_rpm = rpm;
        m_delayCounts = 0;
        addRequirements(m_feeder, m_launcher);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {

        // Assume both motors will be on!
        boolean triggerMotorOn = true;
        boolean beltMotorOn = false;
        boolean feed = false;

        m_delayCounts--;

        if (false == m_feeder.isTriggerSensorBallPresent()) {
            // No ball present
            if (0 >= m_delayCounts) {
                m_delayCounts = 0;
                // Attampt to load the next ball
                beltMotorOn = true;
                feed = true;
            }
        } else {
            // Ball in position to fire
            m_delayCounts = 7; // Force a wait of 350 ms before attempting to load the next ball

            m_launcher.setRpm(m_rpm);

            if (false == m_launcher.isReady()) {
                // The launcher is not ready!
                // Turn the trigger motor off!
                triggerMotorOn = false;
            }
        }

        // Enable / disable motors
        if (true == triggerMotorOn) {
            if (true == feed) {
                m_feeder.setTriggerMotor(0.17d);
            } else {
                m_feeder.setTriggerMotor(0.80d);
            }
        } else {
            m_feeder.setTriggerMotor(0.0d);
        }

        if(true == beltMotorOn){
            m_feeder.setBeltMotor(0.5d);
        } else {
            m_feeder.setBeltMotor(0.0d);
        }
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
