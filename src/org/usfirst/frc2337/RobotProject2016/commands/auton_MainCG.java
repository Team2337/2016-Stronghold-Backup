package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.Timer;

/**
 *  
 */
public class auton_MainCG extends CommandGroup {
	
    public  auton_MainCG() {
    	
    	
    	//Input from file or smartdashboard or web interface??????? (Web, Web, Web)
    	int intake = 1;
    	int startingPoint = 1;
    	int defense = 1;
    	int shootHigh = 1;
    	/*REMOVE THE COMMENT >*/
    	

    	
    	intake = (int) RobotMap.autonTables.getNumber("intakeBall");
    	startingPoint = (int) RobotMap.autonTables.getNumber("startPos");
    	defense = (int) RobotMap.autonTables.getNumber("defenseType");
    	shootHigh = (int) RobotMap.autonTables.getNumber("goalPos");
    	/*< REMOVE THE COMMENT*/
    	
    	addParallel(new intake_ActivateMotors());  			//activate intake and run parallel as it does not finish...
    	
    	if (intake == 1) { //I'm INTAKING, so lets run...
    		addSequential(new auton_IntakeCG());  							//TODO   NEED tO TEST
    		
    	} else {//if (intake == 0) {//Nope, lets not intake for midline...
    		addSequential(new Auton_GyroAndEncoderDrive(0.5, 500, 3.0));  		//TODO   NEED TO SET DISTANCE 

    		//addSequential(new auton_Wait(1));   //just for testing
    	}
    	
    	/*
    	 * DEFENSE COMMANDS/COMMAND GROUPS TO CROSS
    	 */
    	if (defense == 0) {// LOW BAR
    		addSequential(new Auton_GyroAndEncoderDrive(0.5, 1200, 5.0));  //cross defense//TODO   NEED TO SET DISTANCE
    		//System.out.println("LOW BAR");
    	} else if (defense == 1){ //PORTCULLIS
    		addSequential(new auton_Wait(15));
    		//System.out.println("PORTICULLIS");
    	} else if (defense == 2){ //CHEVAL DE FRISE
    		//MAKE CHEVAL DE FRISE COMMAND GROUP
    		//System.out.println("CHEVAL DE FRISE");
    		addSequential(new auton_Wait(15));
    	} else if (defense == 3){ //RAMPARTS
    		addSequential(new Auton_GyroAndEncoderDrive(0.7, 1200, 5.0));			//TODO   NEED TO SET DISTANCE
    		//System.out.println("RAMPARTS");
    	} else if (defense == 4){ //MOAT
    		addSequential(new Auton_GyroAndEncoderDrive(0.7, 1600, 4.5));			//TODO   NEED TO SET DISTANCE
    		//System.out.println("MOAT");
    	} else if (defense == 5){ //DRAWBRIDGE
    		addSequential(new auton_Wait(15)); 
    		//System.out.println("DRAWBRIDGE");
    	} else if (defense == 6){ //SALLY PORT
    		addSequential(new auton_Wait(15)); 
    		//System.out.println("SALLY PORT");
    	} else if (defense == 7){ //ROCK WALL
    		addSequential(new Auton_GyroAndEncoderDrive(0.7, 1200, 4.0));				//TODO   NEED TO SET DISTANCE
    		//System.out.println("ROCK WALL");
    	} else if (defense == 8) { //ROUGH TERRIAN
    		addSequential(new Auton_GyroAndEncoderDrive(0.7, 1000, 4.0));				//TODO   NEED TO SET DISTANCE
    		//System.out.println("ROUGH TERRIAN");
    	} else { //IF OVER 9 or so, lets just wait and not go over;
    			addSequential(new auton_Wait(15)); 
    	}
    
    	
    	/*
    	 * SHOOT HIGH? Well lets run this while something else runs!
    	 */
    	
    	if (shootHigh == 1) { //IF WE WANT TO SHOOT HIGH RUN THIS IN PARALLEL
    		addParallel(new shooterArm_armSetPointShortShot());  	//aim for high goal..for low goal, staying in travel mode for now.
    		//System.out.println("SHOOT HIGH? YES RUN PARALLEL");
    	} else if (shootHigh == 3) {
    		startingPoint = 0;
    	}
    	
    	
    	/* 
    	 * GO TO GOAL (BASED ON DEFENSE POINT 
    	 * ------------------------------------------
    	 */
    	
    	if (startingPoint == 1) { //GO TO LEFT GOAL
	    	addSequential(new auton_MoveStart1ToGoal1()); // move forward
    		//System.out.println("IM AT 1, I WANT TO GO LEFT");
    	} else if (startingPoint == 2) { //STARING POINT IS NOW 2, GO TO LEFT GOAL
    		addSequential(new auton_MoveStart2ToGoal1()); 
    		//System.out.println("IM AT 2, I WANT TO GO LEFT");
    	} else if (startingPoint == 3) { //STARING POINT IS NOW 3, GO TO MIDDLE GOAL
    		addSequential(new auton_Wait(0)); 
    		//System.out.println("IM AT 3, I WANT TO GO MIDDLE");
    	} else if (startingPoint == 4) { //STARING POINT IS NOW 4, GO TO MIDDLE GOAL
    		addSequential(new auton_Wait(0)); 
    		//System.out.println("IM AT 4, I WANT TO GO MIDDLE");
    	} else if (startingPoint == 5) {  //STARING POINT IS NOW 5, GO TO RIGHT GOAL
    		addSequential(new auton_Wait(0)); 
    		//System.out.println("IM AT 5, I WANT TO GO RIGHT");
    	} else if (startingPoint == 6){ //NOPE WE ARE NOT GOING TO THE GOAL
    		addSequential(new auton_Wait(15));
    	}
    	//ELSE GOWN DOWN

    	/*
    	 * SHOOT HIGH, LOW OR SPIT BALL?
    	 */
    	if (shootHigh == 1) { //SHOOT HIGH!!
    		addSequential(new shooter_ShootCG());
    		//System.out.println("LETS SHOOT HIGH");
    	} else if (shootHigh == 2) {//SHOOT LOW!!
	     	addSequential(new auton_ShootLowCG());  
	     	//System.out.println("WE ARE SHOOTING LOW");
    	} else if (shootHigh == 3) {//SPIT BALL
	     	addSequential(new auton_ReleaseBall());  
	     	//System.out.println("WE ARE SPITTING BALL");
    	} else { //DON'T SHOOT
    		addSequential(new auton_Wait(15)); 
    	}

    }
}
