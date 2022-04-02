package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class Rotate extends CommandBase {

    private final Drivetrain m_drivetrain;
    private double m_targetDegrees;
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
        m_drivetrain.rotateDegrees(m_targetDegrees);
        SmartDashboard.putBoolean("finished rotating", false);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns false when the command should end.
    @Override
    public boolean isFinished() {
        boolean retVal = false;
        if(Math.abs(m_drivetrain.getGyroYawDegrees() - Math.abs(initalAngle - m_targetDegrees)) < 40){
            SmartDashboard.putBoolean("finished rotating", true);
            retVal = true;
        }
        

        return retVal;
    }
}
