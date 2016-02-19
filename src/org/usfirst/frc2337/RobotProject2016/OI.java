
package org.usfirst.frc2337.RobotProject2016;

import org.usfirst.frc2337.RobotProject2016.commands.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;



/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

  //JOYSTICKS
    public Joystick driverJoystick;
    public Joystick operatorJoystick;
    public Joystick operatorControls;
    
  //BUTTON VARIABLES
    public int Green_A = 1;
    public int Red_B = 2;
    public int Blue_X = 3;
    public int Yellow_Y = 4; 
    public int Left_Bumper = 5;
    public int Right_Bumper = 6;
    public int Back_Button = 7;
    public int Start_Button = 8;
    public int Left_Stick_Button = 9;
    public int Right_Stick_Button = 10;
    //AXIS VARIABLES
    public int Left_Stick_X = 1; 			// right is positive on the axis.  Can also refer to as the X axis.
    public int LEft_Stick_Y = 2;			// forward is negative on the axis.  Can also refer to as the Y axis.
    public int Triggers = 3;				// Left trigger is positive, 1 to 0.  Right trigger is negative, 0 to -1.
    public int Right_Stick_X = 4;  			// right is positive on the axis.
    public int Right_Stick_Y = 5; 			// forward is negative on the axis.
    public int Dpad_X = 6;					// Direction Pad X axis value only.  Note: The Joystick class can only handle 6 axis

  //BUTTONS
    public JoystickButton intake;
    public JoystickButton driveWithGyro;
    public JoystickButton driveWithGyroAndEncoder;
    
    public JoystickButton energizeWrist;
    public JoystickButton intake_In;
    public JoystickButton intake_Out;
    public JoystickButton layup;
    public JoystickButton hookShot;
    public JoystickButton gripLed_On;
    public JoystickButton gripLed_Off;
    public JoystickButton target;
    public JoystickButton targetWithJ;
    
    public JoystickButton drive_Brake;
    
    public JoystickButton armSetPointBase;
    public JoystickButton armSetPointLongShot;
    public JoystickButton armSetPointShortShot;
    public JoystickButton armSetPointScale;
    
    public JoystickButton keypullout;
    public JoystickButton lowToHigh;
    public JoystickButton hightoLow;
    
    public JoystickButton ptest;
    
    
    public OI() {
    	
        driverJoystick = new Joystick(0);
        operatorJoystick = new Joystick(1);
        operatorControls = new Joystick(2);
        
        driveWithGyro = new JoystickButton(driverJoystick, Left_Bumper);
        driveWithGyro.whileHeld(new intake_ActivateMotors());
        
        driveWithGyroAndEncoder = new JoystickButton(driverJoystick, Right_Bumper);
        driveWithGyroAndEncoder.whenPressed(new chassis_DriveWithGyroNoTurn());



        target = new JoystickButton(driverJoystick, Start_Button);
        target.whenPressed(new chassis_TargetWithGyroPID());
        
        ptest = new JoystickButton(driverJoystick, Green_A);
        ptest.whenPressed(new GyroReset());

        lowToHigh = new JoystickButton(driverJoystick, Blue_X);
        lowToHigh.whenPressed(new chassisShifter_LowToHigh());
        
        hightoLow = new JoystickButton(driverJoystick, Yellow_Y);
        hightoLow.whenPressed(new chassisShifter_HighToLow());
        
        



        // SmartDashboard Buttons
       // SmartDashboard.putData("camera_DoNothing", new camera_DoNothing());


        /*
        
        
        
        energizeWrist = new JoystickButton(operatorJoystick, 4 );
        energizeWrist.whenPressed(new intakeWrist_Activate());
        
        layup = new JoystickButton(operatorJoystick, 7);
        layup.whenPressed(new shooter_Layup());
        
        hookShot = new JoystickButton(operatorJoystick, 8);
        hookShot.whenPressed(new shooter_HookShot());
        
        intake_In = new JoystickButton(operatorJoystick, 5);
        intake_In.whileHeld(new intake_Inhale());
        
        intake_Out = new JoystickButton(operatorJoystick, 6);
        intake_Out.whileHeld(new intake_Exhale());
        
        
        gripLed_On = new JoystickButton(operatorJoystick, Blue_X);
        gripLed_On.whileHeld(new led_GRIPOn());
        
        gripLed_Off = new JoystickButton(operatorJoystick, Yellow_Y);
        gripLed_Off.whileHeld(new led_GRIPOff());
        
        //Uses Switch to 'Change' state of CANTalon's, brake or coast.
        drive_Brake = new JoystickButton(driverJoystick, Green_A);
        drive_Brake.whenPressed(new chassis_DriveBrakePressed());
        drive_Brake.whenReleased(new chassis_DriveBrakeReleased());
        
        armSetPointBase = new JoystickButton(operatorControls, Back_Button);
        armSetPointBase.whenPressed(new shooterArm_armSetPointBase(1));
        
        armSetPointLongShot = new JoystickButton(operatorControls, Back_Button);
        armSetPointLongShot.whenPressed(new shooterArm_armSetPointBase(3));
       
        armSetPointShortShot = new JoystickButton(operatorControls, Back_Button);
        armSetPointShortShot.whenPressed(new shooterArm_armSetPointBase(4));
        
        armSetPointScale = new JoystickButton(operatorControls, Back_Button);
        armSetPointScale.whenPressed(new shooterArm_armSetPointBase(9));
        
        keypullout = new JoystickButton(operatorControls, Back_Button);
        keypullout.whenPressed(new scaler_pinPullOut());
        
  */
        
    }

    public Joystick getdriverJoystick() {
        return driverJoystick;
    }

    public Joystick getoperatorJoystick() {
        return operatorJoystick;
    }
    
    public Joystick getoperatorControls() {
        return operatorControls;
    }

}

