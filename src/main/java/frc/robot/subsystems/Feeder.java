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

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.ColorSensorV3;
import static frc.robot.Constants.FeederConstants.*;


/**
 *
 */
public class Feeder extends SubsystemBase {
    private WPI_TalonFX m_intakeMotor;
    private WPI_TalonFX m_triggerMotor;
    private ColorSensorV3 m_colorSensor;
    private DigitalInput m_beltSensor;

    // Feeder subsystem
    public Feeder() {
        m_intakeMotor = new WPI_TalonFX(6);
        m_triggerMotor = new WPI_TalonFX(7);

        m_intakeMotor.clearStickyFaults();
        m_intakeMotor.configFactoryDefault();
        m_intakeMotor.setInverted(false);

        m_colorSensor = new ColorSensorV3(COLOR_SENSOR_PORT);
        m_beltSensor = new DigitalInput(BELT_SENSOR_PORT);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        SmartDashboard.putNumber("Feeder Current Percentage", m_intakeMotor.getMotorOutputPercent());
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation
    }

    // Turns the feeder on to 25%
    private void intakeOn() {
        m_intakeMotor.set(ControlMode.PercentOutput, 0.25d);
    }

    // Turns the feeder off
    private void intakeOff() {
        m_intakeMotor.set(ControlMode.PercentOutput, 0);
    }

    // Turns Trigger On
    private void triggerOn() {
        m_triggerMotor.set(ControlMode.PercentOutput, 0.30d);
    }

    // Turns Trigger Off
    private void triggerOff() {
        m_triggerMotor.set(ControlMode.PercentOutput, 0);
    }

    /**
     * @return true if the ball is present
     */
    public boolean getTriggerProximity() {
        return (m_colorSensor.getProximity() > PROXIMITY_THRESHOLD);
    }

    public Color getBallColor(){
        double redPercent = m_colorSensor.getColor().red; // percentage of red
        double bluePercent = m_colorSensor.getColor().blue; // percentage of blue
        Color ballColor = Color.kBlue; // default color is purple
        
        if(redPercent > bluePercent){
            ballColor = Color.kRed;
        }
        return ballColor;
    }   

    public void smartBelt(){
        if(!getTriggerProximity())
        {
            intakeOn();
            triggerOn();
        }
        else
        {
            if(m_beltSensor.get())
            {
                intakeOn();
                triggerOff();
            }
            else
            {
                intakeOff();
                triggerOff();
            }
        }
    }

    public void fire(){
        intakeOn();
        triggerOn();
    }

}
