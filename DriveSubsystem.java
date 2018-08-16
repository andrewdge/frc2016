package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.IO;
import frc.robot.Robot;
import frc.robot.commands.DefaultDriveCommand;

public class DriveSubsystem extends Subsystem {
  //reference main robot object(robot.java)
  private Robot robot;

  public void initDefaultCommand() {
    setDefaultCommand(new DefaultDriveCommand(robot));
  }
  
  //Instantiate IO
  private VictorSP motorLeft = new VictorSP(IO.motorDriveLeft);
  private VictorSP motorRight = new VictorSP(IO.motorDriveRight);
  
  //DifferentialDrive for tank drive
  private DifferentialDrive drive = new DifferentialDrive(motorLeft, motorRight);

  //private constructor- class should only be instantiated once in the getInstance method
  public DriveSubsystem(Robot robotInstance){
    robot = robotInstance;
  }

  //Drive motors using left and right speeds
  public void tankDrive(double leftSpeed, double rightSpeed){
    drive.tankDrive(leftSpeed, rightSpeed, false);
  }

  //stop motors
  public void stopMotors(){
    drive.stopMotor();
  }
}
