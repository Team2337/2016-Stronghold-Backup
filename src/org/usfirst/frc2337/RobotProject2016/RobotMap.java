
package org.usfirst.frc2337.RobotProject2016;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogAccelerometer;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANSpeedController.ControlMode;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;



/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    public static AHRS gyro;
	
	public static AnalogAccelerometer chassisPIDaccelerometer; 
	public static AnalogPotentiometer shooterArmPIDshooterArmPot;
	 
    public static CANTalon intakeintakeMotorA;
    public static CANTalon chassisPIDchassisLeft1;
    public static CANTalon chassisPIDchassisLeft2;
    public static CANTalon chassisPIDchassisLeft3;
    public static CANTalon chassisPIDchassisRight1;
    public static CANTalon chassisPIDchassisRight2;
    public static CANTalon chassisPIDchassisRight3;
    public static CANTalon intakeArmPIDMotorA;
    public static CANTalon intakeintakeMotorB;
    public static CANTalon intakeArmPIDMotorB;
    public static CANTalon shooterRetractMotorA;

    public static DigitalInput intakeBallSensor;

    
    public static DoubleSolenoid powerTakeOffptoSolenoid;
    
    public static NetworkTable gripTables;
    public static NetworkTable autonTables;
    
    
    public static PowerDistributionPanel chassisPIDpowerDistributionPanel;
    
    public static RobotDrive chassisDrive;
    
    
    public static Solenoid ShooterPneumaticPin;
    public static Solenoid linearAccElevatorSolenoid;
    public static Solenoid chassisShiftershiftSolenoid;
    public static Solenoid ledGRIPCamera;
    public static Solenoid leftArmLED;
    public static Solenoid rightArmLED;
    public static Solenoid grapplingHookRelease;
    
    public static Relay targetLightLight;
    
    public static Ultrasonic chassisPIDultrasonicSensor;
  
    
    ////  Public variables
    public static boolean leftBallSensorState;
    public static boolean rightBallSensorState;
    public static boolean shooterRetractPrimed;
    public static boolean shooterRetractRetracted;
    public static boolean shooterArmOnTarget = false;
    public static boolean visionOnTarget = false;
    public static boolean seeTarget = false;
    public static double gyroConversion = 4.5;
    public static boolean travelMode = false;
    public static boolean setPointSet = false;
    public static double centerpnt = 172;
    public static boolean shooterArmDisabled = false;
    
    
    
    //Start of init
    public static void init() {
    	
    	gripTables = NetworkTable.getTable("GRIP/myContoursReport");
    	autonTables = NetworkTable.getTable("Auton");
    	
    	chassisPIDaccelerometer = new AnalogAccelerometer(1);
        LiveWindow.addSensor("ChassisPID", "accelerometer ", chassisPIDaccelerometer);
        chassisPIDaccelerometer.setSensitivity(0.0);
        chassisPIDaccelerometer.setZero(2.5);
        
        shooterArmPIDshooterArmPot = new AnalogPotentiometer(3, 20.0, .068);
        LiveWindow.addSensor("shooterArm", "Potentiometer", shooterArmPIDshooterArmPot);
       
    	//CANTalon set control mode parameters
        //PercentVbus = 0, Position = 1, Speed = 2, Current = 3, Voltage = 4, Follower = 5, Disabled = 15 
        
        chassisPIDpowerDistributionPanel = new PowerDistributionPanel(0);
        LiveWindow.addSensor("ChassisPID", "powerDistributionPanel ", chassisPIDpowerDistributionPanel);
    	
    	chassisPIDchassisLeft1 = new CANTalon(0);
        LiveWindow.addActuator("ChassisPID", "chassisLeft1", chassisPIDchassisLeft1);
        chassisPIDchassisLeft1.changeControlMode(TalonControlMode.PercentVbus);
        chassisPIDchassisLeft1.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
        chassisPIDchassisLeft1.setEncPosition(0);
        
        
        
         
        chassisPIDchassisLeft2 = new CANTalon(1);
        LiveWindow.addActuator("ChassisPID", "chassisLeft2", chassisPIDchassisLeft2);
        chassisPIDchassisLeft2.changeControlMode(TalonControlMode.Follower);
        chassisPIDchassisLeft2.set(chassisPIDchassisLeft1.getDeviceID());
        
        chassisPIDchassisLeft3 = new CANTalon(2);
        LiveWindow.addActuator("ChassisPID", "chassisLeft3", chassisPIDchassisLeft3);
        chassisPIDchassisLeft3.changeControlMode(TalonControlMode.Follower);
        chassisPIDchassisLeft3.set(chassisPIDchassisLeft1.getDeviceID());
         
        chassisPIDchassisRight1 = new CANTalon(15);
        LiveWindow.addActuator("ChassisPID", "chassisRight1", chassisPIDchassisRight1);
        chassisPIDchassisRight1.changeControlMode(TalonControlMode.PercentVbus);
         
        chassisPIDchassisRight2 = new CANTalon(14);
        LiveWindow.addActuator("ChassisPID", "chassisRight2", chassisPIDchassisRight2);
        chassisPIDchassisRight2.changeControlMode(TalonControlMode.Follower);
        chassisPIDchassisRight2.set(chassisPIDchassisRight1.getDeviceID());
        
        chassisPIDchassisRight3 = new CANTalon(13);
        LiveWindow.addActuator("ChassisPID", "chassisRight3", chassisPIDchassisRight3);
        chassisPIDchassisRight3.changeControlMode(TalonControlMode.Follower);
        chassisPIDchassisRight3.set(chassisPIDchassisRight1.getDeviceID());
         
        intakeArmPIDMotorA = new CANTalon(3);
        LiveWindow.addActuator("ShooterArm", "shooterArmMotorA", intakeArmPIDMotorA);
        intakeArmPIDMotorA.setControlMode(0);  
        //shooterArmPIDMotorA.enableBrakeMode(true);
        
        intakeArmPIDMotorB = new CANTalon(12);
        LiveWindow.addActuator("ShooterArm", "shooterArmMotorB", intakeArmPIDMotorB);
        intakeArmPIDMotorB.setControlMode(5);
        intakeArmPIDMotorB.reverseOutput(true);
        intakeArmPIDMotorB.set(intakeArmPIDMotorA.getDeviceID());
        
        intakeintakeMotorA = new CANTalon(6);
        intakeintakeMotorA.setInverted(true);
        LiveWindow.addActuator("Intake", "intakeMotorA", intakeintakeMotorA);
        //intakeintakeMotorA.setControlMode(0);
        //intakeintakeMotorA.setVoltageRampRate(6);	// 6v/sec.  Max v is 12 so 2 sec to full speed.
        
        intakeintakeMotorB = new CANTalon(9);
        LiveWindow.addActuator("Intake", "intakeMotorB", intakeintakeMotorB);
        //intakeintakeMotorB.setControlMode(5);
        intakeintakeMotorB.reverseOutput(false);
        //intakeintakeMotorB.set(6);
       //intakeintakeMotorB.setVoltageRampRate(600);	// 6v/sec.  Max v is 12 so 2 sec to full speed.
        											// 12v in 20 millisec (20*50=600)	
       
        												//**************************retractor*****
        shooterRetractMotorA = new CANTalon(7);
        shooterRetractMotorA.changeControlMode(TalonControlMode.Position);
        shooterRetractMotorA.setPID(2, 0.0, 0.0);
        shooterRetractMotorA.setAllowableClosedLoopErr(30);
        shooterRetractMotorA.reverseOutput(false);
        shooterRetractMotorA.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
        //shooterRetractMotorA.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
        shooterRetractMotorA.configNominalOutputVoltage(+4f, -8f);
        shooterRetractMotorA.configPeakOutputVoltage(+12f, -12f);
        shooterRetractMotorA.setProfile(0);
        //shooterRetractMotorA.setP(10);
       /// shooterRetractMotorA.enableBrakeMode(true);
        //shooterRetractMotorA.enableReverseSoftLimit(true);
        //shooterRetractMotorA.setReverseSoftLimit(-0.3);

        intakeBallSensor = new DigitalInput(10);
        
        
        LiveWindow.addActuator("ShooterRetract", "shooterRetractMotorA", shooterRetractMotorA);
 
        
        //   Solenoid Module 0  Get in my belly!
        chassisShiftershiftSolenoid = new Solenoid(0, 0);
        linearAccElevatorSolenoid = new Solenoid(0, 1);
        powerTakeOffptoSolenoid = new DoubleSolenoid(0, 2, 3);
        ShooterPneumaticPin = new Solenoid(0, 4);
        grapplingHookRelease = new Solenoid(0, 5);
        ledGRIPCamera = new Solenoid(0, 6);
        leftArmLED = new Solenoid(0, 7);
        
        //   Solenoid Module 1  On the Arm
        rightArmLED = new Solenoid(1, 7);

        
        //  Target light relay
        targetLightLight = new Relay(0, Relay.Direction.kForward);
        
        //Digital Sensors
        

        
        chassisPIDultrasonicSensor = new Ultrasonic(11, 12);
        LiveWindow.addSensor("ChassisPID", "ultrasonicSensor", chassisPIDultrasonicSensor);
        
        chassisDrive = new RobotDrive(chassisPIDchassisLeft1, chassisPIDchassisRight1);
    	chassisDrive.setMaxOutput(1.0);
    	chassisDrive.setSensitivity(0.5);
    	//chassisDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
    	chassisDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);    	
    	//chassisDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);   
    	chassisDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);   
    	
        try {
            /* Communicate w/navX MXP via the MXP SPI Bus.                                     */
            /* Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or SerialPort.Port.kUSB     */
            /* See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for details. */
            gyro = new AHRS(SerialPort.Port.kMXP);
        } catch (RuntimeException ex ) {
            DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
        }
    }
}
