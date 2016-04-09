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

    	addParallel(new shooterRetract_Prep());
    	addSequential(new linAccElevator_Extend());  
    	addSequential(new auton_Wait(0.5));   
    	addSequential(new shooter_Shoot());
    	addSequential(new auton_Wait(0.5));  	
    	addSequential(new shooterRetract_Prime());
    	addSequential(new shooter_UnShoot());
    	addSequential(new linAccElevator_Retract());


    }
}
