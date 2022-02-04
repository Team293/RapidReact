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

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import static frc.robot.Constants.PneumaticConstants.*;
import static frc.robot.Constants.ClimberConstants.*;


// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */

public class Climb extends SubsystemBase 
{
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private DoubleSolenoid lowPressureClimbSolenoid;
    private DoubleSolenoid highPressureClimbSolenoid;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    public Climb() 
    {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        lowPressureClimbSolenoid = new DoubleSolenoid(0, PNUEMATIC_MODULE_TYPE,LOW_PRESSURE_EXTENSION_SOLENOID, LOW_PRESSURE_RETRACTION_SOLENOID);
        highPressureClimbSolenoid = new DoubleSolenoid(0, PNUEMATIC_MODULE_TYPE,HIGH_PRESSURE_EXTENSION_SOLENOID, HIGH_PRESSURE_RETRACTION_SOLENOID);

        addChild("lowPressureClimbSolenoid",lowPressureClimbSolenoid);
        addChild("highPressureClimbSolenoid",highPressureClimbSolenoid);
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
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
        lowPressureClimbSolenoid.set(Value.kReverse);
        highPressureClimbSolenoid.set(Value.kReverse);  // may need to remove. One down, one up.
    }

    public void climberUp() 
    {
        lowPressureClimbSolenoid.set(Value.kForward);
        highPressureClimbSolenoid.set(Value.kForward);

    }
    /*
    public void climberNeutral() 
    {
        climbSolenoid.set(Value.kOff);
    }
    */
}
