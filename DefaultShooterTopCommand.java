package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Controls;
import frc.robot.Robot;

public class DefaultShooterTopCommand extends Command {
  //reference to main robot object
  private Robot robot;

  //constructor
  public DefaultShooterTopCommand(Robot robotInstance) {
    robot = robotInstance;
    requires(robot.shooterTopSubsystem);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(robot.isOperatorControl()){

      if(Controls.shooterEnable()){
        robot.shooterTopSubsystem.setTargetSpeed(Controls.getShooterTopRPM());
      }else robot.shooterTopSubsystem.stopMotors();

    }else robot.shooterTopSubsystem.stopMotors();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }
}
