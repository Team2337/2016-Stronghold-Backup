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

    	//set setpoint to current position and turn PID on
    	addSequential(new shooterRetractor_setPointToCurrentPosition());

    	//addSequential(new linAccElevator_Extend());  
    	//addSequential(new auton_Wait(2.5));   
    	addSequential(new shooter_Shoot());
    	addSequential(new auton_Wait(0.5));  	
    	addSequential(new shooterRetract_Prime());
    	//addSequential(new shooter_UnShoot());
    	//turn PID off    	
    	addSequential(new shooterRetract_Prep());
    	addSequential(new shooterRetractor_disablePID());
    	//addSequential(new linAccElevator_Retract());   //maybe move up to after shoot+shoot and run parallel after shorter wait


    }
}
