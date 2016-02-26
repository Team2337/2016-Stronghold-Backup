
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
    public int Right_trigger = 3;
    public int Left_trigger = 2;


    //BUTTONS
    //driver
    public AnalogAxisButton shifter;
    public JoystickButton PTO;
    public JoystickButton portWheels;
    //public JoystickButton shoot;
    public AnalogAxisButton shoot;
    public JoystickButton gryoDrive;
    public JoystickButton target;
    public JoystickButton targetdrive;
   // operator button
    public AnalogAxisButton inhale;
    public AnalogAxisButton exhale;
    public JoystickButton light;
    public JoystickButton shortshot;
    public JoystickButton scale;
    public JoystickButton longshot;
    public JoystickButton travel;
    public JoystickButton base;
    public JoystickButton retractorManualUp;
    public JoystickButton retractorManualDown;
    public JoystickButton intakePreLoad;
    public JoystickButton wrist;
    public JoystickButton intakeDoNo;
 
    
    
    
    public OI() {
    	
        driverJoystick = new Joystick(0);
        operatorJoystick = new Joystick(1);
        operatorControls = new Joystick(2);
        
        shoot = new AnalogAxisButton(driverJoystick, Right_trigger, 0.5);
        shoot.whenPressed(new shooter_ShootCG());
        
        gryoDrive = new JoystickButton(driverJoystick, Left_Bumper);
        gryoDrive.whileHeld(new chassis_DriveWithGyroNoTurn());
        
        targetdrive = new JoystickButton(driverJoystick, Right_Bumper);
        targetdrive.whileHeld(new chassis_TargetWithGyroPIDAndJoystick());
        
        shifter = new AnalogAxisButton(driverJoystick, Left_trigger, 0.5); 
        shifter.whenPressed(new chassisShifter_HighToLow());
        shifter.whenReleased(new chassisShifter_LowToHigh());
        
        // retractorManualUp = new JoystickButton(driverJoystick, Red_B);
        // retractorManualUp.whenPressed(new shooterRetract_Prep());
         
        // retractorManualDown = new JoystickButton(driverJoystick, Blue_X);
        // retractorManualDown.whenPressed(new shooterRetract_Prime());
         
         //wrist = new JoystickButton(driverJoystick, Left_Bumper);
         //wrist.whenPressed(new intakeWrist_Extend());
         //wrist.whenReleased(new intakeWrist_Retract());
        
        //intakePreLoad = new JoystickButton(driverJoystick, Start_Button);
        //intakePreLoad.whenPressed(new intake_inhaleCG());
        //intakePreLoad.whenReleased(new intake_DoNothing());
       
        //PTO  = new JoystickButton(driverJoystick, Yellow_Y);**********commentd out for retractor testing*****
        //PTO.whenPressed(new PTO_Activate());
        
        //portWheels = new JoystickButton(driverJoystick, Blue_X);
        //portWheels.whileHeld(new portWheels_activate());
        
        //shoot = new JoystickButton(driverJoystick, Green_A);     **********commentd out for retractor testing*****
        //shoot.whenPressed(new shooter_ShootCG());
        
        
        //target = new JoystickButton(driverJoystick, Left_Bumper);
       // target.whenPressed(new chassis_TargetWithGyroPID());
        
        //remove before production*										************************
        //PTO  = new JoystickButton(driverJoystick, Yellow_Y);        // *****************************
        //PTO.whenPressed(new shooterRetractor_adjustSetpointUp()) ;	//*******************
        //shoot = new JoystickButton(driverJoystick, Green_A);   		//  ***************
        //shoot.whenPressed(new shooterRetractor_adjustSetpointDown());				//**************************
        
        
        //retractorManualUp = new JoystickButton(driverJoystick, Red_B);
        //retractorManualUp.whileHeld(new shooterRetract_PrepManual());******************
        //retractorManualUp.whenPressed(new shooterRetract_Prep());
        
        //retractorManualDown = new JoystickButton(driverJoystick, Blue_X);
        //retractorManualDown.whileHeld(new shooterRetract_PrimeManual());
        //retractorManualDown.whenPressed(new shooterRetract_Prime());
        
        //operator button
        
        inhale = new AnalogAxisButton(operatorJoystick, Right_trigger, 0.5);
        inhale.whileHeld(new intake_Inhale());
        
        exhale = new AnalogAxisButton(operatorJoystick, Left_trigger, 0.5);
        exhale.whileHeld(new intake_Exhale());
        
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
        
        wrist = new JoystickButton(operatorJoystick, Left_Bumper);
        wrist.whenPressed(new intakeWrist_Extend());
        wrist.whenReleased(new intakeWrist_Retract());
        
        intakeDoNo = new JoystickButton(operatorJoystick, Start_Button);
        intakeDoNo.whenPressed(new intake_DoNothing());
        
        //light = new JoystickButton(operatorJoystick, Left_Bumper);
        //light.whenPressed(new target_LightActivate());
        //light.whenReleased(new target_LightDeactivate());       
        
        
        //*****************************  test retractor on 3rd Joystick ******************
        
        //remove before production*	************************
        /*
        PTO  = new JoystickButton(operatorControls, Yellow_Y);        
        PTO.whenPressed(new shooterRetractor_adjustSetpointUp()) ;
        
        shoot = new JoystickButton(operatorControls, Green_A);   				
        shoot.whenPressed(new shooterRetractor_adjustSetpointDown());				
        
        
        retractorManualUp = new JoystickButton(operatorControls, Red_B);
        retractorManualUp.whenPressed(new shooterRetract_Prep());
        
        retractorManualDown = new JoystickButton(operatorControls, Blue_X);
        retractorManualDown.whenPressed(new shooterRetract_Prime());
        
        light = new JoystickButton(operatorControls, Left_Bumper);
        light.whenPressed(new intakeWrist_Extend());
        light.whenReleased(new intakeWrist_Retract());
        
        intakePreLoad = new JoystickButton(operatorControls, Start_Button);
        intakePreLoad.whenPressed(new shooterRetractor_enablePID());
        
        base = new JoystickButton(operatorControls, Back_Button);
        base.whenPressed(new shooterRetractor_disbablePID());
   
        shoot = new JoystickButton(operatorControls, Right_Bumper);   
        shoot.whenPressed(new shooter_ShootCG());
        */
        
        //************************************************************************************************
        
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

