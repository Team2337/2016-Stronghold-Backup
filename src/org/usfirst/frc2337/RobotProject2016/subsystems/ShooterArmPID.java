
package org.usfirst.frc2337.RobotProject2016.subsystems;

import org.usfirst.frc2337.RobotProject2016.RobotMap;
import org.usfirst.frc2337.RobotProject2016.commands.*;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CANTalon;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class ShooterArmPID extends PIDSubsystem {

	private final Encoder shooterEncoder = RobotMap.shooterPIDEncoder;
    private final AnalogPotentiometer shooterArmPot = RobotMap.shooterArmPIDshooterArmPot;
    private final CANTalon shooterArmMotor = RobotMap.shooterArmPIDMotorA;
    
    //  Encoder = 1, POT = 2;
    private double encoderPotChooser = 1;
    public double base, travel, layupShot, hookShot, scale;

    private final double setPointTolerance = 0.05;
    public final double autonArmSpeedUp = .2;
    public final double autonArmSpeedDown = -.2;
    public final double teleopArmSpeedUp = .2;
    public final double teleopArmSpeedDown = -.2;
    public final double armToplimit = 4;
    public final double armBottomlimit = 0;
    
    public boolean armPIDstatus = false;
    public boolean armjoystickstatus = true;
    
    boolean armPIDStatus = true;
    
    
    // Initialize your subsystem here
    public ShooterArmPID() {
       
        super("ShooterArmPID", 1.0, 0.0, 0.0);
        setAbsoluteTolerance(setPointTolerance);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("ShooterArmPID", "PIDSubsystem Controller", getPIDController());

        getPIDController().setOutputRange(autonArmSpeedDown, autonArmSpeedUp);
        getPIDController().setInputRange(armBottomlimit, armToplimit);

        if(encoderPotChooser == 1){
        	//Specified angle value for Pot
        	scale = 5;
        	layupShot = 4;
        	hookShot = 3;
        	travel = 2;
        	base = 1;
        }else {
        	//Specified angle value for encoder
        	scale = 120;
        	layupShot = 100;
        	hookShot = 80;
        	travel = 50;
        	base = 10;
        }
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }

    public void initDefaultCommand() {
        setDefaultCommand(new shooterArm_JoystickControl());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	if(encoderPotChooser == 1) {
    		return shooterEncoder.get();
    	} else {
    		return shooterArmPot.get();
    	}
    }
    

    protected void usePIDOutput(double output) {
        shooterArmMotor.pidWrite(output);
    }
   /**
    * Set the position of the shooterarm using the analog pot
    * @param setpoint
    */
    public void armSetpoint(int setpoint) {
    	setSetpoint(setpoint);
    }
    /**
     * Sets arm motor to raise the arm using armSpeedUp variable declared towards the top of the ShooterArm
     * Subsystem
     *    
    */
    public void armUp() {
    	shooterArmMotor.set(teleopArmSpeedUp);
    }
    /**
     * Sets arm motor to lower the arm using armSpeedDown variable declared towards the top of the ShooterArm
     * Subsystem
     * 
     */
    public void armDown() {
    	shooterArmMotor.set(teleopArmSpeedDown); 	
    }

    public void stopMotors() {
    	shooterArmMotor.set(0);
    }
    
    public boolean getPIDStatus() {
    	return this.armPIDStatus;
    }
    
    public void stopPID() {
    	this.armPIDStatus = false;
    	this.disable();
    }
    
    public void startPID() {
    	this.armPIDStatus = true;
    	this.enable();
    }
    
    
}
