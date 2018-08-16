
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.IO;
import frc.robot.Robot;
import frc.robot.commands.DefaultIntakeLiftCommand;


public class IntakeLiftSubsystem extends Subsystem {
  
  //reference main robot object(robot.java)
  private Robot robot;

  public void initDefaultCommand() {
    setDefaultCommand(new DefaultIntakeLiftCommand(robot));
  }

  //IO
  private VictorSP motorIntake = new VictorSP(IO.motorIntakeIn);
  private DigitalInput limitUp = new DigitalInput(IO.limitIntakeUp);
  private DigitalInput limitDown = new DigitalInput(IO.limitIntakeDown);
  
  //private constructor
  public IntakeLiftSubsystem(Robot robotInstance){
    robot = robotInstance;
  }

  //stop motor
  public void stopMotors(){
    motorIntake.stopMotor();
  }


  //control motor
  public void setSpeed(double speed){

    if((speed < 0) && (!limitUp.get())){
      motorIntake.set(speed);
    }
    else if((speed > 0) && (!limitDown.get())){
      motorIntake.set(speed);
    }else stopMotors();
  }
}
