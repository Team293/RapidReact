package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.classes.SPIKE293Utils;
import frc.robot.subsystems.Drivetrain;
import static frc.robot.Constants.DrivetrainConstants.*;

public class Rotate extends CommandBase{

    private final Drivetrain m_drivetrain;
    
    public Rotate(Drivetrain drivetrain){
        m_drivetrain = drivetrain;
        SmartDashboard.putNumber("Rotate Degrees", 180);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_drivetrain.rotateDegrees(SmartDashboard.getNumber("Rotate Degrees",180));
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return true;
    }
}
