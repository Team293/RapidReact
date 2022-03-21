package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Targeting;

public class EnableLimelight extends CommandBase {

    Targeting m_targeting;

    public EnableLimelight(Targeting targeting) {
        m_targeting = targeting;
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
       m_targeting.controlLight(true);
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void end(boolean interrupted) {
    }
}
