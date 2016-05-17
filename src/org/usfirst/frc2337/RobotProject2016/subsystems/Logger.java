package org.usfirst.frc2337.RobotProject2016.subsystems;

import org.usfirst.frc2337.RobotProject2016.RobotMap;
import org.usfirst.frc2337.RobotProject2016.commands.*;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger extends Subsystem {
	
	public static File f;
	public static StringBuilder builder = new StringBuilder();
	public static FileWriter fw_file;
	public static BufferedWriter bw_file;
	
	protected void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
		
		/*
		 * InitSB();		//robotInit?
		 * IOInfoSB();  	//robotInit?
		 * stateSB();   	//robotPeriodic?  default command?, maybe add counter/delay but would miss events
		 * finalStateSB();	// in disable???
		 * or put all in default command and use a switch to end/write file
		 * flushSB(); 		//in robotDisabled
		*/
		
	}
	
	public static void initSB() {

    	try {
    		//add string variable to read current time and use that 
    		f = new File("/home/lvuser/WildLog.txt");	//media/sda1 for usb
    		if(!f.exists()){
    			f.createNewFile();
    		}
			fw_file = new FileWriter(f);
		} catch (IOException e) {
			System.err.println("Caught IOException (init fw): " + e.getMessage());
		}
    	bw_file = new BufferedWriter(fw_file);
    	//below is for testing purposes and can be deleted later...
		try  {
			bw_file.write(builder.toString());
			System.out.println("Successfully Copied INIT String to File...");
			System.out.println("builder string: \n" + builder);
		}catch (IOException e) {
		    System.err.println("Caught IOException (init bw): " + e.getMessage());
		}
	}
