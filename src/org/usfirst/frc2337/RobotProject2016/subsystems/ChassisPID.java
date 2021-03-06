
package org.usfirst.frc2337.RobotProject2016.subsystems;

import org.usfirst.frc2337.RobotProject2016.RobotMap;
import org.usfirst.frc2337.RobotProject2016.commands.*;

import com.kauailabs.navx.frc.AHRS;


import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ChassisPID extends PIDSubsystem {

    private final AHRS gyro = RobotMap.gyro;
    private final PowerDistributionPanel powerDistributionPanel = RobotMap.chassisPIDpowerDistributionPanel;
    private final Ultrasonic ultrasonicSensor = RobotMap.chassisPIDultrasonicSensor;
    private final CANTalon chassisLeft = RobotMap.chassisPIDchassisLeft1;
    private final CANTalon chassisRight = RobotMap.chassisPIDchassisRight1;
    RobotDrive robotDrive = RobotMap.chassisDrive;  

    
    public ChassisPID() {
        super("ChassisPID", 0.03, 0.0, 0.0);
        setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(true);
        LiveWindow.addActuator("ChassisPID Gyro", "PID Controller", getPIDController());
        LiveWindow.addActuator("ChassisPID Gyro", "Gyro", gyro);

        chassisLeft.enableBrakeMode(false);
        chassisRight.enableBrakeMode(false);

        //verify this shows talon encoder and then delete....
        SmartDashboard.putNumber("chassis GetPosition", RobotMap.chassisPIDchassisLeft1.getPosition());
        
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new chassis_ArcadeDrive());

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
        RobotMap.chassisPIDchassisLeft2.enableBrakeMode(type);
        RobotMap.chassisPIDchassisLeft3.enableBrakeMode(type);
        RobotMap.chassisPIDchassisRight2.enableBrakeMode(type);
        RobotMap.chassisPIDchassisRight3.enableBrakeMode(type);
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
       //return rightEncoder.pidGet();
    	return gyro.getYaw();
        //return RobotMap.chassisPIDchassisLeft1.pidGet();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);

        //chassisLeft2.pidWrite(output);
        //double PIDyaw = this.readGyroYaw();
        //this.arcadeDrive(-output, PIDyaw);
        this.arcadeDrive(0, output);
    }

    public void resetDriveEncoder() {
    	RobotMap.chassisPIDchassisLeft1.setEncPosition(0);
    }
    public int readLeftEncoder() {
    	//return (leftEncoder.get());
    	return RobotMap.chassisPIDchassisLeft1.getEncPosition();  //** removed neg???
    	
    }
    public int readRightEncoder() {
    	//return (rightEncoder.get());
    	return RobotMap.chassisPIDchassisRight1.getEncPosition();
    }
    public boolean encoderOnTargetLeft(int target) {
    	if (target > 0) {
    		return (readLeftEncoder() > target);
    	} else {
    		return (readLeftEncoder() < target);
    	}
    }
    /*
    public boolean encoderOnTargetRight(int target) {
    	return (target > readRightEncoder());
    }
    */
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
