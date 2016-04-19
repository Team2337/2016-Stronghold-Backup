package org.usfirst.frc2337.RobotProject2016.subsystems;

import org.usfirst.frc2337.RobotProject2016.RobotMap;
import org.usfirst.frc2337.RobotProject2016.commands.*;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

	private final DoubleSolenoid shooterSolenoid = RobotMap.ShooterPneumaticPin;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	protected void initDefaultCommand() {
		// Set the default command for a subsystem here.
        //setDefaultCommand(new shooter_UnShoot());
		setDefaultCommand(new shooter_DoNothing());
	}
	/**
     * Retracks pin for shooter to shoot.
     */
	public void shooterShoot(){
		shooterSolenoid.set(DoubleSolenoid.Value.kReverse);  //switched during unbag
	}
	public void shooterUnShoot(){
		shooterSolenoid.set(DoubleSolenoid.Value.kForward);
	}
	public Value getShooterValue(){
		return shooterSolenoid.get();
	}
}
