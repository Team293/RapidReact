package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.classes.SPIKE293Utils;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Targeting;

import static frc.robot.Constants.DrivetrainConstants.*;

public class Rotate extends CommandBase{

    private final Drivetrain m_drivetrain;
    private final Targeting m_targeting;
    
    public Rotate(Drivetrain drivetrain, Targeting targeting){
        m_drivetrain = drivetrain;
        m_targeting = targeting;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_drivetrain.rotateDegrees(m_targeting.getAngleToTargetDegrees());
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns false when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
