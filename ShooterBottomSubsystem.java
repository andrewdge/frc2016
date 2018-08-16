package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.IO;
import frc.robot.Robot;
import frc.robot.commands.DefaultShooterBottomCommand;

public class ShooterBottomSubsystem extends PIDSubsystem {
  //reference main robot object(robot.java)
  private Robot robot;

  public void initDefaultCommand() {
    setDefaultCommand(new DefaultShooterBottomCommand(robot));
  }
  
  //Instantiate IO
  private VictorSP motorShooter = new VictorSP(IO.motorShooterBottom);
  private Counter counter = new Counter(IO.tachBottom);

  

  //private constructor- class should only be instantiated once in the getInstance method
  public ShooterBottomSubsystem(Robot robotInstance){
    super(.01,0,0); //PID constants, ask mcleod
    robot = robotInstance;

    //set PID Controller Options
    setAbsoluteTolerance(200); // If potentiometer is within +- this value is considered on target
    getPIDController().enable();
  }

  protected double returnPIDInput(){
    return counter.getRate()*60; //for rpm since counter is in hz
  }

  protected void usePIDOutput(double output){
    motorShooter.pidWrite(output);
  }

  public void setTargetSpeed(int rate){
    setSetpoint(rate);
  }

  public void stopMotors(){
    motorShooter.stopMotor();
  }
}

