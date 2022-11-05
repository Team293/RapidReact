package frc.robot.classes;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;

public abstract class TimedCommand extends CommandBase {
    private final double m_timeout;
    private double m_startTime = -1;

    /**
     * Creates a new TimedCommand.
     *
     * @param timeout      the time (in seconds) before this command "times out"
     * @param requirements the subsystems required by this command
     */
    public TimedCommand(double timeout, Subsystem... requirements) {
        m_timeout = timeout;
        addRequirements(requirements);
    }

    /**
     * Creates a new TimedCommand.
     *
     * @param timeout the time (in seconds) before this command "times out"
     */
    public TimedCommand(double timeout) {
        m_timeout = timeout;
    }

    @Override
    public void initialize() {
        m_startTime = Timer.getFPGATimestamp();
    }

    @Override
    public boolean isFinished() {
        return Timer.getFPGATimestamp() - m_startTime >= m_timeout;
    }
}
