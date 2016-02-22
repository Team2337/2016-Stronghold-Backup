package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.Timer;

/**
 *  
 */
public class shooter_ShootCG extends CommandGroup {
	
    public  shooter_ShootCG() {
    	//requires(Robot.shooter);
    	addSequential(new intake_DoNothing());
    	addSequential(new intakeWrist_Extend());
    	addSequential(new auton_Wait(5));  				//.......adjust or remove???
    	addSequential(new shooter_Shoot());
    	addSequential(new shooterRetract_Prep());
    	addSequential(new auton_Wait(5));  				//.......adjust or remove???
    	addSequential(new intakeWrist_Retract());
    	addSequential(new shooterRetract_Prime());

     	
  	
     	

    }
}
