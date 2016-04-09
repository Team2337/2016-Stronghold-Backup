package org.usfirst.frc2337.RobotProject2016.commands;


import java.util.*;

import edu.wpi.first.wpilibj.command.Command;



public class datePrint extends Command {

	Date date = new Date();

	
	@Override
	protected void initialize() {
		System.out.println("**************************************************************");
	System.out.println(System.currentTimeMillis( ));
	System.out.println("**************************************************************");
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
