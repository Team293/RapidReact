package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class Rotate extends CommandBase {

    private final Drivetrain m_drivetrain;
    private double m_targetDegrees;
    private boolean m_firstRun;

    public Rotate(Drivetrain drivetrain, double targetDegrees) {
        m_drivetrain = drivetrain;
        m_targetDegrees = targetDegrees;
        addRequirements(m_drivetrain);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_firstRun = true;
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if(true == m_firstRun){
            m_drivetrain.rotateDegrees(m_targetDegrees); 
            m_firstRun = false;
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns false when the command should end.
    @Override
    public boolean isFinished() {
        boolean retVal = false;
        if(Math.abs(m_drivetrain.getMotorError()) < 1){
            retVal = true;
        }

        return retVal;
    }
}
