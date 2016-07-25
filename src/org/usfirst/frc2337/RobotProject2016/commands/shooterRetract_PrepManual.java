package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;

public class shooterRetract_PrepManual extends Command{

	//public boolean shooterRetractPrimed;
	
	public shooterRetract_PrepManual(){
		requires(Robot.shooterRetractor);
	}
	protected void initialize() {
		RobotMap.shooterRetractMotorA.enable();
		setTimeout(6);
		RobotMap.shooterRetractMotorA.changeControlMode(TalonControlMode.PercentVbus);
		}

	protected void execute() {
		Robot.shooterRetractor.retracting();
	}

	protected boolean isFinished() {
		return false;
}

	protected void end() {  
		RobotMap.shooterRetractMotorA.set(0);
		RobotMap.shooterRetractMotorA.changeControlMode(TalonControlMode.Position);
		RobotMap.shooterRetractMotorA.setEncPosition(1);
		RobotMap.shooterRetractMotorA.set(0);
	}

	protected void interrupted() {
		this.end();
	}

}
