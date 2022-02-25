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
        if(true == m_feeder.getTriggerProximity()){ // Checks that there is a ball in the trigger
            if(DriverStation.getAlliance().equals(Alliance.Blue) && m_feeder.getBallColor().equals(Color.kBlue)){ // Checks to see that the ball color and alliance color are the same
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
