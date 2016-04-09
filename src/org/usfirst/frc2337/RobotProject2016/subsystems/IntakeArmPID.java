
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
public class IntakeArmPID extends PIDSubsystem {

    private final AnalogPotentiometer shooterArmPot = RobotMap.shooterArmPIDshooterArmPot;
    private final CANTalon shooterArmMotor = RobotMap.intakeArmPIDMotorA;
    
   	//Specified angle value for Pot
    public double scale = 5.47;
    public double travel = 2.7;  //3.5
    public double autontravel = 2.9;  
    public double base = 2.55; 
    public double chevy = 3.2;
    public double loadPosition = 2.7;
    public double intakeRollerOffPosition = 3.0;
    public double lowGoalPosition = 3.4;
    public double intakePosition = 3.8;
    public double groundPosition = 4.2;
    

    private final double setPointTolerance = 0.1;
    public final double autonArmSpeedUp = .4;
    public final double autonArmSpeedDown = -.4;
    public final double teleopArmSpeedUp = .5;
    public final double teleopArmSpeedDown = -.4;
    public final double armToplimit = 6.6;
    public final double armBottomlimit = 2.45;
    
    public boolean armPIDstatus = false;
    public boolean armjoystickstatus = true;
    
    boolean armPIDStatus = true;
    
    
    // Initialize your subsystem here
    public IntakeArmPID() {
       
        super("ShooterArmPID", 2.0, 0.0, 0.0);  //1.0
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
		setDefaultCommand(new intakeArm_JoystickControl());
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
