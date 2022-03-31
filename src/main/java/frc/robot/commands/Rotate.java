package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import static frc.robot.Constants.DrivetrainConstants.*;

public class Rotate extends CommandBase {

    private final Drivetrain m_drivetrain;
    private double m_targetDegrees;
    private boolean m_firstRun;
    private int m_delayCounter =1;
    private double initalAngle;

    public Rotate(Drivetrain drivetrain, double targetDegrees) {
        m_drivetrain = drivetrain;
        m_targetDegrees = targetDegrees;
        initalAngle = m_drivetrain.getGyroYawDegrees();
        addRequirements(m_drivetrain);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_firstRun = true;
        m_drivetrain.rotateDegrees(m_targetDegrees);
        SmartDashboard.putBoolean("I finished ", false);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_delayCounter --;
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns false when the command should end.
    @Override
    public boolean isFinished() {
        boolean retVal = false;
        // if(m_delayCounter <= 0)
        // {
        //     if(Math.abs(m_drivetrain.getMotorError()) < ALLOWABLE_DRIVETRAIN_ERROR){
        //         retVal = true;
        //     }
        // }
        if(Math.abs(m_drivetrain.getGyroYawDegrees() - Math.abs(initalAngle - m_targetDegrees)) < 1){
            SmartDashboard.putBoolean("I finished", true);
            retVal = true;
        }
        

        return retVal;
    }
}
