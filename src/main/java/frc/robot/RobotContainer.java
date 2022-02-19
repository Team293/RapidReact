// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.

package frc.robot;

import frc.robot.Constants.AutonomousCommandConstants.StartPositions;
import frc.robot.classes.Kinematics;
import frc.robot.classes.Position2D;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
// The robot's subsystems
    public final Kinematics m_kinematics = new Kinematics(new Position2D(0.0,0.0,0.0));
    public final Drivetrain m_drivetrain = new Drivetrain(m_kinematics);
    public final Launcher m_launcher = new Launcher();
    public final BallPickUp m_ballPickUp = new BallPickUp();

// Joysticks
    public final XboxController m_xboxController = new XboxController(0); 
    public final XboxController m_operatorXboxController = new XboxController(1); 

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();
  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Smartdashboard Subsystems


    // SmartDashboard Buttons
    Command autoCommand = new SequentialAutoCommand(m_drivetrain, m_kinematics, StartPositions.LEFT);
    
    SmartDashboard.putData("ArcadeDrive", new ArcadeDrive( m_drivetrain, m_xboxController ));

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
    
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND

    // Configure autonomous sendable chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        //Setting default command for drivetrain as VelocityDrive
        m_drivetrain.setDefaultCommand(new ArcadeDrive( m_drivetrain, m_xboxController));
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
    // Create some buttons
    final JoystickButton ballPickUpOnButton = new JoystickButton(m_operatorXboxController, XboxController.Button.kA.value);
    ballPickUpOnButton.whenPressed(new ToggleBallPickUp(m_ballPickUp));
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
  }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    // The selected command will be run in autonomous
    Command autoCommand = new SequentialAutoCommand(m_drivetrain, m_kinematics, StartPositions.LEFT);
    
    if(DriverStation.getLocation() == 1){
      autoCommand = new SequentialAutoCommand(m_drivetrain, m_kinematics, StartPositions.LEFT);
    }
    else if(DriverStation.getLocation() == 2){
      autoCommand = new SequentialAutoCommand(m_drivetrain, m_kinematics, StartPositions.MIDDLE);
    }
    else if(DriverStation.getLocation() == 3){
      autoCommand = new SequentialAutoCommand(m_drivetrain, m_kinematics, StartPositions.RIGHT);
    }
    else{
      System.out.println("Field location error");
    }
    return autoCommand;
  }
  
  public Command getTeleopCommand()
  {
        return new ArcadeDrive(m_drivetrain, m_xboxController);
  }

}

