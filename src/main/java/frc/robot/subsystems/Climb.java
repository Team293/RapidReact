// RobotBuilder Version: 3.1
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Compressor;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
//import static frc.robot.Constants.PneumaticConstants.*;
//import static frc.robot.Constants.ClimberConstants.*;


// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */

public class Climb extends SubsystemBase 
{
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private DoubleSolenoid leftClimbSolenoid;
    private DoubleSolenoid rightClimbSolenoid;
    private Compressor compressor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    public Climb() {

        compressor = new Compressor(7, PneumaticsModuleType.REVPH);

        compressor.enableAnalog(100.0, 119.5);
   
        rightClimbSolenoid = new DoubleSolenoid(7,PneumaticsModuleType.REVPH,0, 1);  // 1 0
        leftClimbSolenoid = new DoubleSolenoid(7,PneumaticsModuleType.REVPH,2, 3); // 3 2

        addChild("lowPressureClimbSolenoid",rightClimbSolenoid);
        addChild("highPressureClimbSolenoid",leftClimbSolenoid);
    }

    @Override
    public void periodic() 
    {
        // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() 
    {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void climberDown() 
    {
        rightClimbSolenoid.set(Value.kReverse);
        leftClimbSolenoid.set(Value.kReverse);  // may need to remove. One down, one up.
    }

    public void climberUp() 
    {
        rightClimbSolenoid.set(Value.kForward);
        leftClimbSolenoid.set(Value.kForward);

    }
    
}