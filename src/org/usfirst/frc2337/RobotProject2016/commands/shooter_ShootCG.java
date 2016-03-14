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
    	
    	addSequential(new shooterRetract_Prep());
    	//addSequential(new intake_DoNothing());
    	addSequential(new intakeWrist_Extend());
    	addSequential(new auton_Wait(0.2));
    	addParallel(new intake_Exhale());
    	//addSequential(new shooterRetractor_turnOffBrakeMode());
    	addSequential(new auton_Wait(0.5));  				//.......adjust or remove???
    		
    	addSequential(new shooter_Shoot());

    	addSequential(new auton_Wait(0.8));  				//.......adjust or remove???
    	
    	//[]\
    	addSequential(new shooterRetractor_turnOnBrakeMode());
    	
    	addSequential(new intake_DoNothing());
    	addSequential(new intakeWrist_Retract());
    	addSequential(new shooter_UnShoot());
    	addSequential(new shooterRetract_Prime());
    	addSequential(new auton_Wait(0.5)); 
    	addSequential(new shooterRetract_Prep());

     	
  	
     	

    }
}
