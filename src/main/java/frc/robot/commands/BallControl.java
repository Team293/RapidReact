package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Feeder;

public class BallControl extends CommandBase{

    Feeder m_feeder;

    public BallControl(Feeder feeder){
        m_feeder = feeder;
    }
    
    @Override
    public void initialize(){
    }

    @Override
    public void execute(){
        m_feeder.smartBelt();
    }

    @Override
    public boolean isFinished(){
        return false;
    }

    @Override
    public void end(boolean interrupted){
    }
    
}
