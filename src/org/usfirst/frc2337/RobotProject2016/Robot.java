
package org.usfirst.frc2337.RobotProject2016;

import java.io.IOException;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2337.RobotProject2016.commands.*;
import org.usfirst.frc2337.RobotProject2016.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    Command autonomousCommand;
    //SendableChooser autonChooser;

    public static OI oi;

    public static Intake intake;
    public static PowerTakeOff powerTakeOff;
    public static ChassisPID chassisPID;
    public static Scaler scaler;
    public static IntakeWrist intakeWrist;
    public static ChassisShifter chassisShifter;
    public static DriveCamera driveCamera;
    public static LED Led;
    public static ShooterArmPID shooterArmPID;
    public static ShooterRetractor shooterRetractor;
    public static Shooter shooter;
    public static PortWheels PortWheels;

    public static Preferences prefs;
    public static Preferences prefsShooterRetract;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    RobotMap.init();

        intake = new Intake();
        powerTakeOff = new PowerTakeOff();
        chassisPID = new ChassisPID();
        scaler = new Scaler();
        intakeWrist = new IntakeWrist();
        chassisShifter = new ChassisShifter();
        driveCamera = new DriveCamera();
        Led = new LED();
        shooterArmPID = new ShooterArmPID();
        shooter = new Shooter();
        shooterRetractor = new ShooterRetractor();
        
      //Preference variables
        prefs = Preferences.getInstance();
        prefsShooterRetract = Preferences.getInstance();
        
        oi = new OI();

        // Autonomous
        /*
        autonChooser = new SendableChooser();
        autonChooser.addDefault("Do Nothing", new auton_Wait(15));
        autonChooser.addObject("AutonMain", new auton_Main());
        autonChooser.addObject("Auton_GyroFwd", new Auton_GyroFwd());
        autonChooser.addObject("Grab Container First", new auton_SimpleReach());
        autonChooser.addObject("GyroAndEncoderFwd", new Auton_GyroAndEncoderFwd(0.5, 1200, 4.0));      
        */
        
        RobotMap.gyro.reset();


    }

	public void robotPeriodic() {
		LiveWindow.run();

	  SmartDashboard.putBoolean(  "IMU_Connected",        RobotMap.gyro.isConnected());
      SmartDashboard.putBoolean(  "IMU_IsCalibrating",    RobotMap.gyro.isCalibrating());
      SmartDashboard.putNumber(   "IMU_Yaw",              RobotMap.gyro.getYaw());
      SmartDashboard.putNumber(   "IMU_Pitch",            RobotMap.gyro.getPitch());
      SmartDashboard.putNumber(   "IMU_Roll",             RobotMap.gyro.getRoll());
      SmartDashboard.putNumber(   "IMU_ANGLE",             RobotMap.gyro.getAngle());
      SmartDashboard.putBoolean("okToShoot", RobotMap.okToShoot);
      SmartDashboard.putBoolean("leftBall", RobotMap.intakeLeftBallSensor.get());
      SmartDashboard.putBoolean("RightBall", RobotMap.intakeRightBallSensor.get());
      SmartDashboard.putBoolean("gotBall", Robot.intake.gotBallSensorState());
      SmartDashboard.putDouble("Encoder distance" , RobotMap.chassisPIDLeftEncoder.getRate());
      SmartDashboard.putNumber("Encoder distance" , RobotMap.chassisPIDLeftEncoder.getDistance());
      SmartDashboard.putBoolean("Shifter Status" , RobotMap.chassisShiftershiftSolenoid.get());
      SmartDashboard.putNumber("String pot" , RobotMap.shooterArmPIDshooterArmPot.get());
      SmartDashboard.putNumber("arm set pt" , Robot.shooterArmPID.getSetpoint());
      SmartDashboard.putNumber("arm get position" , Robot.shooterArmPID.getPosition());
      SmartDashboard.putBoolean("arm pid enabled?" , Robot.shooterArmPID.getPIDStatus());
      SmartDashboard.putNumber("arm joystick y" , Robot.oi.operatorJoystick.getRawAxis(1));
      SmartDashboard.putNumber("arm get position" , Robot.shooterArmPID.getPIDController().getError());
      SmartDashboard.putBoolean("Do We See the Target?" , RobotMap.seeTarget);
      
      SmartDashboard.putNumber("Retractor: get", RobotMap.shooterRetractMotorA.get());
      SmartDashboard.putBoolean("Retractor: shooterRetractPrimed", RobotMap.shooterRetractPrimed);
      SmartDashboard.putBoolean("Retractor: shooterRetractRetracted", RobotMap.shooterRetractRetracted);
      SmartDashboard.putData(Robot.shooterRetractor.getCurrentCommand());
      SmartDashboard.putNumber("Retractor: CL err:", RobotMap.shooterRetractMotorA.getClosedLoopError());
      SmartDashboard.putNumber("Retractor: getError", RobotMap.shooterRetractMotorA.getError());
      SmartDashboard.putNumber("Retractor: getEncpos", RobotMap.shooterRetractMotorA.getEncPosition());
      SmartDashboard.putNumber("Retractor: ouputVoltage", RobotMap.shooterRetractMotorA.getOutputVoltage());
      SmartDashboard.putNumber("Retractor: PW Velocity", RobotMap.shooterRetractMotorA.getPulseWidthPosition());
      SmartDashboard.putNumber("Retractor: getPosition", RobotMap.shooterRetractMotorA.getPosition());
      SmartDashboard.putNumber("Retractor: getSetpoint", RobotMap.shooterRetractMotorA.getSetpoint());
      
      
      
      SmartDashboard.putBoolean("getIntakeWristStatus",  Robot.intakeWrist.getIntakeWristStatus());
      SmartDashboard.putBoolean("shooterArmOnTarget",  RobotMap.shooterArmOnTarget);
      
  

    
      

	}

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	RobotMap.gyro.reset();
    	RobotMap.shooterArmPIDMotorA.enableBrakeMode(true);
    	autonomousCommand = new Auton_GyroFwd();
    	//autonomousCommand = (Command) autonChooser.getSelected();
        if (autonomousCommand != null) autonomousCommand.start();
        


    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        robotPeriodic();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        robotPeriodic();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
