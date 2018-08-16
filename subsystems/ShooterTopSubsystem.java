package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.IO;
import frc.robot.Robot;
import frc.robot.commands.DefaultShooterTopCommand;

public class ShooterTopSubsystem extends PIDSubsystem {
  //reference main robot object(robot.java)
  private Robot robot;

  public void initDefaultCommand() {
    setDefaultCommand(new DefaultShooterTopCommand(robot));
  }
  
  //Instantiate IO
  private VictorSP motorShooter = new VictorSP(IO.motorShooterTop);
  private Counter counter = new Counter(IO.tachTop);

  

  //private constructor- class should only be instantiated once in the getInstance method
  public ShooterTopSubsystem(Robot robotInstance){
    super(.01,0,0); //PID constants, ask mcleod
    robot = robotInstance;

    //set PID Controller Options
    setAbsoluteTolerance(200); // If potentiometer is within +- this value is considered on target
    getPIDController().enable();

    counter.setDistancePerPulse(1);
  }

  protected double returnPIDInput(){
    SmartDashboard.putNumber("Top Count", counter.get());
    SmartDashboard.putNumber("Top Rate", counter.getRate());
    return counter.getRate(); //for rpm since counter is in hz
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

