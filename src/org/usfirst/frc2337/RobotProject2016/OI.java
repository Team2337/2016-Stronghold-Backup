
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
    //TRIGGER VARIABLES
    public int Right_trigger = 2;
    public int Left_trigger = 3;


    //BUTTONS
    //driver
    public AnalogAxisButton shifter;
    public JoystickButton PTO;
    public JoystickButton portWheels;
    public JoystickButton shoot;
    public JoystickButton gryoDrive;
    public JoystickButton target;
    public AnalogAxisButton targetdrive;
   // operator button
    public AnalogAxisButton inhale;
    public AnalogAxisButton exhale;
    public JoystickButton light;
    public JoystickButton shortshot;
    public JoystickButton scale;
    public JoystickButton longshot;
    public JoystickButton travel;
    public JoystickButton base;
 
    
    
    
    public OI() {
    	
        driverJoystick = new Joystick(0);
        operatorJoystick = new Joystick(1);
        operatorControls = new Joystick(2);
        
        targetdrive = new AnalogAxisButton(driverJoystick, Left_trigger, 0.5);
        targetdrive.whileHeld(new chassis_TargetWithGyroPIDAndJoystick());
        
        shifter = new AnalogAxisButton(driverJoystick, Right_trigger, 0.5); 
        shifter.whenPressed(new chassisShifter_HighToLow());
        shifter.whenReleased(new chassisShifter_LowToHigh());
       
        PTO  = new JoystickButton(driverJoystick, Yellow_Y);
        PTO.whenPressed(new PTO_Activate());
        
       // portWheels = new JoystickButton(driverJoystick, Blue_X);
       // portWheels.whileHeld(new portWheels_activate());
        
        shoot = new JoystickButton(driverJoystick, Green_A);
        shoot.whenPressed(new shooter_ShootCG());
        
        gryoDrive = new JoystickButton(driverJoystick, Right_Bumper);
        gryoDrive.whileHeld(new chassis_DriveWithGyroNoTurn());
        
        target = new JoystickButton(driverJoystick, Left_Bumper);
        target.whenPressed(new chassis_TargetWithGyroPID());
        
        
        //operator button
        
        inhale = new AnalogAxisButton(operatorJoystick, Left_trigger, 0.5);
        inhale.whenPressed(new intake_Inhale());
        
        exhale = new AnalogAxisButton(operatorJoystick, Right_trigger, 0.5);
        exhale.whenPressed(new intake_Exhale());
        
       // light = new JoystickButton(operatorJoystick, Left_Bumper);
       // light.whenPressed(new target_Light());
     
        shortshot = new JoystickButton(operatorJoystick, Right_Bumper);
        shortshot.whenPressed(new shooterArm_armSetPointShortShot());
        
        scale = new JoystickButton(operatorJoystick, Yellow_Y);
        scale.whenPressed(new shooterArm_armSetPointScale());
        
        longshot = new JoystickButton(operatorJoystick, Red_B);
        longshot.whenPressed(new shooterArm_armSetPointLongShot());
        
        travel = new JoystickButton(operatorJoystick, Blue_X);
        travel.whenPressed(new shooterArm_armSetPointTravel());
        
        base = new JoystickButton(operatorJoystick, Green_A);
        base.whenPressed(new shooterArm_armSetPointBase());
        
        
        
        
        
        
     /*   
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
        */
        



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

