package frc.robot;

public final class IO{
    private IO(){}
    
    //Port numbers for systems

    //PWM
    public static final int motorDriveLeft = 0;
    public static final int motorDriveRight = 1;

    //shooter
    public static final int motorShooterTop = 2;
    public static final int motorShooterBottom = 3;

    //intake system
    public static final int motorIntake = 4; // beater bar
    public static final int motorIntakeIn = 5; //intake up down
    
    //analog - decimal #
    
    //digital - on or off
    public static final int limitIntakeUp = 4;
    public static final int limitIntakeDown = 3;

    public static final int tachTop = 6;//shooter spinners
    public static final int tachBottom = 7;
}
