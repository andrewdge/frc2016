package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Controls;
import frc.robot.Robot;

public class DefaultDriveCommand extends Command{
  //reference to main robot object(robot.java)
  private Robot robot;

  //constructor
  //needs driveSubsystem
  public DefaultDriveCommand(Robot robotInstance){
    robot = robotInstance;
    requires(robot.driveSubsystem);
  }

  //runs every few seconds
  protected void execute(){
    if(robot.isOperatorControl()){ // only drive with joysticks on teleop mode

      //Tank Drive with left and right joysticks
      robot.driveSubsystem.tankDrive(Controls.driveLeftThrottle(), Controls.driveRightThrottle());

      //otherwise, stop
    }else robot.driveSubsystem.stopMotors();
    
  }

  protected boolean isFinished(){
    return false;
  }
}
