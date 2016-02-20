package org.usfirst.frc2337.RobotProject2016.subsystems;

import org.usfirst.frc2337.RobotProject2016.RobotMap;
import org.usfirst.frc2337.RobotProject2016.commands.shooterRetract_DoNothing;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


public class ShooterRetract extends PIDSubsystem {
	
	private final CANTalon retractMotorA = RobotMap.shooterRetractMotorA;
	private final Encoder retractEncoder = RobotMap.shooterRetractPIDEncoder;
	
	private final double setPointTolerance = 0.1;
	
	private final double retractSpeedDown = -.2;
	private final double retractSpeedUp = .2;
	private final double retractForwardLimit = 1.0;
	private final double retractBackwardLimit = 0.5;
	
	public double primedRetractorPosition = 2;
	public double preppedRetractorPosition = 10;
	public double retractorDeadBand = 0.05; //used as a percentage
	
	boolean retractPIDStatus = true;


	public ShooterRetract() {
        super("ShooterRetract", 1.0, 0.0, 0.0);
        setAbsoluteTolerance(setPointTolerance);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("ShooterRetract", "PIDSubsystem Controller", getPIDController());

        getPIDController().setOutputRange(retractSpeedDown, retractSpeedUp);
        getPIDController().setInputRange(retractBackwardLimit, retractForwardLimit);

	}

	protected void initDefaultCommand() {
		setDefaultCommand(new shooterRetract_DoNothing());
	}

	protected double returnPIDInput() {
		return retractEncoder.get();
	}

	protected void usePIDOutput(double output) {
		retractMotorA.pidWrite(output);
	}
	
	public void setRetractPosition(double setpoint) {
		this.setSetpoint(setpoint);
	}
	
	public double getRetractPosition() {
		return this.getPosition();
	}
	
	public double readRetractEncoder() {
		return this.retractEncoder.get();
	}
	
	public void retractorPreppedPosition() {
		this.setSetpoint(preppedRetractorPosition);
	}
	
	public void retractorPrimedPosition() {
		this.setSetpoint(primedRetractorPosition);
	}
	
    /**
     * Sets retractor motor on outside of PID, to retract shooter, unwind rope
     *    
    */
    public void retracting() {
    	retractMotorA.set(retractSpeedUp);
    }
    /**
     * Sets retractor motor on outisde of PID, to unretract shooter, wind up rope
     * 
     */
    public void unretracting() {
    	retractMotorA.set(retractSpeedDown); 	
    }

    public void stopMotors() {
    	retractMotorA.set(0);
    }
    
    public boolean getPIDStatus() {
    	return this.retractPIDStatus;
    }
    
    public void stopPID() {
    	this.retractPIDStatus = false;
    	this.disable();
    }
    
    public void startPID() {
    	this.retractPIDStatus = true;
    	this.enable();
    }
    


}
