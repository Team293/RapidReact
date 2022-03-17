package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Compressor;
import static frc.robot.Constants.PneumaticConstants.*;
import static frc.robot.Constants.ClimberConstants.*;
import edu.wpi.first.wpilibj.Solenoid;

public class Climb extends SubsystemBase 
{
    
    private Solenoid leftClimbSolenoid;
    private Solenoid rightClimbSolenoid;
    private Compressor compressor;

    public Climb() {
        compressor = new Compressor(PNEUMATIC_MODULE_ID, PNUEMATIC_MODULE_TYPE);

        compressor.enableAnalog(LOWEST_COMPRESSOR_PSI, HIGHEST_COMPRESSOR_PSI);
        
        rightClimbSolenoid = new Solenoid(PNEUMATIC_MODULE_ID, PNUEMATIC_MODULE_TYPE, RIGHT_SOLENOID);
        leftClimbSolenoid = new Solenoid(PNEUMATIC_MODULE_ID, PNUEMATIC_MODULE_TYPE, LEFT_SOLENOID);
         
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

    // Put methods for controlling this subsystem here. Call these from Commands.
    public void climberDown() 
    {
        rightClimbSolenoid.set(true);
        leftClimbSolenoid.set(true);
    }

    public void climberUp() 
    {
        rightClimbSolenoid.set(false);
        leftClimbSolenoid.set(false);

    }
}
