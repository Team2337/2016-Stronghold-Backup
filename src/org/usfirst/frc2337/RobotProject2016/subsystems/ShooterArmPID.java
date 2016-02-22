
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
    
   	//Specified angle value for Pot
    public double scale = 6.6;
    public double layupShot = 4.86;
    public double hookShot = 3.5;
    public double travel = 3.3;
    public double base = 2.4; 

    private final double setPointTolerance = 0.1;
    public final double autonArmSpeedUp = .4;
    public final double autonArmSpeedDown = -.4;
    public final double teleopArmSpeedUp = .4;
    public final double teleopArmSpeedDown = -.4;
    public final double armToplimit = 6.6;
    public final double armBottomlimit = 2.54;
    
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
    	
    		return shooterArmPot.get();
    	
    }
    

    protected void usePIDOutput(double output) {
        shooterArmMotor.pidWrite(-output);
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
