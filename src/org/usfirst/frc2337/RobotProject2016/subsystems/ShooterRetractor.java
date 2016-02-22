package org.usfirst.frc2337.RobotProject2016.subsystems;

import org.usfirst.frc2337.RobotProject2016.RobotMap;
import org.usfirst.frc2337.RobotProject2016.commands.shooterRetract_DoNothing;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShooterRetractor extends Subsystem{
	
	private final CANTalon retractorMotor = RobotMap.shooterRetractMotorA;
	
	public double primedRetractorPosition = 1;
	public double preppedRetractorPosition = 2.2;
	
	private final double retractSpeedDown = -.2;
	private final double retractSpeedUp = .2;
	
	private double threshold = 0.1;
	
	boolean retractPIDStatus = true;

	public ShooterRetractor() {
	
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new shooterRetract_DoNothing());
		
	}
	
	public void retractorPreppedPosition() {
		RobotMap.shooterRetractMotorA.set(preppedRetractorPosition);
	}
	
	public void retractorPrimedPosition() {
		RobotMap.shooterRetractMotorA.set(primedRetractorPosition);
	}
	
    /**
     * Sets retractor motor on outside of PID, to retract shooter, unwind rope
     *    
    */
    public void retracting() {
    	retractorMotor.set(retractSpeedUp);
    }
    /**
     * Sets retractor motor on outisde of PID, to unretract shooter, wind up rope
     * 
     */
    public void unretracting() {
    	retractorMotor.set(retractSpeedDown); 	
    }

    public void stopMotors() {
    	retractorMotor.set(0);
    }
    
	
	public double getRetractPosition() {
		return RobotMap.shooterRetractMotorA.get();
	}
	
	public boolean primedOnTarget() {
		return (RobotMap.shooterRetractMotorA.get() < (primedRetractorPosition + threshold) );
	}
	
	public boolean preppedOnTarget() {
		return (RobotMap.shooterRetractMotorA.get() > (preppedRetractorPosition - threshold) );
	}


}
