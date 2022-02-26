// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class BallPickUp extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private WPI_TalonFX m_ballPickUpMotor;
    private boolean m_ballPickUpIsOn;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    // Feeder subsystem
    public BallPickUp() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        m_ballPickUpMotor = new WPI_TalonFX(3);

        m_ballPickUpMotor.clearStickyFaults();
        m_ballPickUpMotor.configFactoryDefault();
        m_ballPickUpMotor.setInverted(false);

        m_ballPickUpIsOn = false;

        SmartDashboard.putBoolean("Feeder On", false);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        SmartDashboard.putNumber("Feeder Current Percentage", m_ballPickUpMotor.getMotorOutputPercent());        
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation
    }

    // Turns the ball pick up on to 25%
    public void ballPickUpOn() {
        m_ballPickUpMotor.set(ControlMode.PercentOutput, 0.25d);
        SmartDashboard.putBoolean("Feeder On", true);
        m_ballPickUpIsOn = true;
    }

    // Turns the ball pick up off
    public void ballPickUpOff() {
        m_ballPickUpMotor.set(ControlMode.Current, 0);
        SmartDashboard.putBoolean("Feeder On", false);
        m_ballPickUpIsOn = false;
    }  
    
    // Toggles the ball pick up on / off based on m_ballPickUpIsToggled boolean
    public void toggleBallPickUp() {
        if (m_ballPickUpIsOn) {
            ballPickUpOff();
        } else {
            ballPickUpOn();
        }
    }
}