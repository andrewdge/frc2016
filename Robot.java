package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeLiftSubsystem;
import frc.robot.subsystems.IntakeRollerSubsystem;
import frc.robot.subsystems.ShooterBottomSubsystem;
import frc.robot.subsystems.ShooterTopSubsystem;

public class Robot extends TimedRobot{


  //Instantiate subsystems
  public DriveSubsystem driveSubsystem = new DriveSubsystem(this);
  public IntakeRollerSubsystem intakeRollerSubsystem = new IntakeRollerSubsystem(this);
  public IntakeLiftSubsystem intakeLiftSubsystem = new IntakeLiftSubsystem(this);
  public ShooterBottomSubsystem shooterBottomSubsystem = new ShooterBottomSubsystem(this);
  public ShooterTopSubsystem shooterTopSubsystem = new ShooterTopSubsystem(this);
  

  public void robotInit(){

  }

  //Every Periodic method needs to get instance from scheduler
  public void robotPeriodic(){
    Scheduler.getInstance().run();
  }
  
  public void autonomousInit(){

  }

  public void autonomousPeriodic(){
    Scheduler.getInstance().run();
  }

  public void teleopInit(){

  }

  public void teleopPeriodic(){
    Scheduler.getInstance().run();
  }

  public void disabledInit(){
    
  }

  public void disabledPeriodic(){
    Scheduler.getInstance().run();
  }


}
