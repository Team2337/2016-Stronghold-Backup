package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class auton_CrossWithTurn extends CommandGroup {

	/* Auton CrossWithTurn
	 *  SO WE WAIT FOR ROBOT TO MOVE OUT OF WAY, THEN MOVE TOWARDS SPOT,
	 *  TURN THE ROBOT (LEFT OR RIGHT), then auton_Cross over the defense that is. 
	 */
	public auton_CrossWithTurn(int turn)
	{
    	addSequential(new intakeArm_armSetPointLoad());
		addSequential(new auton_UltraSonicWait(15)); //INCHES
		addSequential(new Auton_GyroAndEncoderDrive(1, 1000, 4)); //MOVE 
		if (turn == 1) { //LEFT
			addSequential(new auton_TurnPID(-90));
		} else { //RIGHT
			addSequential(new auton_TurnPID(90));
		}
		addSequential(new Auton_GyroAndEncoderDrive(0.7, 32000, 8.0));  //22029		//TODO   NEED TO SET DISTANCE 
    	addSequential(new chassisShifter_HighToLow());
    	addSequential(new Auton_GyroAndEncoderDrive(0.4, 5000, 8.0));  //22029		//TODO   NEED TO SET DISTANCE 
    	addSequential(new chassisShifter_LowToHigh());
		
		
	}
}
