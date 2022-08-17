// RobotBuilder Version: 3.1
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import static frc.robot.Constants.DrivetrainConstants.*;
import frc.robot.classes.SPIKE293Utils;
import frc.robot.drivetrains.Drivetrain;

/**
 *
 */
public class aForzaDrive extends CommandBase {
    private final Drivetrain m_drivetrain;
    private final XboxController m_xboxcontroller;

    //private double m_arcadeDeadband;
    private boolean m_forzaEnabled;
    private double m_forzaDeadband;
    private double m_velocityLimitPercentage;
    private double m_turningLimitPercentage;

    public aForzaDrive(Drivetrain drivetrain, XboxController xboxcontroller) {
        m_drivetrain = drivetrain;
        addRequirements(m_drivetrain);
        m_xboxcontroller = xboxcontroller;

        m_velocityLimitPercentage = DEFAULT_MAX_VELOCITY_PERCENTAGE;
        m_turningLimitPercentage = DEFAULT_MAX_TURNING_SPEED;
        //m_arcadeDeadband = DEFAULT_ARCADE_JOY_DEADBAND;
        m_forzaDeadband = DEFAULT_FORZA_DEADBAND;
        m_forzaEnabled = DEFAULT_FORZA_MODE;
        //SmartDashboard.putNumber("Arcade Joy Deadband", m_arcadeDeadband);
        SmartDashboard.putNumber("Forza Deadband", m_forzaDeadband);
        SmartDashboard.putBoolean("Forza Mode", m_forzaEnabled);
        SmartDashboard.putNumber("Max Velocity Percentage", m_velocityLimitPercentage);
        SmartDashboard.putNumber("Max Turning Percentage", m_turningLimitPercentage);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double turning;
        double speed;
        double triggerRight;
        double triggerLeft;

        // Get deadband value set in SmartDashboard
        //m_arcadeDeadband = SmartDashboard.getNumber("Arcade Joy Deadband", DEFAULT_ARCADE_JOY_DEADBAND);
        //m_arcadeDeadband = MathUtil.clamp(m_arcadeDeadband, 0.0d, 1.0d);
        m_forzaDeadband = SmartDashboard.getNumber("Forza Deadband", DEFAULT_FORZA_DEADBAND);
        m_forzaDeadband = MathUtil.clamp(m_forzaDeadband, 0.0d, 1.0d);
        m_forzaEnabled = SmartDashboard.getBoolean("Forza Mode", DEFAULT_FORZA_MODE);

        m_velocityLimitPercentage = SmartDashboard.getNumber("Max Velocity Percentage",
                DEFAULT_MAX_VELOCITY_PERCENTAGE);
        m_velocityLimitPercentage = MathUtil.clamp(m_velocityLimitPercentage, 0.0d, 1.0d);
        SmartDashboard.putNumber("Max Velocity Percentage", m_velocityLimitPercentage);

        m_turningLimitPercentage = SmartDashboard.getNumber("Max Turning Percentage", DEFAULT_MAX_TURNING_SPEED);
        m_turningLimitPercentage = MathUtil.clamp(m_turningLimitPercentage, 0.0d, 1.0d);
        SmartDashboard.putNumber("Max Turning Percentage", m_turningLimitPercentage);

        // Get turning. Note that the controls are inverted!
        turning = m_xboxcontroller.getLeftX();

        // Checks if joystick value is higher or lower than deadband value
        turning = SPIKE293Utils.applyDeadband(turning, m_arcadeDeadband);
    
        // Get trigger values
        triggerRight = m_xboxcontroller.getRightTriggerAxis();
        triggerRight = SPIKE293Utils.applyDeadband(triggerRight, m_forzaDeadband);
        triggerLeft = m_xboxcontroller.getLeftTriggerAxis();
        triggerLeft = SPIKE293Utils.applyDeadband(triggerLeft, m_forzaDeadband);

        if (triggerRight >= triggerLeft) {
            // Use right trigger for forward speed!
            speed = triggerRight;
        } else {
            // Going in reverse! Right trigger was zero, set speed to left trigger
            speed = -triggerLeft;
        }
        /*
        } else {
            // Use the stick, note that the joystick is inverted, -1 is up, 1 is down
            speed = m_xboxcontroller.getLeftY();
            speed = SPIKE293Utils.applyDeadband(speed, m_arcadeDeadband);
        }
        */
        // Clamp input to verify they are valid and greater than the deadband
        turning = MathUtil.clamp(turning, -1.0d, 1.0d);
        speed = MathUtil.clamp(speed, -1.0d, 1.0d);

        // Apply limiting percentage
        turning *= m_turningLimitPercentage;
        speed *= m_velocityLimitPercentage;
        arcadeDrive(speed, turning);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_drivetrain.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}
