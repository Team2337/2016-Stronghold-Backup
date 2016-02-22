
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
	public static AnalogGyro chassisPIDgyro;
	
	public static AnalogAccelerometer chassisPIDaccelerometer; 
	public static AnalogPotentiometer shooterArmPIDshooterArmPot;
	 
    public static CANTalon intakeintakeMotorA;
    public static CANTalon chassisPIDchassisLeft1;
    public static CANTalon chassisPIDchassisLeft2;
    public static CANTalon chassisPIDchassisLeft3;
    public static CANTalon chassisPIDchassisRight1;
    public static CANTalon chassisPIDchassisRight2;
    public static CANTalon chassisPIDchassisRight3;
    public static CANTalon shooterArmPIDMotorA;
    public static CANTalon intakeintakeMotorB;
    public static CANTalon shooterArmPIDMotorB;
    public static CANTalon shooterRetractMotorA;
    public static CANTalon portWheelMotorA;
    public static CANTalon portWheelMotorB;
    
    public static DigitalInput intakeLeftBallSensor;
    public static DigitalInput intakeRightBallSensor;
    public static DigitalInput intakeGotBallSensor;
    
    public static DoubleSolenoid powerTakeOffptoSolenoid;
	
	public static Encoder chassisPIDLeftEncoder;
	public static Encoder chassisPIDRightEncoder;
	public static Encoder shooterPIDEncoder;
	public static Encoder shooterRetractPIDEncoder;
    
    public static NetworkTable gripTables;
    
    public static PowerDistributionPanel chassisPIDpowerDistributionPanel;
    
    public static RobotDrive chassisDrive;
    
    public static Solenoid scalerscalerAirActuator;
    public static Solenoid ShooterPneumaticPin;
    public static Solenoid intakeWristintakeWristSolenoid;
    public static Solenoid chassisShiftershiftSolenoid;
    public static Solenoid ledGRIPCamera;
    public static Solenoid targetLightLight;
    public static Solenoid gotBallLED;
    
    public static Solenoid keyPullOut;
    
    
    
    public static Ultrasonic intakeSensor;
    public static Ultrasonic chassisPIDultrasonicSensor;
  
    
    ////  Public variables
    public static boolean leftBallSensorState;
    public static boolean rightBallSensorState;
    public static boolean gotBallSensorState;
    public static boolean shooterRetractPrimed;
    public static boolean shooterRetractRetracted;
    public static boolean shooterArmOnTarget = false;
    public static boolean visionOnTarget = false;
    public static boolean okToShoot = false;
    public static boolean seeTarget = false;
    public static double gyroConversion = 4.5;
    
    
    //Start of init
    public static void init() {
    	
    	gripTables = NetworkTable.getTable("GRIP/myContoursReport");
    	
    	chassisPIDaccelerometer = new AnalogAccelerometer(1);
        LiveWindow.addSensor("ChassisPID", "accelerometer ", chassisPIDaccelerometer);
        chassisPIDaccelerometer.setSensitivity(0.0);
        chassisPIDaccelerometer.setZero(2.5);
        
        chassisPIDgyro = new AnalogGyro(0);
        LiveWindow.addSensor("ChassisPID", "gyro", chassisPIDgyro);
        chassisPIDgyro.setSensitivity(0.003);
        
        shooterArmPIDshooterArmPot = new AnalogPotentiometer(3, 20.0, .068);
        LiveWindow.addSensor("shooterArm", "Potentiometer", shooterArmPIDshooterArmPot);
       
    	//CANTalon set control mode parameters
        //PercentVbus = 0, Position = 1, Speed = 2, Current = 3, Voltage = 4, Follower = 5, Disabled = 15 
        
        chassisPIDpowerDistributionPanel = new PowerDistributionPanel(0);
        LiveWindow.addSensor("ChassisPID", "powerDistributionPanel ", chassisPIDpowerDistributionPanel);
    	
    	chassisPIDchassisLeft1 = new CANTalon(0);
        LiveWindow.addActuator("ChassisPID", "chassisLeft1", chassisPIDchassisLeft1);
        chassisPIDchassisLeft1.changeControlMode(TalonControlMode.PercentVbus);
         
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
         
        shooterArmPIDMotorA = new CANTalon(3);
        LiveWindow.addActuator("ShooterArm", "shooterArmMotorA", shooterArmPIDMotorA);
        shooterArmPIDMotorA.setControlMode(0);  
        shooterArmPIDMotorA.enableBrakeMode(true);
        
        shooterArmPIDMotorB = new CANTalon(12);
        LiveWindow.addActuator("ShooterArm", "shooterArmMotorB", shooterArmPIDMotorB);
        shooterArmPIDMotorB.setControlMode(5);
        shooterArmPIDMotorB.reverseOutput(true);
        shooterArmPIDMotorB.set(shooterArmPIDMotorA.getDeviceID());
        
        intakeintakeMotorA = new CANTalon(6);
        intakeintakeMotorA.setInverted(true);
        LiveWindow.addActuator("Intake", "intakeMotorA", intakeintakeMotorA);
        //intakeintakeMotorA.setControlMode(0);
        
        intakeintakeMotorB = new CANTalon(9);
        LiveWindow.addActuator("Intake", "intakeMotorB", intakeintakeMotorB);
        //intakeintakeMotorB.setControlMode(5);
        intakeintakeMotorB.reverseOutput(false);
        //intakeintakeMotorB.set(6);

        shooterRetractMotorA = new CANTalon(7);
        shooterRetractMotorA.changeControlMode(TalonControlMode.Position);
        shooterRetractMotorA.reverseOutput(false);
        shooterRetractMotorA.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
        shooterRetractMotorA.configNominalOutputVoltage(+0f, -0f);
        shooterRetractMotorA.configPeakOutputVoltage(+12f, -12f);
        shooterRetractMotorA.setProfile(0);
        shooterRetractMotorA.setP(.2);

        
        
        LiveWindow.addActuator("ShooterRetract", "shooterRetractMotorA", shooterRetractMotorA);
        
        portWheelMotorA= new CANTalon(8);
        LiveWindow.addActuator("PortWheels", "portWheelMotorA", portWheelMotorA);
        portWheelMotorA.setControlMode(0);
        
        portWheelMotorB= new CANTalon(16);
        LiveWindow.addActuator("PortWheels", "portWheelMotorB", portWheelMotorB);
        portWheelMotorB.setControlMode(5);
        portWheelMotorB.reverseOutput(true);
        portWheelMotorB.set(8);
 
        powerTakeOffptoSolenoid = new DoubleSolenoid(0, 2, 3);
        LiveWindow.addActuator("PowerTakeOff", "ptoSolenoid", powerTakeOffptoSolenoid);
        
        scalerscalerAirActuator = new Solenoid(0, 4);
        LiveWindow.addActuator("Scaler", "scalerAirActuator", scalerscalerAirActuator);
        
        intakeWristintakeWristSolenoid = new Solenoid(0, 1);
        LiveWindow.addActuator("IntakeWrist", "intakeWristSolenoid", intakeWristintakeWristSolenoid);
        
        chassisShiftershiftSolenoid = new Solenoid(0, 0);
        LiveWindow.addActuator("ChassisShifter", "shiftSolenoid", chassisShiftershiftSolenoid);
        
        ledGRIPCamera = new Solenoid(1, 0);
        LiveWindow.addActuator("Led", "GRIPLed", ledGRIPCamera);
        
        gotBallLED = new Solenoid(1, 1);
        
        targetLightLight = new Solenoid(1, 2);

        
        //Digital Sensors
        
        chassisPIDLeftEncoder = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("ChassisPID", "driveEncoder", chassisPIDLeftEncoder);
        //chassisPIDLeftEncoder.setDistancePerPulse(1.0);
        //chassisPIDLeftEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
        LiveWindow.addSensor("ChassisPIDLeftEnc", "Strafe Encoder", chassisPIDLeftEncoder);

   
        
        chassisPIDRightEncoder = new Encoder(2, 3, false, EncodingType.k4X);
        LiveWindow.addSensor("ChassisPID", "driveEncoder", chassisPIDRightEncoder);
        //chassisPIDRightEncoder.setDistancePerPulse(1.0);
        //chassisPIDRightEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
        LiveWindow.addSensor("ChassisPIDRightEnc", "Strafe Encoder", chassisPIDRightEncoder);
        
        shooterPIDEncoder = new Encoder(4, 5, false, EncodingType.k4X);
        LiveWindow.addActuator("ShooterArmPID", "shooterArmEncoder", shooterPIDEncoder);
        
        shooterRetractPIDEncoder = new Encoder(6, 7, false, EncodingType.k4X);
        LiveWindow.addActuator("ShooterRetract", "shooterRetractPIDEncoder", shooterRetractPIDEncoder);
        
        chassisPIDultrasonicSensor = new Ultrasonic(11, 12);
        LiveWindow.addSensor("ChassisPID", "ultrasonicSensor", chassisPIDultrasonicSensor);
        
        intakeLeftBallSensor = new DigitalInput(8);
        LiveWindow.addSensor("Intake", "ballSensor", intakeLeftBallSensor);
       
        intakeRightBallSensor = new DigitalInput(9);
        LiveWindow.addSensor("Intake", "ballSensor", intakeRightBallSensor);
        
        intakeGotBallSensor = new DigitalInput(10);
        LiveWindow.addSensor("Intake", "ballSensor", intakeGotBallSensor);
        
   
        
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
