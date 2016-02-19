
package org.usfirst.frc2337.RobotProject2016.subsystems;

import org.usfirst.frc2337.RobotProject2016.RobotMap;
import org.usfirst.frc2337.RobotProject2016.commands.*;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.AnalogAccelerometer;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class ChassisPID extends PIDSubsystem {

    //private final AnalogGyro smallGyro = RobotMap.chassisPIDgyro;   //Small not NavX Gyro
    private final AHRS gyro = RobotMap.gyro;
    private final PowerDistributionPanel powerDistributionPanel = RobotMap.chassisPIDpowerDistributionPanel;
    private final Encoder rightEncoder = RobotMap.chassisPIDRightEncoder;
    private final Encoder leftEncoder = RobotMap.chassisPIDLeftEncoder;
    private final Ultrasonic ultrasonicSensor = RobotMap.chassisPIDultrasonicSensor;
   // private final AnalogAccelerometer accelerometer = RobotMap.chassisPIDaccelerometer;
    private final CANTalon chassisLeft = RobotMap.chassisPIDchassisLeft1;
    private final CANTalon chassisRight = RobotMap.chassisPIDchassisRight1;
    RobotDrive robotDrive = RobotMap.chassisDrive;  

    
    public ChassisPID() {
        super("ChassisPID", 1.0, 0.0, 0.0);
        setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("ChassisPID", "PIDSubsystem Controller", getPIDController());

        chassisLeft.enableBrakeMode(false);
        chassisRight.enableBrakeMode(false);

        
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void initDefaultCommand() {
        this.resetGyro();
        setDefaultCommand(new chassis_NerdyDrive());

    }

    public void tankDrive(double leftValue, double rightValue) {
    	robotDrive.tankDrive(leftValue, rightValue, true);
    }
    public void arcadeDrive(double speedValue, double turnValue) {
    	robotDrive.arcadeDrive(speedValue, turnValue, true);
    }
    public void setBrakeMode(boolean type) {
        chassisLeft.enableBrakeMode(type);
        chassisRight.enableBrakeMode(type);
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return rightEncoder.pidGet();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);

        //chassisLeft2.pidWrite(output);
        double PIDyaw = this.readGyroYaw();
        this.arcadeDrive(-output, PIDyaw);
    }
    //Reset the encoders
    public void resetEncoders() {
    	leftEncoder.reset();
    	rightEncoder.reset();
    }
    public int readLeftEncoder() {
    	return (leftEncoder.get());
    	
    }
    public int readRightEncoder() {
    	return (rightEncoder.get());
    }
    public boolean encoderOnTargetLeft(int target) {
    	return (target > readLeftEncoder());
    }
    public boolean encoderOnTargetRight(int target) {
    	return (target > readRightEncoder());
    }
    
    public double readUltrasonic() {
    	return (ultrasonicSensor.getRangeInches());
    }
    public boolean UltrasonicOnTarget(double target) {
    	return (target > readUltrasonic());
    }
    
    //Reset Gyro
    public void resetGyro() {
    	gyro.reset();
    }
    public double readGyroYaw() {
    	return gyro.getYaw();
    }
    public boolean gyroOnTarget(double targetMin, double targetMax ) {
    	return ((targetMin < gyro.getYaw()) && (gyro.getYaw() < targetMax));
    }      
    public void stopMotors() {
    	RobotMap.chassisDrive.stopMotor();
	}
}
