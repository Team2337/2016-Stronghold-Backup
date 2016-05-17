
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
    SendableChooser autonChooser;
    SendableChooser locationChooser;
    SendableChooser shotChooser;
    SendableChooser delayChooser;
    SendableChooser defensechooser;
    

    public static OI oi;

    public static Intake intake;
    public static PowerTakeOff powerTakeOff;
    public static ChassisPID chassisPID;
    public static Scaler scaler;
    public static LinearAcceleratorElevator linAccElevator;
    public static ChassisShifter chassisShifter;
    public static DriveCamera driveCamera;
    public static LED Led;
    public static IntakeArmPID intakeArmPID;
    public static ShooterRetractor shooterRetractor;
    public static Shooter shooter;
    public static targetLED targetLED;

    public static Preferences prefs;
    public static int autonPosition;
    public static int autonshot;
    public static int autondelay;
    public static String autondefense;
    //public static Preferences prefsShooterRetract;
    public boolean whitebutton;

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
        linAccElevator = new LinearAcceleratorElevator();
        chassisShifter = new ChassisShifter();
        driveCamera = new DriveCamera();
        Led = new LED();
        intakeArmPID = new IntakeArmPID();
        shooter = new Shooter();
        shooterRetractor = new ShooterRetractor();
        targetLED = new targetLED();
        
      //Preference variables
        prefs = Preferences.getInstance();
        //prefsShooterRetract = Preferences.getInstance();
        
        oi = new OI();


        
        // Autonomous
        
        locationChooser = new SendableChooser();

		
		locationChooser.addObject("Pos 2", 2);
		locationChooser.addObject("Pos 3", 3);
		locationChooser.addObject("Pos 4", 4);
		locationChooser.addObject("Pos 5", 5);
		
        
		shotChooser = new SendableChooser();
		shotChooser.addDefault("Stop", 0);
		shotChooser.addObject("Drop Ball", 1);
		shotChooser.addObject("Shoot High", 2);
		shotChooser.addObject("Return (only cross)", 3);
		
		delayChooser = new SendableChooser();
		delayChooser.addDefault("No Delay", 0);
		delayChooser.addObject("5 Second Delay", 5);
		delayChooser.addObject("8 Second Delay", 8);
		
		
		
		
		
		
		defensechooser = new SendableChooser();
		defensechooser.addDefault("Do Nothing", "nothing");
		defensechooser.addObject("Reach", "reach");
		defensechooser.addObject("Cross Flat Defenses", "cross");     
		defensechooser.addObject("Chevy","chevy"); 
		defensechooser.addObject("Portcullis", "port"); 
		
		//defensechooser.addObject("Cross Turn: LEFT", new auton_CrossWithTurn(1));
		//defensechooser.addObject("Cross Turn: RIGHT", new auton_CrossWithTurn(0));
		
		
		
		
		/*
    	
        autonChooser = new SendableChooser();
        autonChooser.addDefault("Do Nothing", new auton_Wait(15));
        autonChooser.addObject("Reach", new auton_Reach());
        autonChooser.addObject("Cross Flat Defenses", new auton_Cross());     
        autonChooser.addObject("Chevy", new auton_Chevy()); 
        autonChooser.addObject("Portcullis", new auton_Portcullis()); 
        autonChooser.addObject("Cross Turn: LEFT", new auton_CrossWithTurn(1));
        autonChooser.addObject("Cross Turn: RIGHT", new auton_CrossWithTurn(0));
        */
		
        //autonChooser.addObject("Low Bar", new auton_LowBar()); 
        //autonChooser.addObject("Cross And Shoot", new auton_CrossAndShoot()); 
      //autonChooser.addObject("Chevy Pos 3 or 4 and shoot high", new auton_ChevyPos3and4Shoot()); 
        //autonChooser.addObject("Portcullis and shoot high", new auton_PortcullisAndShoot()); 
        //autonChooser.addObject("Distance Test", new auton_DistanceTest()); 
        //autonChooser.addObject("Cross Flat Def. then re-Cross", new auton_CrossThenReverse());
        //autonChooser.addObject("Main", new auton_MainCG()); 
       // autonChooser.addObject("Roll with it!", new Auton_GyroAndEncoderDriveTillRoll(0.3, 10.0, -6));
        
        
        RobotMap.gyro.reset();


    }

	public void robotPeriodic() {
		LiveWindow.run();
	
		SmartDashboard.putData(		"Defense Chooser", 		defensechooser);	
		//SmartDashboard.putData(		"Auton Chooser", 		autonChooser);	
		SmartDashboard.putData(		"Position Chooser", 		locationChooser);	
		SmartDashboard.putData(		"Shot Chooser", 		shotChooser);
		SmartDashboard.putData(		"Delay Chooser", 		delayChooser);
		
	  //SmartDashboard.putBoolean(  "IMU_Connected",        RobotMap.gyro.isConnected());
      //SmartDashboard.putBoolean(  "IMU_IsCalibrating",    RobotMap.gyro.isCalibrating());
      SmartDashboard.putNumber(   "IMU_Yaw",              RobotMap.gyro.getYaw());
      SmartDashboard.putNumber(   "IMU_ANGLE",             RobotMap.gyro.getAngle());
      SmartDashboard.putNumber(   "IMU_ROLL",             RobotMap.gyro.getRoll());
      //SmartDashboard.putNumber(   "IMU_PITCH",             RobotMap.gyro.getPitch());

      SmartDashboard.putNumber("Left Speed" , RobotMap.chassisPIDchassisLeft1.get());
      SmartDashboard.putNumber("Right Speed" , RobotMap.chassisPIDchassisRight1.get());
      //SmartDashboard.putNumber(   "Turn_Yaw",              RobotMap.gyro.getYaw()*.05);
     
      SmartDashboard.putBoolean("Shifter Status" , RobotMap.chassisShiftershiftSolenoid.get());
      SmartDashboard.putNumber("String pot" , RobotMap.shooterArmPIDshooterArmPot.get());
      SmartDashboard.putBoolean("Do We See the Target?" , RobotMap.seeTarget);
      //SmartDashboard.putNumber("Retractor: get", RobotMap.shooterRetractMotorA.get());
      SmartDashboard.putBoolean("Retractor: shooterRetractPrimed", RobotMap.shooterRetractPrimed);
      SmartDashboard.putBoolean("Retractor: shooterRetractRetracted", RobotMap.shooterRetractRetracted);
     // SmartDashboard.putData(Robot.shooterRetractor.getCurrentCommand());
      //SmartDashboard.putNumber("Retractor: CL err:", RobotMap.shooterRetractMotorA.getClosedLoopError());
      //SmartDashboard.putNumber("Retractor: getError", RobotMap.shooterRetractMotorA.getError());
      //SmartDashboard.putNumber("Retractor: getEncpos", RobotMap.shooterRetractMotorA.getEncPosition());
      //SmartDashboard.putNumber("Retractor: ouputVoltage", RobotMap.shooterRetractMotorA.getOutputVoltage());
      //SmartDashboard.putNumber("Retractor: PW Velocity", RobotMap.shooterRetractMotorA.getPulseWidthPosition());
      SmartDashboard.putNumber("Retractor: getPositionn", RobotMap.shooterRetractMotorA.getPosition());
      SmartDashboard.putNumber("Retractor: getSetpoint", RobotMap.shooterRetractMotorA.getSetpoint());
      SmartDashboard.putNumber("Drive Encoder Get", Robot.chassisPID.readLeftEncoder());
      //SmartDashboard.putNumber("Retractor: getfish", RobotMap.shooterRetractMotorA.get());
      //SmartDashboard.putNumber("Retractor: getencpos", RobotMap.shooterRetractMotorA.getEncPosition());
      SmartDashboard.putBoolean("Retractor: isRevLimitSwitchClosed", RobotMap.shooterRetractMotorA.isRevLimitSwitchClosed());
      SmartDashboard.putNumber("Retractor: lastpos", RobotMap.shooterRetractMotorA.getPosition());
      SmartDashboard.putBoolean("Retractor: SlidePINSensor", RobotMap.slidePINSensor.get());
      //SmartDashboard.putData("Shooter - Shoot", Robot.shooter);
      //SmartDashboard.putData("Linear Elevator Status", Robot.linAccElevator);
      
      SmartDashboard.putBoolean("Intake Ball Sensor", Robot.intake.getBallSensorState());
      SmartDashboard.putBoolean("Retractor Limit", Robot.shooterRetractor.onLimitSwitch());
      
      //SmartDashboard.putBoolean("Linear Elevator Status",  Robot.linAccElevator.getLinAccElevatorStatus());
      //SmartDashboard.putBoolean("Ultrasonic State",  RobotMap.chassisPIDultrasonicSensor.isEnabled());
      SmartDashboard.putNumber("Ultrasonic Distance",  RobotMap.chassisPIDultrasonicSensor.getRangeInches());

      
  

    
      

	}

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	
    	Logger.flushSB();

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
        robotPeriodic();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
		Robot.chassisPID.resetDriveEncoder();
		Robot.chassisPID.resetGyro();
    	RobotMap.intakeArmPIDMotorA.enableBrakeMode(false);     //TODO   Dow we want on
    	RobotMap.intakeArmPIDMotorB.enableBrakeMode(false);
    	//RobotMap.shooterRetractMotorA.setEncPosition(0);
    	Robot.powerTakeOff.LiftOff();
    	//new shooterRetract_PrimeManual();
    	
    	autondelay = (int) delayChooser.getSelected();
		autonPosition = (int) locationChooser.getSelected();
    	autondefense = (String) defensechooser.getSelected();
    	autonshot = (int) shotChooser.getSelected();
    	//System.out.println("shot " + RobotMap.autonshot + " Pos " + RobotMap.autonPosition + " " + RobotMap.autondelay);
    	//autonomousCommand = (Command) autonChooser.getSelected();
    	autonomousCommand = new auton_MainCGCMP(autondelay, autonPosition, autondefense, autonshot); 
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
        //RobotMap.shooterRetractMotorA.setEncPosition(0);
        //RobotMap.shooterRetractMotorA.setSetpoint(RobotMap.shooterRetractMotorA.getPosition());
        RobotMap.shooterRetractMotorA.disable();
        

        
        //Robot.scaler.pinIn();
        
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
