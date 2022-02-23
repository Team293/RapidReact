package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Launcher;
import frc.robot.subsystems.Feeder;

public class Fire extends CommandBase{

    Feeder m_feeder;
    Launcher m_launcher;

    public Fire(Feeder feeder, Launcher launcher){
        m_feeder = feeder;
        m_launcher = launcher;
    }

    @Override
    public void initialize(){
    }

    @Override
    public void execute(){
        if(m_feeder.getTriggerProximity()){
            if(DriverStation.getAlliance().equals(Alliance.Blue) && m_feeder.getBallColor().equals(Color.kBlue)){ // colorSensor sees  blue color
                // get distance from limelight
                // set launch rpm 
            } 
            else { // colorSensor sees red color / no ball
                //set dump rpm
            }
        }
        if(m_launcher.isReady()){
            m_feeder.fire();
        }
    }

    @Override
    public boolean isFinished(){
        return false;
    }

    @Override
    public void end(boolean interrupted){
    }
}
