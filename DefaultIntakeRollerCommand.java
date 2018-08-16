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

public class DefaultIntakeRollerCommand extends Command {
  //reference to main robot object
  private Robot robot;

  //constructor
  public DefaultIntakeRollerCommand(Robot robotInstance) {
    robot = robotInstance;
    requires(robot.intakeRollerSubsystem);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(robot.isOperatorControl()){

      robot.intakeRollerSubsystem.setSpeed(Controls.intakeRollerThrottle());

    }else robot.intakeRollerSubsystem.stopMotors();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }
}
