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
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 *
 */
public class BallPickup extends SubsystemBase 
{
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private CANSparkMax geckoMotor;
    private DoubleSolenoid m_pivotPiston;
    private Feeder m_feeder;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    private enum BallPickupState
    {
        IDLE_OFF,
        GECKO_ON,
        IDLE_ON,
        GECKO_OFF,
        
    }

    private BallPickupState m_state;
    
    /**
    *
    */
    public BallPickup(Feeder feeder) 
    {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        m_pivotPiston = new DoubleSolenoid(0, 1, 0);
        addChild("pivotPiston",m_pivotPiston);
        
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        geckoMotor = new CANSparkMax(7, MotorType.kBrushless);
        geckoMotor.setInverted(false);

        m_feeder = feeder;
        m_state = BallPickupState.IDLE_OFF;
    }

    @Override
    public void periodic() 
    {
        // This method will be called once per scheduler run
        switch(m_state)
        {
            case IDLE_OFF:
                break;
            case GECKO_OFF:
                geckoToggleOff();
                m_feeder.ingest(false); 
                m_state = BallPickupState.IDLE_OFF;
                break;
            case GECKO_ON:
                geckoToggleOn();
                m_feeder.ingest(true);
                m_state = BallPickupState.IDLE_ON; 
                break;
            case IDLE_ON:
                break;
            default:
                break;
        }
    }

    @Override
    public void simulationPeriodic() 
    {
        // This method will be called once per scheduler run when in simulation
    }

    public boolean isGeckoOn()
    {
        boolean enabled = false;
        if((BallPickupState.GECKO_ON == m_state) || (BallPickupState.IDLE_ON == m_state))
        {
            enabled = true;
        }

        return enabled;
    }

    public void geckoToggle(boolean enabled)
    {
        if(false == enabled)
        {
            m_state = BallPickupState.GECKO_OFF;
        }
        else
        {
            m_state = BallPickupState.GECKO_ON;
        }
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private void geckoToggleOn()
    {
        m_pivotPiston.set(Value.kForward);
        geckoMotor.set(0.65);
    }

    private void geckoToggleOff()
    {
        m_pivotPiston.set(Value.kReverse);
        geckoMotor.set(0);
    }
}
