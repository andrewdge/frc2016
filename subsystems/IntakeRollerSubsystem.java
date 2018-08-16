
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.IO;
import frc.robot.Robot;
import frc.robot.commands.DefaultIntakeRollerCommand;


public class IntakeRollerSubsystem extends Subsystem {
  
  //reference main robot object(robot.java)
  private Robot robot;

  public void initDefaultCommand() {
    setDefaultCommand(new DefaultIntakeRollerCommand(robot));
  }

  //IO
  private VictorSP motorIntake = new VictorSP(IO.motorIntake);
  
  //private constructor
  public IntakeRollerSubsystem(Robot robotInstance){
    robot = robotInstance;
  }

  //stop motor
  public void stopMotors(){
    motorIntake.stopMotor();
  }

  //control motor
  public void setSpeed(double speed){
    motorIntake.set(speed);
  }
}
