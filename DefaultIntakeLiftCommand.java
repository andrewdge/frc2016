/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Controls;
import frc.robot.Robot;

public class DefaultIntakeLiftCommand extends Command {

  private Robot robot;

  public DefaultIntakeLiftCommand(Robot robotInstance){
    robot = robotInstance;
    requires(robot.intakeLiftSubsystem);
  }

  protected void execute() {
    if(robot.isOperatorControl()){
      
      robot.intakeLiftSubsystem.setSpeed(Controls.intakeLiftThrottle());

    }else robot.intakeLiftSubsystem.stopMotors();
  }

 
  protected boolean isFinished() {
    return false;
  }
}
