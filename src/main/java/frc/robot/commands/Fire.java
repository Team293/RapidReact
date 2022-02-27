package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Launcher;
import frc.robot.Constants.LauncherConstants;
import frc.robot.subsystems.Feeder;

public class Fire extends CommandBase {

    Feeder m_feeder;
    Launcher m_launcher;
    Color m_teamColor;

    public Fire(Feeder feeder, Launcher launcher) {
        m_feeder = feeder;
        m_launcher = launcher;
        addRequirements(m_feeder, m_launcher);

        if (true == DriverStation.getAlliance().equals(Alliance.Blue)) {
            m_teamColor = Color.kBlue;
        } else {
            m_teamColor = Color.kRed;
        }
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        // Assume both motors will be on!
        boolean triggerMotorOn = true;
        boolean beltMotorOn = true;

        if (true == m_feeder.isTriggerSensorBallPresent()) {
            // There is a ball in the trigger sensor location!
            // Check if ball is our team color
            Color triggerBallColor = m_feeder.getTriggerBallColor();
            if (true == triggerBallColor.equals(m_teamColor)) {
                // The ball is our team color!

                // Get distance from limelight
                // WARNING THIS NEEDS TO BE HOOKED IN

                // Set launch rpm using distance
                m_launcher.setRpm(1800.0d); // WARNING THIS IS A TEST VALUE AND MUST CHANGE!
            } else {
                // The ball is not our team color!
                // Set dump rpm
                m_launcher.setRpm(LauncherConstants.DUMP_RPM);
            }

            if (false == m_launcher.isReady()) {
                // The launcher is not ready!
                // Turn the trigger motor off!
                triggerMotorOn = false;
                if (true == m_feeder.isBeltSensorBallPresent()) {
                    // There is a ball in the belt sensor location
                    // Turn off the belt motor to prevent a jam!
                    beltMotorOn = false;
                }
            }
        }

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
    }
}