public static void IOInfoSB() {
		
		//'name' to match name in 'state' section.
		// direction' = Input/Output.  
		// type & port for information only.
	
		// Add a line for every item to be logged. 
		
		builder.append("{\"ioinfo\":[");
		
		addIOInfo("Dr-Green_A", "button", "Input", "1");
		addIOInfo("Dr-Reb_B", "button", "Input", "2");
		addIOInfo("Dr-Blue_X", "button", "Input", "3");
		addIOInfo("Dr-Yellow_Y", "button", "Input", "4");
		addIOInfo("Dr-Lt_Bumper", "button", "Input", "5");
		addIOInfo("Dr-Rt_Bumper", "button", "Input", "6");
		addIOInfo("Dr-Back", "button", "Input", "7");
		addIOInfo("Dr-Start", "button", "Input", "8");
		addIOInfo("Dr-Lt_Stick", "button", "Input", "9");
		addIOInfo("Dr-Rt_Stick", "button", "Input", "10");
		addIOInfo("Dr-Lt-X-axis", "joystick", "Input", "0");
		addIOInfo("Dr-Lt-Y-axis", "joystick", "Input", "1");
		addIOInfo("Dr-Lt-Trigger", "joystick", "Input", "2");
		addIOInfo("Dr-Rt-Trigger", "joystick", "Input", "3");
		addIOInfo("Dr-Rt-X-axis", "joystick", "Input", "4");
		addIOInfo("Dr-Rt-Y-axis", "joystick", "Input", "5");
		
		addIOInfo("Op-Green_A", "button", "Input", "1");
		addIOInfo("Op-Reb_B", "button", "Input", "2");
		addIOInfo("Op-Blue_X", "button", "Input", "3");
		addIOInfo("Op-Yellow_Y", "button", "Input", "4");
		addIOInfo("Op-Lt_Bumper", "button", "Input", "5");
		addIOInfo("Op-Rt_Bumper", "button", "Input", "6");
		addIOInfo("Op-Back", "button", "Input", "7");
		addIOInfo("Op-Start", "button", "Input", "8");
		addIOInfo("Op-Lt_Stick", "button", "Input", "9");
		addIOInfo("Op-Rt_Stick", "button", "Input", "10");
		addIOInfo("Op-Lt-X-axis", "joystick", "Input", "0");
		addIOInfo("Op-Lt-Y-axis", "joystick", "Input", "1");
		addIOInfo("Op-Lt-Trigger", "joystick", "Input", "2");
		addIOInfo("Op-Rt-Trigger", "joystick", "Input", "3");
		addIOInfo("Op-Rt-X-axis", "joystick", "Input", "4");
		addIOInfo("Op-Rt-Y-axis", "joystick", "Input", "5");
		
		addIOInfo("DS-White_Button", "button", "Input", "1");
		addIOInfo("DS-Blue_Button", "button", "Input", "3");
		addIOInfo("DS-Black_Button", "button", "Input", "4");
		addIOInfo("DS-Yellow_Button", "button", "Input", "5");
		addIOInfo("DS-White_Switch", "switch", "Input", "6");
		addIOInfo("DS-Blue_Switchr", "switch", "Input", "8");
		addIOInfo("DS-Black_Switch", "switch", "Input", "9");
		addIOInfo("DS-Yellow_Switch", "switch", "Input", "10");
		
		addIOInfo("gyro-Fused-Heading", "gyro", "Input", "");
		addIOInfo("gyro-Yaw", "gyro", "Input", "");
		addIOInfo("gyro-Angle", "gyro", "Input", "");
		addIOInfo("gyro-Pitch", "gyro", "Input", "");
		addIOInfo("gyro-Dipl-X", "gyro", "Input", "");
		addIOInfo("accelerometer-chassis", "accel", "Input", "");
		addIOInfo("stringpot-intake", "pot", "Input", "");
		addIOInfo("ball sensor-intake", "sensor", "Input", "");
		addIOInfo("ultrasonic sensor-inches","sensor 12 13", "Input", "");

		addIOInfo("retractor-onPin","sensor", "Input", "");
		addIOInfo("retractor-Primed","sensor", "Input", "");
		addIOInfo("retractor-Prepped tbd","sensor", "Input", "");
		
		addIOInfo("Left1-voltage","", "Input", "0");
		addIOInfo("Left1-current","", "Input", ""); 
		addIOInfo("Right1-voltage","", "Input", "15");
		addIOInfo("Right1-current","", "Input", "");
		
		addIOInfo("intakeArm-position","", "Input", "3");
		addIOInfo("intakeArm-setpoint","", "Input", "");
		addIOInfo("intakeArm-error","", "Input", "");
		addIOInfo("intakeArm-current","", "Input", "");
		addIOInfo("intakeArm-voltage","", "Input", "");
		
		addIOInfo("intakeMotor-get","", "Input", "6");
		addIOInfo("intakeMotor-current","", "Input", "");
		addIOInfo("intakeMotor-voltage","", "Input", "");
		
		addIOInfo("retractor-get","", "Input", "7");
		addIOInfo("retractor-setpoint","", "Input", "");
		addIOInfo("retractor-error","", "Input", "");
		addIOInfo("retractor-current","", "Input", "");;
		addIOInfo("retractor-voltage","","Input", "");
		addIOInfo("retractor-position","", "Input", "");
		
		addIOInfo("high-Gear","", "Input", "");				//  0,0
		//addIOInfo("PTO","", "Input", "");					// (0, 2, 3);
		//addIOInfo("shooterArm-solenoid","", "Input", "");	// (1, 1, 6);
		//addIOInfo("shooter-Pin","", "Input", ""); 		// (1, 2, 5);
		addIOInfo("grapplingHook-Release","", "Input", ""); // (1, 7, 0);
		///????
	    
		addIOInfo("leftArmLED","", "Input", "");			// (0, 7);
		addIOInfo("gripLED","", "Input", "");				// (1, 3);
		addIOInfo("ballSensorLED","", "Input", "");			//)(1,4);
		addIOInfo("rightArmLED","", "Input", "");			// (0, 1);
		//addIOInfo("retractor-position","", "Input", "");	// (0, Relay.Direction.kForward); "value"?
		
		addIOInfo("PDP 1","","Input", "");
		addIOInfo("PDP 2","","Input", "");
		addIOInfo("PDP 3","","Input", "");
		addIOInfo("PDP 4","","Input", "");
		addIOInfo("PDP 5","","Input", "");
		addIOInfo("PDP 5","","Input", "");
		addIOInfo("PDP 7","","Input", "");
		addIOInfo("PDP 8","","Input", "");
		addIOInfo("PDP 9","","Input", "");
		addIOInfo("PDP 10","","Input", "");
		addIOInfo("PDP 11","","Input", "");
		addIOInfo("PDP 12","","Input", "");
		addIOInfo("PDP 13","","Input", "");
		addIOInfo("PDP 14","","Input", "");
		addIOInfo("PDP 15","","Input", "");
		addIOInfo("PDP 16","","Input", "");
		
		//These three lines go last to close out the entry.
		
		builder.setLength(Math.max(builder.length() - 1,0));  	//remove comma from last entry.
		builder.append("\n\t]");								//close out ioinfo entry.
		builder.append("\n\"state\":[");						//start state entries.
	}
	
