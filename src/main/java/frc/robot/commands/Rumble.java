package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import frc.robot.classes.TimedCommand;

public class Rumble extends TimedCommand {

  XboxController m_controller;
  double m_percent;

  public Rumble(XboxController controller, double percent, double time) {
    super(time);
    m_controller = controller;
    m_percent = percent;
  }

  @Override
  public void initialize() {
    setRumble(m_percent);
  }

  @Override
  public void execute() {
    // TODO Auto-generated method stub
    setRumble(m_percent);
  }

  @Override
  public void end(boolean interrupted) {
    // TODO Auto-generated method stub
    setRumble(0);
  }

  private void setRumble(double value) {
    m_controller.setRumble(RumbleType.kLeftRumble, value);
    m_controller.setRumble(RumbleType.kRightRumble, value);
  }
}