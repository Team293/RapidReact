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
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.ColorSensorV3;
import static frc.robot.Constants.FeederConstants.*;

/**
 *
 */
public class Feeder extends SubsystemBase {
    private WPI_TalonFX m_beltMotor;
    private WPI_TalonFX m_triggerMotor;
    private ColorSensorV3 m_colorSensor;
    private DigitalInput m_beltSensor;

    // Feeder subsystem
    public Feeder() {
        m_beltMotor = new WPI_TalonFX(BELT_CAN_ID);        // need to change
        m_triggerMotor = new WPI_TalonFX(TRIGGER_CAN_ID);     // need to change
        

        m_beltMotor.clearStickyFaults();
        m_beltMotor.configFactoryDefault();
        m_triggerMotor.clearStickyFaults();
        m_triggerMotor.configFactoryDefault();
        m_beltMotor.setInverted(true);
        m_triggerMotor.setInverted(true);

        m_beltMotor.setNeutralMode(NeutralMode.Brake);
        m_triggerMotor.setNeutralMode(NeutralMode.Brake);

        m_colorSensor = new ColorSensorV3(COLOR_SENSOR_PORT);
        m_beltSensor = new DigitalInput(BELT_SENSOR_PORT);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        SmartDashboard.putNumber("Feeder Current Percentage", m_beltMotor.getMotorOutputPercent());
        SmartDashboard.putBoolean("Trigger Has Ball", isTriggerSensorBallPresent());
        SmartDashboard.putBoolean("Belt has ball", isBeltSensorBallPresent());
        SmartDashboard.putNumber("Trigger senesor val ", m_colorSensor.getProximity());
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation
    }

    // Turns belt motor on / off
    public void setBeltMotor(double percent) {
        m_beltMotor.set(percent);
    }

    // Turns trigger motor on / off
    public void setTriggerMotor(double percent) {
        m_triggerMotor.set(percent);
    }

    /**
     * @return true if the ball is present
     */
    public boolean isTriggerSensorBallPresent() {
        return (m_colorSensor.getProximity() > PROXIMITY_THRESHOLD);
    }

    public boolean isBeltSensorBallPresent() {
        return (false == m_beltSensor.get());
    }

    // Returns ball color through Color class
    public Color getTriggerBallColor() {
        double redPercent = m_colorSensor.getColor().red; // percentage of red
        double bluePercent = m_colorSensor.getColor().blue; // percentage of blue
        Color ballColor = Color.kBlue; // default color is blue

        if (redPercent > bluePercent) {
            ballColor = Color.kRed;
        }
        return ballColor;
    }
}