package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *  
 */
public class auton_MainCG extends CommandGroup {
	
	boolean backwards = false;
	int distance;
	int angle;
	
    @SuppressWarnings("deprecation")
	public  auton_MainCG() {
    	
    	
    	//Input from file or smartdashboard or web interface??????? (Web, Web, Web)
    	int intake = 3;
    	int startingPoint = 3;
    	int defense = 9;
    	int shootHigh = 4;
    	/*REMOVE THE COMMENT >*/
    	

    	
    	intake = (int) RobotMap.autonTables.getNumber("intakeBall");
    	startingPoint = (int) RobotMap.autonTables.getNumber("startPos");
    	defense = (int) RobotMap.autonTables.getNumber("defenseType");
    	shootHigh = (int) RobotMap.autonTables.getNumber("goalPos");
    	/*< REMOVE THE COMMENT*/
    	
    	addParallel(new intake_ActivateMotors());  		
    	
    	if (intake == 1) { 									
    		addSequential(new auton_IntakeCG());  						
    		
    	} else if (intake == 2) {//if (intake == 0) {//Nope, lets not intake for midline...
    		if ((defense == 0) || (defense == 1) || (defense == 3) || (defense == 4)) {				//lower arm to go under lo-bar, add for porticulis???
    			addSequential(new auton_ReverseReach());
    			backwards = true;
    		} else if (defense == 2) {
    			
    		} else {	
    			addParallel(new shooterArm_armSetPointTravel());
    			addSequential(new Auton_GyroAndEncoderDrive(0.4, 16029, 4.0));  //22029		//TODO   NEED TO SET DISTANCE 
    		}
    	} else {
    		addSequential(new shooterArm_armSetPointTravel());
    		addSequential(new auton_Wait(15));
    	}
    	
    	/*
    	 * DEFENSE COMMANDS/COMMAND GROUPS TO CROSS
    	 */
    	if (defense == 0) {// LOW BAR
	        	addSequential(new shooterArm_armSetPointBase());
	        	addParallel(new shooterArm_armSetPointAutonBase());
	    		addSequential(new Auton_GyroAndEncoderDrive(0.4, -60000, 8.0));
	    		//addSequential(new Auton_GyroAndEncoderDrive(0.4, -11000, 8.0));
	    		addSequential(new intake_DoNothing());  
    	} else if (defense == 1){ //PORTCULLIS
	        	addSequential(new shooterArm_armSetPointBase());   //  Drive Arm to Base
	        	addParallel(new shooterArm_armSetPointAutonBase());   //  Keep Arm down through the motion  
	    		addSequential(new Auton_GyroAndEncoderDrive(0.4, -33000, 8.0));  //22029		//Drive Forward
	    		addSequential(new intake_DoNothing());  
    	} else if (defense == 2){ //CHEVAL DE FRISE
	        	addParallel(new intake_ActivateMotors());  			//activate intake and run parallel as it does not finish...
	        	addSequential(new shooterArm_armSetPointAutonChevy());
	    		addSequential(new Auton_GyroAndEncoderDriveTillRoll(0.3, 4.0, -5));  //22029		//TODO   NEED TO SET DISTANCE 
	    		addSequential(new shooterArm_armSetPointBase());
	    		addParallel(new shooterArm_armSetPointAutonBase());
	    		addSequential(new Auton_GyroAndEncoderDriveTillRoll(0.3, 2.0, -30));
	    		addSequential(new shooterArm_armSetPointAutonTravel());
	    		addSequential(new Auton_GyroAndEncoderDrive(0.3, 22000, 4.0));
	    		addSequential(new intake_DoNothing());  	
    	} else if (defense == 3){ //RAMPARTS
    		addSequential(new auton_Wait(1.0));
    		addSequential(new Auton_GyroAndEncoderDrive(8.0, -33000, 5.0));			//TODO   NEED TO SET DISTANCE

    	} else if (defense == 4){ //MOAT
    		addSequential(new auton_Wait(1.0));
    		addSequential(new Auton_GyroAndEncoderDrive(8.0, -33000, 4.5));			//TODO   NEED TO SET DISTANCE

    	} else if (defense == 5){ //DRAWBRIDGE
    		addSequential(new auton_Wait(15)); 

    	} else if (defense == 6){ //SALLY PORT
    		addSequential(new auton_Wait(15)); 

    	} else if (defense == 7){ //ROCK WALL
    		addSequential(new Auton_GyroAndEncoderDrive(0.7, 33000, 6.0));				//TODO   NEED TO SET DISTANCE

    	} else if (defense == 8) { //ROUGH TERRIAN
    		addSequential(new Auton_GyroAndEncoderDrive(0.7, 33000, 6.0));				//TODO   NEED TO SET DISTANCE

    	} else { //IF OVER 9 or so, lets just wait and not go over;
    			addSequential(new auton_Wait(15)); 
    	}
    
    	
    	/*
    	 * SHOOT HIGH? Well lets run this while something else runs!
    	 */
    	
    	if (shootHigh == 1) { //IF WE WANT TO SHOOT HIGH RUN THIS IN PARALLEL
    		addParallel(new shooterArm_armSetPointLongShot());  	//aim for high goal..for low goal, staying in travel mode for now.
    		//System.out.println("SHOOT HIGH? YES RUN PARALLEL");
    	} else if (shootHigh == 3) {
    		startingPoint = 0;
    	}
    	
    	
    	/* 
    	 * GO TO GOAL (BASED ON DEFENSE POINT 
    	 * ------------------------------------------
    	 */
    	
    	if (startingPoint == 1 && (shootHigh == 1 || shootHigh == 2)) { //GO TO LEFT GOAL
	    	//addSequential(new auton_MoveAfterDefenseAndTurnToGoal(0.4, 72000, 4.0, 45)); // move forward
    		//System.out.println("IM AT 1, I WANT TO GO LEFT");
    	} else if (startingPoint == 2 && (shootHigh == 1 || shootHigh == 2)) { //STARING POINT IS NOW 2, GO TO LEFT GOAL
    		distance = 21500;
    		if (backwards) {
    			distance = -distance;
    			angle = 45 - 180;
    		}
    		addSequential(new auton_MoveAfterDefenseAndTurnToGoal(0.4, distance, 4.0, angle)); 
    		
    		//System.out.println("IM AT 2, I WANT TO GO LEFT");
    	} else if (startingPoint == 3 && (shootHigh == 1 || shootHigh == 2)) { //STARING POINT IS NOW 3, GO TO MIDDLE GOAL
    		distance = 0;
    		if (backwards) {
    			distance = -distance;
    			angle = 30 - 180;
    		}
    		addSequential(new auton_MoveAfterDefenseAndTurnToGoal(0.4, distance, 4.0, angle)); 
    		//System.out.println("IM AT 3, I WANT TO GO MIDDLE");
    	} else if (startingPoint == 4 && (shootHigh == 1 || shootHigh == 2)) { //STARING POINT IS NOW 4, GO TO MIDDLE GOAL
    		distance = 0;
    		if (backwards) {
    			distance = -distance;
    			angle = -10 + 180;
    		}
    		addSequential(new auton_MoveAfterDefenseAndTurnToGoal(0.4, distance, 4.0, angle)); 
    		//System.out.println("IM AT 4, I WANT TO GO MIDDLE");
    	} else if (startingPoint == 5 && (shootHigh == 1 || shootHigh == 2)) {  //STARING POINT IS NOW 5, GO TO RIGHT GOAL
    		distance = 10500;
    		if (backwards) {
    			distance = -distance;
    			angle = -35 + 180;
    		}
    		addSequential(new auton_MoveAfterDefenseAndTurnToGoal(0.4, distance, 4.0, angle)); 
    		//System.out.println("IM AT 5, I WANT TO GO RIGHT");
    	} else if (startingPoint == 6){ //NOPE WE ARE NOT GOING TO THE GOAL
    		addSequential(new auton_Wait(15));
    	}
    	//ELSE GOWN DOWN

    	/*
    	 * SHOOT HIGH, LOW OR SPIT BALL?
    	 */
    	if (shootHigh == 1) { //SHOOT HIGH!!
    		addSequential(new chassis_TargetWithGyroPID());
    		addSequential(new shooter_ShootCG());
    		//System.out.println("LETS SHOOT HIGH");
    	} else if (shootHigh == 2) {//SHOOT LOW!!
    		if (startingPoint == 1) {
    			addSequential(new Auton_GyroAndEncoderDrive(0.3, 22000, 1));
    		} else if (startingPoint == 2) {
    			addSequential(new Auton_GyroAndEncoderDrive(0.3, 22000, 1));
    		} else if (startingPoint == 5) {
    			addSequential(new Auton_GyroAndEncoderDrive(0.3, 22000, 1));
    		}
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
