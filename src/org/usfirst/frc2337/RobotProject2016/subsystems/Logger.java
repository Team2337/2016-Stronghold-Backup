package org.usfirst.frc2337.RobotProject2016.subsystems;

import org.usfirst.frc2337.RobotProject2016.OI;
import org.usfirst.frc2337.RobotProject2016.RobotMap;
import org.usfirst.frc2337.RobotProject2016.commands.*;

import edu.wpi.first.wpilibj.command.Subsystem;

import java.io.FileWriter;
import java.io.IOException;

public class Logger extends Subsystem {
	
	public static StringBuilder builder = new StringBuilder();
	
	protected void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
		
		/*
		IOInfoSB();  	//init
		stateSB();   	//default command, maybe add counter/delay
		finalStateSB();	// in disable?  call more often in case of crash?  longer counter in default command??
						//boolean to track if printed to file so as to not double close file???
		*/
		
	}
	
	
public static void IOInfoSB() {
		
		//'name' to match name in 'state' section.
		// direction' = Input/Output.  
		// All others for information only.
		// Add a line for every item to be logged. 
		
		builder.append("{\"ioinfo\":[\n");
		
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
		
		
		builder.setLength(Math.max(builder.length() - 1,0));  	//remove comma from last entry.
		builder.append("\n\t]");								//close out ioinfo entry.
		builder.append("\n\"state\":[\n");						//start state entries.
	}
	
public static void stateSB() {  
	
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
	
	builder.setLength(Math.max(builder.length() - 1,0));  	//remove comma from last entry.
	builder.append("\n\t\t] },");							//close out ioinfo entry.
	
	}
	
	public static void finalStateSB() {
		
		builder.append("\t] \n}");			// close out JSON format
 
		// try
		try (FileWriter file = new FileWriter("/Users/Robin/Documents/file3.txt")) {
			file.write(builder.toString());
			System.out.println("Successfully Copied state String to File...");
			System.out.println("builder string: \n" + builder);
		}catch (IOException e) {
		    System.err.println("Caught IOException (ioinfo): " + e.getMessage());
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
		
		// have method for int, double, boolean & ???object??? et.al...
		
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
		
		// have method for int, double, boolean & ???object??? et.al...
		
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
		
		// have method for int, double, boolean & ???object??? et.al...
		
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
