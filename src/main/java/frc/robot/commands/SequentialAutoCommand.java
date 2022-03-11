package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.AutonomousCommandConstants.StartPositions;
import frc.robot.classes.Kinematics;
import frc.robot.classes.Position2D;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Launcher;
import frc.robot.subsystems.Targeting;
import edu.wpi.first.wpilibj.DriverStation;

public class SequentialAutoCommand extends SequentialCommandGroup {
    private StartPositions m_startPosition;
    private Drivetrain m_drivetrain;
    private Kinematics m_kinematics;
    private Feeder m_feeder;
    private Targeting m_targeting;
    private Launcher m_launcher;

    public SequentialAutoCommand(Drivetrain drivetrain, Kinematics kinematics, Feeder feeder, Targeting targeting, Launcher launcher, StartPositions startPosition, boolean startsRed) {

        m_drivetrain = drivetrain;
        m_kinematics = kinematics;
        m_startPosition = startPosition;
        m_feeder = feeder;
        m_targeting = targeting;
        m_launcher = launcher;
        /*  Thing 1 is the determining variable over whether the autonomous is inversed which is based off of the color
        Red = Negative
        Blue (Else Case) = Positive
         */ 
        double thing1;

        if(startsRed){
            thing1 = -1.0;
        }
        else{
            thing1 = 1.0;
        }

        SmartDashboard.putBoolean("AutoDone", false);

        switch (m_startPosition) {
            case LEFT:
                addCommands(
                        new ResetKinematics(new Position2D(-7.169, 3.509, Math.toRadians(0)), m_drivetrain, m_kinematics),
                        new DriveTo(new Position2D(-10.783, 6.804, Math.toRadians(0)), 2.0d, false, m_kinematics, m_drivetrain),
                        new ParallelCommandGroup(
                            new BallControl(m_feeder), 
                            new DriveTo(new Position2D(-10.783, 6.804, Math.toRadians(0)), 2.0d, false, m_kinematics, m_drivetrain)),
                        new Rotate(m_drivetrain, 180.0),
                        new TrackTarget(m_drivetrain,m_targeting),
                        new ParallelRaceGroup(new Fire(m_feeder, m_launcher), new Wait(3.0)),
                        new Rotate(m_drivetrain, 90.0)
                        
                // new DriveTo(new Position2D(7, 14, Math.toRadians(0)),2.0d, false,
                // m_kinematics, m_drivetrain)
                // new DriveTo(new Position2D(16, 0, Math.toRadians(270)),2.0d, false,
                // m_kinematics, m_drivetrain),
                // new DriveTo(new Position2D(0, 0, Math.toRadians(180)),2.0d, false,
                // m_kinematics, m_drivetrain)
                );

                break;
            case MIDDLE:

                break;
            case RIGHT:

                break;
            default:
                break;
        }
    }
}
