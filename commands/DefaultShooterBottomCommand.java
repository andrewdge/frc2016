package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Controls;
import frc.robot.Robot;

public class DefaultShooterBottomCommand extends Command {
  //reference to main robot object
  private Robot robot;

  //constructor
  public DefaultShooterBottomCommand(Robot robotInstance) {
    robot = robotInstance;
    requires(robot.shooterBottomSubsystem);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(robot.isOperatorControl()){

      robot.shooterBottomSubsystem.setTargetSpeed(Controls.getShooterBottomRPM());

    }else robot.shooterBottomSubsystem.stopMotors();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }
}
