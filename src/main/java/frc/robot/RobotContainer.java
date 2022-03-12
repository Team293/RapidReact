// RobotBuilder Version: 4.0
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
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot
 * (including subsystems, commands, and button mappings) should be declared
 * here.
 */
public class RobotContainer {
  // Robots Subsystems
  private static RobotContainer m_robotContainer = new RobotContainer();
  public final Kinematics m_kinematics = new Kinematics(new Position2D(0.0, 0.0, 0.0));
  public final Targeting m_targeting = new Targeting();
  public final Drivetrain m_drivetrain = new Drivetrain(m_kinematics);
  public final Launcher m_launcher = new Launcher();
  public final Feeder m_feeder = new Feeder();

  // Joysticks
  public final XboxController m_driverXboxController = new XboxController(0);
  public final XboxController m_operatorXboxController = new XboxController(1);

  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  private RobotContainer() {
    // SmartDashboard Buttons
    SmartDashboard.putData("ArcadeDrive", new ArcadeDrive(m_drivetrain, m_driverXboxController));

    // Configure the button bindings
    configureButtonBindings();

    // Setting default command for drivetrain as VelocityDrive
    m_drivetrain.setDefaultCommand(new ArcadeDrive(m_drivetrain, m_driverXboxController));
    m_feeder.setDefaultCommand(new BallControl(m_feeder));
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Create some buttons
    final JoystickButton xboxFeedBtn = new JoystickButton(m_driverXboxController,
        XboxController.Button.kRightBumper.value);
    xboxFeedBtn.whileHeld(new Fire(m_feeder, m_launcher));

    final JoystickButton xboxTargetBtn = new JoystickButton(m_driverXboxController,
        XboxController.Button.kLeftBumper.value);
    xboxTargetBtn.whileHeld(new TrackTarget(m_drivetrain, m_targeting));

    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    Command autoCommand = new SequentialAutoCommand(m_drivetrain, m_kinematics, StartPositions.LEFT);

    if (DriverStation.getLocation() == 1) {
      autoCommand = new SequentialAutoCommand(m_drivetrain, m_kinematics, StartPositions.LEFT);
    } else if (DriverStation.getLocation() == 2) {
      autoCommand = new SequentialAutoCommand(m_drivetrain, m_kinematics, StartPositions.MIDDLE);
    } else if (DriverStation.getLocation() == 3) {
      autoCommand = new SequentialAutoCommand(m_drivetrain, m_kinematics, StartPositions.RIGHT);
    } else {
      System.out.println("Field location error");
    }

    return autoCommand;
  }

  public Command getTeleopCommand() {
    return new ArcadeDrive(m_drivetrain, m_driverXboxController);
  }
}