public static void stateSB() { 
	
	//'name' to match name in 'ioinfo' section.
	// parent for information only.
	// use methods to read values within corresponding addStateBoolean/Double/Int

	// Add a line for every item to be logged. 
	
	builder.append("\n\t{\"timestamp\":\"" + System.currentTimeMillis() + "\",\"values\":[");

	addStateBoolean("Dr-Green_A","DriverButton Green_A",Robot.oi.driverJoystick.getRawButton(1));  
	addStateBoolean("Dr-Reb_B","DriverButton Red B",Robot.oi.driverJoystick.getRawButton(2));
	addStateBoolean("Dr-Blue_X","DriverButton Blue X",Robot.oi.driverJoystick.getRawButton(3));
	addStateBoolean("Dr-Yellow_Y","DriverButton Yellow Y",Robot.oi.driverJoystick.getRawButton(4));
	addStateBoolean("Dr-Left_Bumper","DriverButton Left Bumper",Robot.oi.driverJoystick.getRawButton(5));
	addStateBoolean("Dr-Right_Bumper","DriverButton Right Bumper",Robot.oi.driverJoystick.getRawButton(6));
	addStateBoolean("Dr-Back","DriverButton-Back",Robot.oi.driverJoystick.getRawButton(7));
	addStateBoolean("Dr-Start","DriverButton-Start",Robot.oi.driverJoystick.getRawButton(8));
	addStateBoolean("Dr-Left_Stick","DriverButton-Left Stick",Robot.oi.driverJoystick.getRawButton(9));
	addStateBoolean("Dr-Right_Stick","DriverButton-Right Stick",Robot.oi.driverJoystick.getRawButton(10));
	addStateDouble("Dr-Lt-X-axis", "joystick", Robot.oi.driverJoystick.getRawAxis(0));
	addStateDouble("Dr-Lt-Y-axis", "joystick", Robot.oi.driverJoystick.getRawAxis(1));
	addStateDouble("Dr-Lt-Trigger", "joystick", Robot.oi.driverJoystick.getRawAxis(2));
	addStateDouble("Dr-Rt-Trigger", "joystick", Robot.oi.driverJoystick.getRawAxis(3));
	addStateDouble("Dr-Rt-X-axis", "joystick", Robot.oi.driverJoystick.getRawAxis(4));
	addStateDouble("Dr-Rt-Y-axis", "joystick", Robot.oi.driverJoystick.getRawAxis(5));
	
	addStateBoolean("Op-Green_A","DriverButton Green_A",Robot.oi.operatorJoystick.getRawButton(1));  
	addStateBoolean("Op-Reb_B","DriverButton Red B",Robot.oi.operatorJoystick.getRawButton(2));
	addStateBoolean("Op-Blue_X","DriverButton Blue X",Robot.oi.operatorJoystick.getRawButton(3));
	addStateBoolean("Op-Yellow_Y","DriverButton Yellow Y",Robot.oi.operatorJoystick.getRawButton(4));
	addStateBoolean("Op-Left_Bumper","DriverButton Left Bumper",Robot.oi.operatorJoystick.getRawButton(5));
	addStateBoolean("Op-Right_Bumper","DriverButton Right Bumper",Robot.oi.operatorJoystick.getRawButton(6));
	addStateBoolean("Op-Back","DriverButton-Back",Robot.oi.operatorJoystick.getRawButton(7));
	addStateBoolean("Op-Start","DriverButton-Start",Robot.oi.operatorJoystick.getRawButton(8));
	addStateBoolean("Op-Left_Stick","DriverButton-Left Stick",Robot.oi.operatorJoystick.getRawButton(9));
	addStateBoolean("Op-Right_Stick","DriverButton-Right Stick",Robot.oi.operatorJoystick.getRawButton(10));
	addStateDouble("Op-Lt-X-axis", "joystick", Robot.oi.operatorJoystick.getRawAxis(0));
	addStateDouble("Op-Lt-Y-axis", "joystick", Robot.oi.operatorJoystick.getRawAxis(1));
	addStateDouble("Op-Lt-Trigger", "joystick", Robot.oi.operatorJoystick.getRawAxis(2));
	addStateDouble("Op-Rt-Trigger", "joystick", Robot.oi.operatorJoystick.getRawAxis(3));
	addStateDouble("Op-Rt-X-axis", "joystick", Robot.oi.operatorJoystick.getRawAxis(4));
	addStateDouble("Op-Rt-Y-axis", "joystick", Robot.oi.operatorJoystick.getRawAxis(5));
	
	addStateBoolean("DS-White_Button","Button",Robot.oi.operatorControls.getRawButton(1));  
	addStateBoolean("DS-Black_Button","Button",Robot.oi.operatorControls.getRawButton(3));
	addStateBoolean("DS-Blue_Button","Button",Robot.oi.operatorControls.getRawButton(4));
	addStateBoolean("DS-Yellow_Button","Button",Robot.oi.operatorControls.getRawButton(5));
	addStateBoolean("DS-White_Switch","Switch",Robot.oi.operatorControls.getRawButton(6));
	addStateBoolean("DS-Black_Switch","Switch",Robot.oi.operatorControls.getRawButton(8));
	addStateBoolean("DS-Blue_Switch","Switch",Robot.oi.operatorControls.getRawButton(9));
	addStateBoolean("DS-Yellow_Switch","Switch",Robot.oi.operatorControls.getRawButton(10));
	
	addStateDouble("gyro-Fused-Heading", "gyro", RobotMap.gyro.getFusedHeading());
	addStateDouble("gyro-Yaw", "gyro", RobotMap.gyro.getYaw());
	addStateDouble("gyro-Angle", "gyro", RobotMap.gyro.getAngle());
	addStateDouble("gyro-Pitch", "gyro", RobotMap.gyro.getPitch());
	addStateDouble("gyro-Dipl-X", "gyro", RobotMap.gyro.getDisplacementX());
	
	addStateDouble("accelerometer-chassis", "accel", RobotMap.chassisPIDaccelerometer.getAcceleration());
	addStateDouble("stringpot-intake", "pot", RobotMap.shooterArmPIDshooterArmPot.get());
	addStateBoolean("ball sensor-intake", "sensor", RobotMap.intakeBallSensor.get());
	addStateDouble("ultrasonic sensor-inches","sensor 12 13",RobotMap.chassisPIDultrasonicSensor.getRangeInches());

	addStateBoolean("retractor-onPin","sensor",RobotMap.slidePINSensor.get());
	addStateBoolean("retractor-Primed","sensor",RobotMap.shooterRetractMotorA.isRevLimitSwitchClosed());
	addStateBoolean("retractor-Prepped tbd","sensor",RobotMap.shooterRetractMotorA.isFwdLimitSwitchClosed());
	
	addStateDouble("Left1-voltage","",RobotMap.chassisPIDchassisLeft1.getOutputVoltage());
	addStateDouble("Left1-current","",RobotMap.chassisPIDchassisLeft1.getOutputCurrent()); 
	addStateDouble("Right1-voltage","",RobotMap.chassisPIDchassisRight1.getOutputVoltage());
	addStateDouble("Right1-current","",RobotMap.chassisPIDchassisRight1.getOutputCurrent());
	
	addStateDouble("intakeArm-position","",RobotMap.intakeArmPIDMotorA.get());
	addStateDouble("intakeArm-setpoint","",RobotMap.intakeArmPIDMotorA.getSetpoint());
	addStateDouble("intakeArm-error","",RobotMap.intakeArmPIDMotorA.getError());
	addStateDouble("intakeArm-current","",RobotMap.intakeArmPIDMotorA.getOutputCurrent());
	addStateDouble("intakeArm-voltage","",RobotMap.intakeArmPIDMotorA.getOutputVoltage());
	
	addStateDouble("intakeMotor-get","",RobotMap.intakeintakeMotorA.get());
	addStateDouble("intakeMotor-current","",RobotMap.intakeintakeMotorA.getOutputCurrent());
	addStateDouble("intakeMotor-voltage","",RobotMap.intakeintakeMotorA.getOutputVoltage());
	
	addStateDouble("retractor-get","",RobotMap.shooterRetractMotorA.get());
	addStateDouble("retractor-setpoint","",RobotMap.shooterRetractMotorA.getSetpoint());
	addStateDouble("retractor-error","",RobotMap.shooterRetractMotorA.getError());
	addStateDouble("retractor-current","",RobotMap.shooterRetractMotorA.getOutputCurrent());
	addStateDouble("retractor-voltage","",RobotMap.shooterRetractMotorA.getOutputVoltage());
	addStateDouble("retractor-position","",RobotMap.shooterRetractMotorA.getEncPosition());
	
	//PCM
	//todo figure out DoubleSolenoid.Value (maybe write methods and track Booleans...
	addStateBoolean("high-Gear","",RobotMap.chassisShiftershiftSolenoid.get());//  0,0
	//addStateBoolean("PTO","",RobotMap.powerTakeOffptoSolenoid.get()); // (0, 2, 3);
	//addStateBoolean("shooterArm-solenoid","",RobotMap.linearAccElevatorSolenoidA.get());// (1, 1, 6);
	//addStateBoolean("shooter-Pin","",RobotMap.ShooterPneumaticPin.get());// (1, 2, 5);
	addStateBoolean("grapplingHook-Release","",RobotMap.grapplingHookRelease.equals("kForward"));//(1, 7, 0);
	///???? 
	addStateBoolean("leftArmLED","",RobotMap.leftArmLED.get());// (0, 7);
	addStateBoolean("gripLED","",RobotMap.ledGRIPCamera.get());// (1, 3);
	addStateBoolean("ballSensorLED","",RobotMap.ballSensorLED.get());//)(1,4);
	addStateBoolean("rightArmLED","",RobotMap.rightArmLED.get());// (0, 1);
	//addStateBoolean("retractor-position","",RobotMap.targetLightLight.get());// (0, Relay.Direction.kForward); "value"?
	
    //add PDP 	RobotMap.chassisPIDpowerDistributionPanel.getCurrent(1);  and ID must be 0
	addStateDouble("PDP 1","",RobotMap.chassisPIDpowerDistributionPanel.getCurrent(1));
	addStateDouble("PDP 2","",RobotMap.chassisPIDpowerDistributionPanel.getCurrent(2));
	addStateDouble("PDP 3","",RobotMap.chassisPIDpowerDistributionPanel.getCurrent(3));
	addStateDouble("PDP 4","",RobotMap.chassisPIDpowerDistributionPanel.getCurrent(4));
	addStateDouble("PDP 5","",RobotMap.chassisPIDpowerDistributionPanel.getCurrent(5));
	addStateDouble("PDP 5","",RobotMap.chassisPIDpowerDistributionPanel.getCurrent(6));
	addStateDouble("PDP 7","",RobotMap.chassisPIDpowerDistributionPanel.getCurrent(7));
	addStateDouble("PDP 8","",RobotMap.chassisPIDpowerDistributionPanel.getCurrent(8));
	addStateDouble("PDP 9","",RobotMap.chassisPIDpowerDistributionPanel.getCurrent(9));
	addStateDouble("PDP 10","",RobotMap.chassisPIDpowerDistributionPanel.getCurrent(10));
	addStateDouble("PDP 11","",RobotMap.chassisPIDpowerDistributionPanel.getCurrent(11));
	addStateDouble("PDP 12","",RobotMap.chassisPIDpowerDistributionPanel.getCurrent(12));
	addStateDouble("PDP 13","",RobotMap.chassisPIDpowerDistributionPanel.getCurrent(13));
	addStateDouble("PDP 14","",RobotMap.chassisPIDpowerDistributionPanel.getCurrent(14));
	addStateDouble("PDP 15","",RobotMap.chassisPIDpowerDistributionPanel.getCurrent(15));
	addStateDouble("PDP 16","",RobotMap.chassisPIDpowerDistributionPanel.getCurrent(16));
	
	//add BOOLEANS???
	
	
	//These two lines go last to close out entry.
	
	builder.setLength(Math.max(builder.length() - 1,0));  	//remove comma from last entry.
	builder.append("\n\t\t] },");							//close out ioinfo entry.
	
	}
	
	public static void finalStateSB() {
		
		//todo figure out how to print to kangaroo
		
		builder.setLength(Math.max(builder.length() - 1,0));  		//remove comma from last entry.
		builder.append("\n\t] \n} \n\n\n");								// close out JSON format
 
		try{
			if(bw_file!=null)
			 bw_file.close();
			System.out.println("Successfully Closed state String to File...");
			System.out.println("builder string: \n" + builder);
		   	}catch(Exception ex){
		       System.out.println("Error in closing the BufferedWriter"+ex);
		    }
		
		/*
		try (FileWriter file = new FileWriter("/home/lvuser/WildLog.txt")) {  //media/sda1 for usb
			file.write(builder.toString());
			System.out.println("Successfully Copied state String to File...");
			System.out.println("builder string: \n" + builder);
		}catch (IOException e) {
		    System.err.println("Caught IOException (ioinfo): " + e.getMessage());
		}	
		*/	
	}		
	
	public static void flushSB() {
		
		try{
			if(bw_file!=null)
			 bw_file.flush();
			System.out.println("Successfully flushed String to File...");
		   	}catch(Exception ex){
		       System.out.println("Error in flushing the BufferedWriter"+ex);
		    }
	}
	
	public static void addIOInfo(String name, String type, String direction, String port) {
		
		String m_name = name;
		String m_type = type;
		String m_direction = direction;
		String m_port = port;
 
		builder.append("\n\t{\"name\":\"");
		builder.append(m_name);
		builder.append("\",\"type\":\""); 
		builder.append(m_type);
		builder.append("\",\"direction\":\"");
		builder.append(m_direction);
		builder.append("\",\"port\":\"");
		builder.append(m_port);
		builder.append("\"}");		
		builder.append(",");	
	}
	
	public static void addStateBoolean(String name, String parent, boolean value) {
		
		String m_name = name;
		String m_parent = parent;
		boolean m_value = value;
 
		builder.append("\n\t\t{\"name\":\"");
		builder.append(m_name);
		builder.append("\",\"parent\":\""); 
		builder.append(m_parent);
		builder.append("\",\"value\":\"");
		builder.append(m_value);
		builder.append("\"},");		
	}
	
	public static void addStateInt(String name, String parent, int value) {
		
		String m_name = name;
		String m_parent = parent;
		int m_value = value;
 
		builder.append("\n\t\t{\"name\":\"");
		builder.append(m_name);
		builder.append("\",\"parent\":\""); 
		builder.append(m_parent);
		builder.append("\",\"value\":\"");
		builder.append(m_value);
		builder.append("\"},");		
	}
	
	public static void addStateDouble(String name, String parent, double value) {
		
		String m_name = name;
		String m_parent = parent;
		double m_value = value;
 
		builder.append("\n\t\t{\"name\":\"");
		builder.append(m_name);
		builder.append("\",\"parent\":\""); 
		builder.append(m_parent);
		builder.append("\",\"value\":\"");
		builder.append(m_value);
		builder.append("\"},");		
	}
	
}
