package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.Timer;

/**
 *  
 */
public class auton_CommandGroupExample extends CommandGroup {
	
    public  auton_CommandGroupExample() {
    	
    	
    	//Input from file or smartdashboard or web interface???????    			//TODO  integrate autonselector/interface
    	int intake = 1;
    	int startingPoint = 1;
    	int defense = 1;
    	int goal = 1; ///??? in the future
    	int shootHigh = 1;
    	
    	addParallel(new intake_ActivateMotors());  			//activate intake and run parallel as it does not finish...
    	
    	/// if intake = 1 then run these,   put them in a CG....
    	addSequential(new shooterArm_armSetPointBase());  	//lower to pick up ball
    														//wait or sense ball???
    	addParallel(new shooterArm_armSetPointTravel());  	//move arm to travel
    	addSequential(new Auton_GyroAndEncoderDrive(0.4, -100, 1.0));  //back up 			//TODO set encoder distance
     	addSequential(new doNothing (true, 5.0));			//turn 180...sean's turn???		//TODO write turn command
     	addSequential(new Auton_GyroAndEncoderDrive(0.5, 300, 2.0));  //finish reach		//TODO set encoder distance
     	
     	//if intake = 0 then....
    	addSequential(new auton_SimpleReach());  			// reach,  
    	
    	//if defense = 1 "low bar" ( & 1 or more of other simple & crossable)
    	addSequential(new Auton_GyroAndEncoderDrive(0.5, 1200, 5.0));  //cross defense		//TODO set encoder distance
    	//else if defense =2......etc....
    	
    	//if shoothigh = 1... run this in parallel....
    	addParallel(new shooterArm_armSetPointShortShot());  	//aim for high goal..for low goal, staying in travel mode for now.
    	
    	
    	//if startingpoint=1, then go to goal 1
    	addSequential(new Auton_GyroAndEncoderDrive(0.5, 300, 2.0)); // move forward		//TODO set encoder distance
     	addSequential(new doNothing (true, 5.0));			//turn towards goal				//TODO write turn command
     	addSequential(new Auton_GyroAndEncoderFwd(0.5, 300, 2.0));//drive to goal with aim with vision?? 	//TODO set encoder distance
     	addSequential(new doNothing (true, 5.0));			// aim on goal with vision if not done during drive....//TODO write turn command
     	
     	//if shoothigh = 1 then 
     	addSequential(new shooter_ShootCG());
     	//if shoothigh = 0 then
     	addSequential(new shooterArm_armSetPointBase());  	//needed??? Are we on or off batten?????
     	addSequential(new intake_Exhale());  	
     	

    }
}
