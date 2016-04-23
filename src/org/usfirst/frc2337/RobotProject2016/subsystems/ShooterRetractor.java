package org.usfirst.frc2337.RobotProject2016.subsystems;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;
import org.usfirst.frc2337.RobotProject2016.commands.shooterRetract_DoNothing;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShooterRetractor extends Subsystem{
	
	private final CANTalon retractorMotor = RobotMap.shooterRetractMotorA;
	
	
	// 4096 tics/ rev for Relative.  1.3 rev Absolute = (4096 * 1.3) 5325 tic range
	public double primedRetractorPosition = 0.1; 		// 0.1 -0.9   range is roughly 1.3
	
	public double preppedRetractorPosition = -5.67;   	// 1.2  0.3  0.9   1.2 1.372 3.91 4.86
	public double midRetractorPosition = 0;   	// 1.2  0.3  0.9[]\
	
	
	private final double retractSpeedDown = -0.90;	//retracting manually.......PRMING RIGHT NOW!!!! 0.75 to test w/o latching
	private final double retractSpeedUp = 1.0;		//unretracting manually
	
	private double threshold = .05;						//0.1
	
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
	
	
	public void setRetractPosition(double position) {
		RobotMap.shooterRetractMotorA.set(position);
	}
	
	public boolean primedOnTarget() {
		return (RobotMap.shooterRetractMotorA.get() < (primedRetractorPosition + threshold) );
	}
	
	public boolean midOnTarget() {
		return (RobotMap.shooterRetractMotorA.get() < (midRetractorPosition + threshold) );
	}
	
	public boolean preppedOnTarget() {
		return (RobotMap.shooterRetractMotorA.get() > (preppedRetractorPosition - threshold) );
	}
	
	public boolean onLimitSwitch() {
		return ( RobotMap.shooterRetractMotorA.isRevLimitSwitchClosed() );
	}
	
	public void resetEncoder() {
		//RobotMap.shooterRetractPIDEncoder.reset();
		RobotMap.shooterRetractMotorA.setEncPosition(0);
	}


}
